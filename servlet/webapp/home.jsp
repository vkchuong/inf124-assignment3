<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="components/head.html" />
<jsp:include page="components/header.html" />
        <div class="main">
            <div class="content">
                <h1>New Products</h1>
                <table width="100%" cellspacing="20">
                    <tbody>
                        <tr>
                            <td class="product">
                                <a href="detail.php?id=6"><img src="assets/baseketballHoop.jpeg" alt="Basketball Hoop picture"></a>
                                <h4>Sports Equipment</h4>
                                <h2>Basketball Hoop</h2>
                                <h3>$108.99</h3>
                                <p>NBA AND NCAA-APPROVED BASKETBALL HOOP</p>
                                <hr />
                                <a href="detail.php?id=6" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=7"><img src="assets/soccerCleats.png" alt="Soccer Cleats picture"></a>
                                <h4>Sportswear</h4>
                                <h2>Soccer Cleats</h2>
                                <h3>$49.99</h3>
                                <p>NFHS AND NCAA-APPROVED SOCCER CLEATS</p>
                                <hr />
                                <a href="detail.php?id=7" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=8"><img src="assets/tennisRackets.jpg" alt="Tennis Racket picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Tennis Racket</h2>
                                <h3>$29.99</h3>
                                <p>UTSA APPROVED TENNIS RACKET</p>
                                <hr />
                                <a href="detail.php?id=8" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=9"><img src="assets/cricketBat.jpeg" alt="Cricket Bat picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Cricket Bat</h2>
                                <h3>$29.99</h3>
                                <p>ICC APPROVED CRICKET BAT</p>
                                <hr />
                                <a href="detail.php?id=9" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=10"><img src="assets/golfClub.jpg" alt="Golf Club picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Golf Club</h2>
                                <h3>$69.99</h3>
                                <p>UGSA APPROVED GOLF CLUB</p>
                                <hr />
                                <a href="detail.php?id=10" class="addtocart">See Details</a>
                            </td>
                        </tr>
                    </tbody>
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
                <h1>TOP SELLING</h1>
                <table width="100%" cellspacing="20">
                    <tbody>
                        <tr>
                            <td class="product">
                                <a href="detail.php?id=6"><img src="assets/baseketballHoop.jpeg" alt="Basketball Hoop picture"></a>
                                <h4>Sports Equipment</h4>
                                <h2>Basketball Hoop</h2>
                                <h3>$108.99</h3>
                                <p>NBA AND NCAA-APPROVED BASKETBALL HOOP</p>
                                <hr />
                                <a href="detail.php?id=6" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=7"><img src="assets/soccerCleats.png" alt="Soccer Cleats picture"></a>
                                <h4>Sportswear</h4>
                                <h2>Soccer Cleats</h2>
                                <h3>$49.99</h3>
                                <p>NFHS AND NCAA-APPROVED SOCCER CLEATS</p>
                                <hr />
                                <a href="detail.php?id=7" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=8"><img src="assets/tennisRackets.jpg" alt="Tennis Racket picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Tennis Racket</h2>
                                <h3>$29.99</h3>
                                <p>UTSA APPROVED TENNIS RACKET</p>
                                <hr />
                                <a href="detail.php?id=8" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=9"><img src="assets/cricketBat.jpeg" alt="Cricket Bat picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Cricket Bat</h2>
                                <h3>$29.99</h3>
                                <p>ICC APPROVED CRICKET BAT</p>
                                <hr />
                                <a href="detail.php?id=9" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php?id=10"><img src="assets/golfClub.jpg" alt="Golf Club picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Golf Club</h2>
                                <h3>$69.99</h3>
                                <p>UGSA APPROVED GOLF CLUB</p>
                                <hr />
                                <a href="detail.php?id=10" class="addtocart">See Details</a>
                            </td>
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