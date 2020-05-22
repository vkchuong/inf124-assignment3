<%@page import="com.s2020iae.project3.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
        <div class="main">
            <div class="content">
                <h1>New Products</h1>
                <table width="100%" height="100%" cellspacing="20">
                    <tbody>
                        <tr>
                        <%ArrayList<Product> std =
                            (ArrayList<Product>)request.getAttribute("data");
                            for(Product p:std){%>
                            <jsp:include page="components/product.jsp" flush="true">
                                <jsp:param name="id" value="<%=p.getId()%>" />
                                <jsp:param name="name" value="<%=p.getName()%>" />
                                <jsp:param name="thumbnail" value="<%=p.getThumbnail()%>" />
                                <jsp:param name="category" value="<%=p.getCategory()%>" />
                                <jsp:param name="price" value="<%=p.getPrice()%>" />
                                <jsp:param name="summary" value="<%=p.getSummary()%>" />
                            </jsp:include>
                        <%}%>
                        </tr>
                    </tbody>46
                </table>
            </div>
            <div class="hotdeal">
                <div class="detail">
                    <h1>Back to school deal</h1>
                    <div class="countdown">00 DAYS, 00 HOURS, 00 MINS, 00 SECS</div>
                    <h2>UP TO 75% OFF</h2>
                    <a href="products.php" class="getdeal">Shop Now</a>
                </div>
            </div>
            <div class="content">
                <h1><%=request.getAttribute("historyTitle")%></h1>
                <table width="100%" cellspacing="20">
                    <tbody>
                        <tr>
                            <%ArrayList<Product> tracks =
                                (ArrayList<Product>)request.getAttribute("trackData");
                                for(Product p:tracks){
                            %>
                                <jsp:include page="components/product.jsp" flush="true">
                                    <jsp:param name="id" value="<%=p.getId()%>" />
                                    <jsp:param name="name" value="<%=p.getName()%>" />
                                    <jsp:param name="thumbnail" value="<%=p.getThumbnail()%>" />
                                    <jsp:param name="category" value="<%=p.getCategory()%>" />
                                    <jsp:param name="price" value="<%=p.getPrice()%>" />
                                    <jsp:param name="summary" value="<%=p.getSummary()%>" />
                                </jsp:include>
                            <%}%>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="content">
                <div class="subscribe">
                    <h3>Sign Up for the <b>NEWSDEAL</b></h3>
                    <form action="email.php" method="POST">
                        <input type="text" name="email" placeholder="Enter Your Email" />
                        <button type="submit">Subscribe</button>
                    </form>
                </div>
            </div>
        </div>
<jsp:include page="components/footer.html" />