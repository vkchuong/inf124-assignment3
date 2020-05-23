<%@ page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
    <div class="container">
        <div class="main">
                <h1>GET Request: This H1 lives in Confirmation.JSP </h1>
                <div class="orderform">
                    <p class="form-message"></p>
                    <div class="name">
                        Billing First name: <br />
                        Billing Last name: <br />
                        Billing Email: <br />
                        Billing Phone: <br />
                        Billing Address: <br />
                        Billing Email: <br />
                        Billing City: <br />
                        Billing State: <br />
                        Billing Zipcode: <br />

                        Shipping First name: </br />
                        Shipping Last name: </br />
                        Shipping Email: </br />
                        Shipping Phone: </br />
                        Shipping Address: <br />
                        Shipping Email: <br />
                        Shipping City: <br />
                        Shipping State: <br />
                        Shipping Zipcode: <br />
                    </div>
                <div class="orderform">
                    <p>Thank you for placing you cart order! Here are your details:</p>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="components/footer.html" />