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
                    <form name="submitform" id="submitform" method="post" action="./confirmation">
                        <p class="form-message"><?=(isset($errorMessage))?$errorMessage:"";?></p>
                        <button type="submit" id="order-submit" class="js-submit-order btn" tabindex="0" id="formSubmit" name="purchase">
                            Submit Order
                        </button>
                    </form>
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