<%@page import="com.s2020iae.project3.Product"%>
<%@page import="java.util.ArrayList"%>
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
                <div> 
                    <table id="userDet" border="1" width="100%">
                        <tr>
                    
                    <th>name</th>
                    <th>thumbnail</th>
                    <th>category</th>
                    <th>price</th>
                    <th>summary</th>
                </tr>
                <%ArrayList<Product> tracks =
                        (ArrayList<Product>)session.getAttribute("cartItems");
                        for(Product p:tracks){
                       
                        
        %>
                  <tr>
                       
                        <td><%=p.getName()%></td>
                        <td><img src="./assets/<%=p.getThumbnail()%>" height="75"></td>
                        <td><%=p.getCategory()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getSummary()%></td>
                    </tr>
             <%}%>       
    	    </table>
            
            
                   
                </div>
                <div class="orderform"> 
                    <form name="submitform" id="submitform" method="post" action="./confirmation">
                        <p class="form-message"><?=(isset($errorMessage))?$errorMessage:"";?></p>
                        <div class="name">
                            <table id ="userBillInf" border="1" width="100%">
                                <tr>
                                    <th>Billing First name: </th>
                                    <th>Billing Last name: </th>
                                    <th>Billing Email: </th>
                                    <th>Billing Phone: </th>
                                    <th>Billing Address: </th>
                                    <th>Billing Email: </th>
                                    <th>Billing City: </th>
                                    <th>Billing State: </th>
                                    <th>Billing Zipcode: </th>
                                </tr>
                            </table>
                        </div>
                        <div class="name">
                            <table id ="userShipInf" border="1" width="100%">
                                <tr>
                                    <th>Shipping First name: </th>
                                    <th>Shipping Last name: </th>
                                    <th>Shipping Email: </th>
                                    <th>Shipping Phone: </th>
                                    <th>Shipping Address: </th>
                                    <th>Shipping Email: </th>
                                    <th>Shipping City: </th>
                                    <th>Shipping State: </th>
                                    <th>Shipping Zipcode: </th>
                                </tr>
                            </table>
                        </div>
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