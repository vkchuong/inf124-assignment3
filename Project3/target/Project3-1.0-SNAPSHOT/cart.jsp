<%@page import="com.s2020iae.project3.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
    <div class="main">
        <div class="content cart">
            <h1>Cart</h1>
            <% if(request.getAttribute("isEmpty") == "yes") { %>
                <h3>Your cart is empty</h3>
            <% } else { %>
    	    <table border="1" width="100%">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>thumbnail</th>
                    <th>category</th>
                    <th>price</th>
                    <th>summary</th>
                </tr>
                    <%ArrayList<Product> tracks =
                        (ArrayList<Product>)request.getAttribute("cartData");
                        for(Product p:tracks){
                    %>
                    <tr>
                        <td><%=p.getId()%></td>
                        <td><%=p.getName()%></td>
                        <td><img src="./assets/<%=p.getThumbnail()%>" height="75"></td>
                        <td><%=p.getCategory()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getSummary()%></td>
                    </tr>
                    <%}%>
    	    </table>
            <% } %>
        </div>
    </div>
<jsp:include page="components/footer.html" />