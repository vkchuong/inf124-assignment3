<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.jsp" />
<jsp:include page="components/header.jsp" />
<div class="main">
    <div class="container">
        <div class="content">
            <h1>Track your order</h1>
        </div>
        <div class="content confirmation">
            <div class="detail">
                <%
                    int orderId = (Integer)request.getAttribute("orderID");
                    Connection con = null;
                    Statement stm = null;
                    ResultSet rs = null;
                    boolean orderExist = false;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vinh");
                        stm = con.createStatement();
                        rs = stm.executeQuery("SELECT * FROM `orders` WHERE `id` = '" + orderId + "'");
                        while (rs.next()) {
                            orderExist = true;
                        %>
                        <h2>Order Information</h2>
                        <p>Order ID: <%=rs.getString("id")%></p>
                        <p>Email: <%=rs.getString("email")%></p>
                        <p>Phone Number: <%=rs.getString("phone")%></p>
                        <p>Total Price: $<%=rs.getFloat("price")%></p>

                        <h2>Shipping Information</h2>
                        <p>First Name: <%=rs.getString("firstname")%></p>
                        <p>Last Name: <%=rs.getString("lastname")%></p>
                        <p>Method: <%=rs.getString("method")%></p>
                        <p>Address: <%=rs.getString("address")%></p>
                        <p>City: <%=rs.getString("city")%></p>
                        <p>State: <%=rs.getString("state")%></p>
                        <p>Zip Code: <%=rs.getString("zip")%></p>

                        <%
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    if(orderExist == true) {
                %>
            </div>
            <div class="confirmTable">
                <h2>Product Information</h2>
                <table id="cartTable" border="1" width="100%" class="all-align">
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>thumbnail</th>
                        <th>category</th>
                        <th>price</th>
                        <th>summary</th>
                    </tr>
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "vinh");
                        stm = con.createStatement();
                        rs = stm.executeQuery("SELECT `orders`.*, `items`.*, `products`.`id` as `pid`, `products`.* " +
                                "FROM `orders` " +
                                "INNER JOIN `items` ON `orders`.`id`=`items`.`orderid` " +
                                "INNER JOIN `products` ON `items`.`productid`=`products`.`id` " +
                                "WHERE `orders`.`id` = '" + orderId + "'");
                        while (rs.next()) {
                %>
                    <tr>
                        <td><%=rs.getInt("pid")%></td>
                        <td><%=rs.getString("name")%></td>
                        <td><img src="./assets/<%=rs.getString("thumbnail")%>" height="50"></td>
                        <td><%=rs.getString("category")%></td>
                        <td><%=rs.getFloat("price")%></td>
                        <td><%=rs.getString("summary")%></td>
                    </tr>
                <%
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                %>
                </table>
                <%  } else { %>
                    <h3 class="all-align">This order is not exist. Please make sure your input correct order ID.</h3>
                <%  } %>
            </div>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp" />