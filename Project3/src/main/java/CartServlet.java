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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author chuon
 */
@WebServlet(urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
                    // End Store to session

//                    request.setAttribute("data", pd);
//                    RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
//                    rd.include(request, response);
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
            RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
            rd.include(request, response);
        }

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
