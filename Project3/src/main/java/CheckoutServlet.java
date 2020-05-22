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
        double tax = 0.00;
        int numOfItems = 0;
        if(null != session.getAttribute("cartItems")) {
            ArrayList<Product> cartList = (ArrayList<Product>)(session.getAttribute("cartItems"));
            request.setAttribute("cartData", cartList);
            for (Product p: cartList) {
               // System.out.println(p.getName());
               //System.out.println();
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
        
        //add the state tax based on zipcode
        String zip = request.getParameter("billzip");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        if(zip!=null)
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
                stm = con.createStatement();
                rs = stm.executeQuery("SELECT * FROM tax WHERE `zipcode` = '" + zip + "'");
                while(rs.next())//only one tax rate but while loop still used although not necessary
                {
                    session.setAttribute("userTax", rs.getFloat("rate"));//add the state tax to current session
                    tax = rs.getFloat("rate");
                    
                }
                
            }
            catch(SQLException ex) {
                System.out.print(ex);
            } catch (ClassNotFoundException ex) {
                System.out.print(ex);
            }
        }
        //else condition will occur if no zipcode is found; thus region tax cannot be added
        else
        {
            Float nill = new Float(0.00);
            session.setAttribute("userTax",nill);
        }
        System.out.println("Hello");
        //end of adding state tax to total
        
        //calculate total
            
        //end of total calculations
        RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");
        rd.include(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("PARAM VALUES:");
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String currParamName = paramNames.nextElement();
            String currParamValue = request.getParameter(currParamName);
            System.out.println(currParamName +" : "+ currParamValue);
        }
        // LOGIC
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/confirmation.jsp");
        rd.forward(request, response);
        //RequestDispatcher sendConf = getServletContext().getRequestDispatcher("/confirmation.jsp");
        System.out.println(request.getAttribute("subTotal"));
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
