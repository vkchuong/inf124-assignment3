<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
    <div class="main">
        <div class="content">         

<body>
    <div class="container">
        <div class="main">
                <h1>GET Request: This H1 lives in Confirmation.JSP </h1>
                <div class="orderform">
                    <!-- String orderId = (String)request.getAttribute("orderId"); -->
                    <p>Thank you for placing you cart order! Here are your details:</p>
                    <!-- %=orderId-->
                    <%--<%=request.getAttribute("lastname");%>--%>
                    <!--....-->
                    <%--<%=request.getAttribute("totalPrice");%>--%>  
                </div>
            </div>
        </div>
        <script type="text/javascript" src="js/main.js"></script>
</body>

</html>
</html>

        </div>
    </div>
<jsp:include page="components/footer.html" />