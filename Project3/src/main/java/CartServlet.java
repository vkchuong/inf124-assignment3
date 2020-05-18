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
        response.setContentType("text/html;charset=UTF-8");
        System.out.print("poop");
//        Connection con = null;
//        Statement stm = null;
//        ResultSet rs = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
//            stm = con.createStatement();
//            rs = stm.executeQuery("SELECT * FROM products LIMIT 0,5");
//            ArrayList<Product> newProduct = new ArrayList<Product>();
//            while(rs.next()) {
//                newProduct.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("summary"), rs.getString("thumbnail"), rs.getString("category"), rs.getString("detail"), rs.getFloat("price")));
//            }
//            request.setAttribute("data", newProduct);
//
//            HttpSession session = request.getSession();
//            if(null != session.getAttribute("cart")) { // Create new if not exist
//                ArrayList<Product> trackList = (ArrayList<Product>)(session.getAttribute("cart"));
//                request.setAttribute("trackData", trackList);
//                request.setAttribute("historyTitle", "BROWSER HISTORY");
//            } else {
//                rs = stm.executeQuery("SELECT * FROM products LIMIT 5,5");
//                ArrayList<Product> topSell = new ArrayList<Product>();
//                while(rs.next()) {
//                    topSell.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("summary"), rs.getString("thumbnail"), rs.getString("category"), rs.getString("detail"), rs.getFloat("price")));
//                }
//                request.setAttribute("trackData", topSell);
//                request.setAttribute("historyTitle", "TOP SELL");
//            }
//
//        } catch (SQLException ex) {
//            System.out.print(ex);
//        } catch (ClassNotFoundException ex) {
//            System.out.print(ex);
//        }

        RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
        rd.include(request, response);
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
