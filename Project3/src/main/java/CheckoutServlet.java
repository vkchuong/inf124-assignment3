/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.s2020iae.project3.Product;
import com.s2020iae.project3.Items;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chuon
 */
public class CheckoutServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                System.out.println(p.getName());
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
        
        // <editor-fold defaultstate="collapsed" desc="Handle POST requests for /checkout (Extract Data, Insert Data, Forward call)">
        System.out.println("PARAM VALUES:");
        Map<String, String> paramMap = new HashMap<String, String>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String currParamName = paramNames.nextElement();
            String currParamValue = request.getParameter(currParamName);
            paramMap.put(currParamName, currParamValue);
            System.out.println(currParamName +" : "+ paramMap.get(currParamName));
        }
        
        // INSERT all form params in Orders Table
        Connection con = null;
        Statement stm = null;
        int numOfRowsAffected = -1;
        int orderId = -1; // in case INSERT fails, default orderId=-1
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
            stm = con.createStatement();
            if (paramMap.get("billzip").isEmpty()){
                paramMap.put("billzip", paramMap.get("zip"));
                paramMap.put("billstate", paramMap.get("state"));
                paramMap.put("billaddr", paramMap.get("address"));
                paramMap.put("billcity", paramMap.get("city"));
            }
                
            String query = "INSERT INTO orders (`firstname`, `lastname`, `email`, `phone`, `address`, `city`, `state`, `zip`, `billaddr`, `billcity`, `billstate`, `billzip`, `method`, `productid`, `quantity`, `cardname`, `cardnumber`, `expmonth`, `expyear`, `cvv`, `price`) VALUES ('"+paramMap.get("firstname")+"','"+paramMap.get("lastname")+"','"+paramMap.get("email")+"','"+paramMap.get("phone")+"','"+paramMap.get("address")+"','"+paramMap.get("city")+"','"+paramMap.get("state")+"','"+paramMap.get("zip")+"','"+paramMap.get("billaddr")+"','"+paramMap.get("billcity")+"','"+paramMap.get("billstate")+"','"+paramMap.get("billzip")+"','"+paramMap.get("method")+"','"+paramMap.getOrDefault("productId","1")+"','"+paramMap.getOrDefault("quantity","1")+"','"+paramMap.get("cardname")+"','"+paramMap.get("cardnumber")+"','"+paramMap.get("expmonth")+"','"+paramMap.get("expyear")+"','"+paramMap.get("cvv")+"','"+paramMap.get("totalPrice")+"')";
            System.out.println(query);
            numOfRowsAffected = stm.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            
            if (rs.next()){
                orderId = rs.getInt(1);
            }
            System.out.println("Order ID #: " + orderId);
            System.out.println("Num Of Rows Affected: "+numOfRowsAffected);
            
            HttpSession session = request.getSession();
            session.invalidate();
            
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
                
        // Forward this POST request as a GET request to Confirmation Servlet
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
        // We need to send this param to the ConfirmationServlet.java
        //request.setAttribute("orderId", orderId);
        rd.forward(request, response);              
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
