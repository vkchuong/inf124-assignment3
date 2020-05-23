<%@ page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.jsp" />
<div class="main">
    <div class="container">
        <div class="content confirmation">
            <div style="display: flex;">
                <div class="detail">
                    <%
                        int orderId = (Integer)request.getAttribute("orderID");
                        Connection con = null;
                        Statement stm = null;
                        ResultSet rs = null;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project3", "root", "");
                            stm = con.createStatement();
                            rs = stm.executeQuery("SELECT * FROM `orders` WHERE `id` = '" + orderId + "'");
                            while (rs.next()) {
                            %>
                            <h2>Order Information</h2>
                            <p>Order ID: <%=rs.getString("id")%></p>
                            <p>Email: <%=rs.getString("email")%></p>
                            <p>Phone Number : <%=rs.getString("phone")%></p>

                            <h2>Product Information</h2>
                            <p>Product: <%=rs.getString("productid")%></p>
                            <p>Quantity: <%=rs.getString("quantity")%></p>
                            <p>Total Price: <%=rs.getString("price")%></p>

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
                    %>
                </div>
                <div>
                    <img src="assets/baseketball.jpg" class="thumbnail" width="175"
                         alt="Basketball" style="margin-left:100px;margin-top: 100px;"/>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
<jsp:include page="components/footer.html" />