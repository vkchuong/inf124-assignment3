<%@page import="com.s2020iae.project3.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
<% Product p = (Product)request.getAttribute("cartData"); %>
    <div class="main">
        <div class="content">
        <h1>Cart</h1>    
                    <h1><p><%=p.getName()%></p></h1>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		
			<c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
                                <td><p><%=p.getId()%></p></td>
                                <td><p><%=p.getName()%></p></td>		
				<td>
					<img src="./assets/<%=p.getThumbnail()%>" width="120">
				</td>
				<td><p><%=p.getPrice()%></p></td>
				<td>0</td>
				<td><%=p.getPrice()%> * 2 </td>
			</tr>
		
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
        </div>
    </div>
<jsp:include page="components/footer.html" />