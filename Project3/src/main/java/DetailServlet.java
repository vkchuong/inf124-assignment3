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

/**
 *
 * @author chuon
 */
@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
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
                    if(null == session.getAttribute("tracking")){ // new sesstion initial
                        session = request.getSession(true);
                        trackList = new ArrayList<Product>();
                    } else { // restore from previous sesstion
                        trackList = (ArrayList<Product>)session.getAttribute("tracking");
                        if(trackList.size() > 4) {
                            trackList.remove(0);
                        }
                    }
                    trackList.add(pd);
                    session.setAttribute("tracking", trackList);// save session

                request.setAttribute("data", pd);
                RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
                rd.include(request, response);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
    }
}
