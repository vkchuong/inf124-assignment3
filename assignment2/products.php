<?=file_get_contents("components/head.html");?>
<body>
    <div class="container">
        <?=file_get_contents("components/header.html");?>
        <div class="main">
            <div class="content">
                <h1>Products for Sale</h1>
                <table width="100%" cellspacing="20">
                    <tbody>
                        <tr>
                            <td class="product">
                                <a href="detail.php"><img src="assets/baseketball.jpg" alt="basketball picture"></a>
                                <h4>Sports Balls</h4>
                                <h2>Basketball</h2>
                                <h3>$23.99</h3>
                                <p>NBA and NCAA-approved Basketball.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/soccer.jpg" alt="soccer picture"></a>
                                <h4>Sports Balls</h4>
                                <h2>Soccer Ball</h2>
                                <h3>$49.99</h3>
                                <p>NFHS and NCAA-approved Soccer ball.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/tennis.jpeg" alt="tennis ball picture"></a>
                                <h4>Sports Balls</h4>
                                <h2>Tennis Balls</h2>
                                <h3>$15.99</h3>
                                <p>6 can pack of Tennis balls. 3 balls per can.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/cricketBall.jpeg" alt="cricket ball picture"></a>
                                <h4>Sports Balls</h4>
                                <h2>Cricket Balls</h2>
                                <h3>$39.99</h3>
                                <p>6 Pack of Cricket balls. ACF-approved Cricket Balls.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/goldBall.jpg" alt="golf ball picture"></a>
                                <h4>Sports Balls</h4>
                                <h2>Golf Balls</h2>
                                <h3>$39.99</h3>
                                <p>Set of 6 Callway Tour Golf balls.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                        </tr>
                        <tr>
                            <td class="product">
                                <a href="detail.php"><img src="assets/baseketballHoop.jpeg" alt="baseketball hoop picture"></a>
                                <h4>Sports Equipment</h4>
                                <h2>Basketball Hoop</h2>
                                <h3>$108.99</h3>
                                <p>NBA and NCAA-approved Basketball Hoop.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/soccerCleats.png" alt="soccer cleats picture"></a>
                                <h4>Sportswear</h4>
                                <h2>Soccer Cleats</h2>
                                <h3>$49.99</h3>
                                <p>NFHS and NCAA-approved Soccer Cleats.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/tennisRackets.jpg" alt="tennis racket picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Tennis Racket</h2>
                                <h3>$29.99</h3>
                                <p>UTSA Approved Tennis Racket</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/cricketBat.jpeg" alt="cricket bat picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Cricket Bat</h2>
                                <h3>$29.99</h3>
                                <p>ICC Approved Cricket Bat</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                            <td class="product">
                                <a href="detail.php"><img src="assets/golfClub.jpg" alt="golf club picture"></a>
                                <h4>Sports Accessories</h4>
                                <h2>Golf Club</h2>
                                <h3>$69.99</h3>
                                <p>UGSA Approved Golf Club.</p>
                                <hr />
                                <a href="detail.php" class="addtocart">See Details</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <?=file_get_contents("components/footer.html");?>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>