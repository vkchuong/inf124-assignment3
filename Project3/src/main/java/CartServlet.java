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
import java.util.List;

/**
 *
 * @author chuon
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        if(id != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
                stm = con.createStatement();
                rs = stm.executeQuery("SELECT * FROM products WHERE `id` = '" + id + "'");
                while(rs.next()) {
                    Product pd = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("summary"), rs.getString("thumbnail"), rs.getString("category"), rs.getString("detail"), rs.getFloat("price"));
                    // Begin Store to session
                        ArrayList<Product> cartList;
                        HttpSession session = request.getSession(false);
                        if(null == session.getAttribute("cartItems")){ // new sesstion initial
                            session = request.getSession();
                            cartList = new ArrayList<Product>();
                        } else { // restore from previous sesstion
                            cartList = (ArrayList<Product>)session.getAttribute("cartItems");
                        }
                        cartList.add(pd);
                        session.setAttribute("cartItems", cartList);// save session
                    String site = new String("./cart");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
            } catch (SQLException ex) {
                System.out.print(ex);
            } catch (ClassNotFoundException ex) {
                System.out.print(ex);
            }
        } else {
            HttpSession session = request.getSession();
            double subTotal = 0.00;
            int numOfItems = 0;
            if(null != session.getAttribute("cartItems")) {
                ArrayList<Product> cartList = (ArrayList<Product>)(session.getAttribute("cartItems"));
                for (Product p: cartList) {
                    subTotal += p.getPrice();
                }
                request.setAttribute("cartData", cartList);
                request.setAttribute("isEmpty", "no");
                numOfItems = cartList.size();
            } else {
                request.setAttribute("isEmpty", "yes");
            }
            subTotal = Math.round(subTotal*100.0)/100.0;
            request.setAttribute("subTotal", String.format("%.2f", subTotal));
            request.setAttribute("numOfItems",numOfItems);
            RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
            rd.include(request, response);
        }

    }
}
