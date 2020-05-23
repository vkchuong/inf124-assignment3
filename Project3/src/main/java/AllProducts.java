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
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author chuon
 */
@WebServlet(name = "ProductsServlet", urlPatterns = {"/products"})
public class AllProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM products");
            ArrayList<Product> newProduct = new ArrayList<Product>();
            while(rs.next()) {
                newProduct.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getString("summary"), rs.getString("thumbnail"), rs.getString("category"), rs.getString("detail"), rs.getFloat("price")));
            }
            request.setAttribute("data", newProduct);
        } catch (SQLException ex) {
            System.out.print(ex);
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/products.jsp");
        rd.include(request, response);
    }
}
