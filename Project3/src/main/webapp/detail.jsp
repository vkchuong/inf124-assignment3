<%@page import="com.s2020iae.project3.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
<% Product p = (Product)request.getAttribute("data"); %>
    <div class="main">
        <div class="content">
            <h1><%=p.getName()%></h1>
            <table width="100%" cellspacing="20">
                <tbody>
                    <tr>
                        <td width="30%" style="text-align: center;">
                            <img src="./assets/<%=p.getThumbnail()%>" class="thumbnail" width="250" alt="<%=p.getName()%>" />
                        </td>
                        <td style="display: inline-block;">
                            <h4>Name:</h4>
                            <p><%=p.getName()%></p> 
                            <h4>Category:</h4>
                            <p><%=p.getCategory()%></p>
                            <h4>Price:</h4>
                            <p id="unitPrice"><%=p.getPrice()%></p>           
                            <a href="cart?id=${param.id}" class="addtocart">Add To Cart</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            <h1>Details</h1>
            <div class="detail">
                <p>NBA and NCAA-approved Basketball.<br />
                    Become like one of the pros with this NBA-approved Basketball! Improved durable exterior for extend play.
                    Great for indoor or outdoor games.</p>
                <ul>
                    <li>For indoor/outdoor play</li>
                    <li>Ideal size for adults</li>
                    <li>Composite cover for various surfaces</li>
                    <li>Replica NBA Basketball</li>
                </ul>
            </div>
        </div>
    </div>
<jsp:include page="components/footer.html" />