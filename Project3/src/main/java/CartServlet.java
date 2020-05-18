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
        System.out.print("poop");
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM products WHERE `id` = '" + id + "'");
            while(rs.next()) {
                Product pd = new Product(rs.getInt("id"), rs.getString("name"), rs.getString("summary"), rs.getString("thumbnail"), rs.getString("category"), rs.getString("detail"), rs.getFloat("price"));
                
                    ArrayList<Product> trackList;
                    HttpSession session = request.getSession(false);
                    if(null == session.getAttribute("cartItems")){ // new sesstion initial
                        session = request.getSession(true);
                        trackList = new ArrayList<Product>();
                    } else { // restore from previous sesstion 
                        trackList = (ArrayList<Product>)session.getAttribute("cartItems");
                                               
                        for (Product p: trackList) { 
                            System.out.println(p.getName()); 
                        }
                    }
                    trackList.add(pd);
                    session.setAttribute("cartItems", trackList);// save session
                                        
                request.setAttribute("cartData", pd);
                Items item = new Items(pd,1);
                RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
                rd.include(request, response);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }

        //RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
        //rd.include(request, response);
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
