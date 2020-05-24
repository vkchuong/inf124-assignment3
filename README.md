# inf124-assignment3
Building a web application using Java Servlets
Members of assignment3 are: Artur Gharibkhanyan id= 70269260, Hugo Aceves Ibarra id=12315858, Josue Lopez id= , Vinh Chuong 20376995.

Ecommerce Website that sells sports products.

Requirements:

1) When the user clicks on the products link a servlet displays helps display all the products in the webpage. The products page is filled dynamically so if any new product is added, it will appear on the products page.

2) To see the last five items a user has looked at, the user must first click on the products page, and then click on any product they want to see more details on such as a basketball. The specific detailed prodcut page such as the basketball then appears, afterwards, if the user decides to go back to the home page, on the bottom of the page there is a portion of the webpage that has the users most recently visited product details page. At this point you would only see the basketball in the history portion since the user has only visted the basketball page; however, if you view more products, the latest five products seen will appear on the history section of the homepage.

3) The product details page, can be viewed by first going to the products page. Upon entering the products page, all the products will appear, and you may click on one of these to view the product details page. The product details page will contain a picture of the product you are looking at, the price, the category of the product, and a summary explaining what the product is. There is also a button that says "add to cart" which allows the user to add a product on to the cart. Once the user clicks on the "Add to cart" button when they are in the product details page, the product is added onto the cart servlet session. 

4) After clicking on the "Add to cart" button, the user will then be redirected to the cart page (cart session) where the user can see all the products they have in their current shopping/ cart session. If the user is ready to checkout their products, they can then click on the checkout button that is in the cart page. If the user is not done shopping then they can continue shopping by clicking on the products or homepage. But if they click on the checkout tab or button from the cart page, the user will be redirected to the checkout page. Upon entering the checkout page, the user will see all the items they have in their cart once again before proceeding with a form containing all the user's information such as billing details, shipping, and credit card info. 

5) Upon Submitting the form, the user accepts the products they had in their cart, and the user submitted information is then stored in the database.

6)Upon submission of the user details in the checkout page, the session is then forwarded to the confirmation page where the user then recieves a confirmation id with a description of all the products they purchased, with all of the user's entered billing and shipping details, as well as the total cost of the purchase.
