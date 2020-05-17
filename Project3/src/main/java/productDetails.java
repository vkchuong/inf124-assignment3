/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.s2020iae.project3.Product;
import com.s2020iae.project3.Items;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anon
 */

public class productDetails extends HttpServlet {



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
        ResultSet cartItems = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
            stm = con.createStatement();
            cartItems = stm.executeQuery("SELECT * FROM products WHERE `id` = '" + id + "'");
            while(cartItems.next()) {
                Product pd = new Product(cartItems.getInt("id"), cartItems.getString("name"), cartItems.getString("summary"), cartItems.getString("thumbnail"), cartItems.getString("category"), cartItems.getString("detail"), cartItems.getFloat("price"));
                
                    ArrayList<Product> cartlist;
                    HttpSession session = request.getSession(false);
                    if(null == session.getAttribute("cart")){ // new sesstion initial
                        session = request.getSession(true);
                        cartlist = new ArrayList<Product>();
                    } else { // restore from previous sesstion 
                        cartlist = (ArrayList<Product>)session.getAttribute("cart");
                        for (Product p: cartlist) { 
                            System.out.println(p.getName()); 
                        }
                    }
                    cartlist.add(pd);
                    session.setAttribute("cart", cartlist);// save session
                                        
                request.setAttribute("data", pd);
                Items item = new Items(pd,1,pd.getPrice());
                RequestDispatcher dispatch = request.getRequestDispatcher("/chart.jsp");
                dispatch.include(request, response);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
       
        String userAction=request.getParameter("userAction");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
