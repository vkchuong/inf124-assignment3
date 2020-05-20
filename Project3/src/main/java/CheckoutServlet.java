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
        
        // LOGIC
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
        rd.forward(request, response);
//        form Data   request.getParams()
//                
//        name, final price, = extract form Data
//        
//        SQL(insert, -- orders , , )
//        
//        order conf # = getLastId(orders) 
//        
//        forward(confirm.jsp, order conf #)
//                
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
