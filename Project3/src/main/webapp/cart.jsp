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
    	    <table id="cartTable" border="1" width="100%">
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
            <br>
            <p style="text-align: right; font-weight: 1.2rem;">Subtotal (n items): </p>
            <p style="text-align: right; font-weight: 1.2rem;" id="totalPrice"></p>
            <br>
            <script>
                var table = document.getElementById("cartTable");
                var totalSum = 0.0;
                for (var i = 1; i < table.rows.length; i++){
                    totalSum += parseFloat(table.rows[i].cells[4].innerHTML);
                }
                document.getElementById("totalPrice").innerHTML = totalSum;
            </script>
        </div>
    </div>
<jsp:include page="components/footer.html" />