import com.s2020iae.project3.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chuon
 */
@WebServlet(name = "ConfirmationServlet", urlPatterns = {"/checkout"})
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        double subTotal = 0.00;
        int numOfItems = 0;
        if(null != session.getAttribute("cartItems")) {
            ArrayList<Product> cartList = (ArrayList<Product>)(session.getAttribute("cartItems"));
            request.setAttribute("cartData", cartList);
            for (Product p: cartList) {
                subTotal += p.getPrice();
            }
            request.setAttribute("isEmpty", "no");
            numOfItems = cartList.size();
        } else {
            request.setAttribute("isEmpty", "yes");
        }
        subTotal = Math.round(subTotal*100.0)/100.0;
        request.setAttribute("subTotal", String.format("%.2f", subTotal));
        request.setAttribute("numOfItems",numOfItems);

        RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");
        rd.include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String> paramMap = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String currParamName = paramNames.nextElement();
            String currParamValue = request.getParameter(currParamName);
            if(currParamName.equals("zip"))
                currParamValue = currParamValue.substring(0, 5);
            paramMap.put(currParamName, currParamValue);
        }

        Connection con = null;
        int orderId = -1; // in case INSERT fails, default orderId=-1
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
            if (paramMap.get("billzip").isEmpty()){
                paramMap.put("billzip", paramMap.get("zip"));
                paramMap.put("billstate", paramMap.get("state"));
                paramMap.put("billaddr", paramMap.get("address"));
                paramMap.put("billcity", paramMap.get("city"));
            } else {
                String tempZip = paramMap.get("billzip").substring(0, 5);
                paramMap.remove("billzip");
                paramMap.put("billzip", tempZip);
            }

            String query = "INSERT INTO orders (`firstname`, `lastname`, `email`, `phone`, `address`, `city`, `state`, `zip`, " +
                    "`billaddr`, `billcity`, `billstate`, `billzip`, " +
                    "`method`, `cardname`, `cardnumber`, `expmonth`, `expyear`, `cvv`, `price`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                st.setString(1, paramMap.get("firstname"));
                st.setString(2, paramMap.get("lastname"));
                st.setString(3, paramMap.get("email"));
                st.setString(4, paramMap.get("phone"));
                st.setString(5, paramMap.get("address"));
                st.setString(6, paramMap.get("city"));
                st.setString(7, paramMap.get("state"));
                st.setInt(8, Integer.parseInt(paramMap.get("zip")));
                st.setString(9, paramMap.get("billaddr"));
                st.setString(10, paramMap.get("billcity"));
                st.setString(11, paramMap.get("billstate"));
                st.setInt(12, Integer.parseInt(paramMap.get("billzip")));
                st.setString(13, paramMap.get("method"));
                st.setString(14, paramMap.get("cardname"));
                st.setString(15, paramMap.get("cardnumber"));
                st.setInt(16, Integer.parseInt(paramMap.get("expmonth")));
                st.setInt(17, Integer.parseInt(paramMap.get("expyear")));
                st.setInt(18, Integer.parseInt(paramMap.get("cvv")));
                st.setFloat(19, Float.parseFloat(paramMap.get("totalPrice")));

                st.executeUpdate();
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    orderId = rs.getInt(1);

                    HttpSession session = request.getSession();
                    ArrayList<Product> cartList = (ArrayList<Product>)(session.getAttribute("cartItems"));
                    String itemQuery = "INSERT INTO items (`orderid`, `productid`) VALUES (?, ?)";
                    PreparedStatement st2 = con.prepareStatement(itemQuery);
                    con.setAutoCommit(false);
                    for (Product p: cartList) {
                        st2.setInt( 1, orderId );
                        st2.setInt( 2, p.getId() );
                        st2.addBatch();
                    }
                    st2.executeBatch();
                    con.commit();
                }
            } catch (SQLException e) {
                System.out.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            request.setAttribute("customerInfo", paramMap);
            request.setAttribute("orderID", orderId);
            RequestDispatcher rd = request.getRequestDispatcher("confirmation");
            rd.forward(request, response);

            session.invalidate();
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
    }
}
