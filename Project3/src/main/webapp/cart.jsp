<%@page import="com.s2020iae.project3.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
<% Product p = (Product)request.getAttribute("data"); %>
    <div class="main">
        <div class="content">

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
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
				<td align="center">
					<a href="${pageContext.request.contextPath }/cart?action=remove&id=${item.product.id }"
					onclick="return confirm('Are you sure?')">Remove</a>
				</td>
				<td>${item.product.id }</td>
				<td>${item.product.name }</td>
				<td>
					<img src="${pageContext.request.contextPath }/assets/images/${item.product.photo }" width="120">
				</td>
				<td>${item.product.price }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
           </div>
    </div>