/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-22 12:15:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/head.html", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/header.html", out, false);
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <h1>About Us</h1>\r\n");
      out.write("        <div class=\"about-section\">\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <br><br>\r\n");
      out.write("                <h3>WHO WE ARE</h3>\r\n");
      out.write("                <p>\r\n");
      out.write("                    Welcome to Sports Store! We are an online business currently based in\r\n");
      out.write("                    Irvine, California. We offer only the best quality sporting goods and quality service.\r\n");
      out.write("                    We hope you use Sports Store for all of your sports gear needs!\r\n");
      out.write("                </p><br>\r\n");
      out.write("                <h3>CATEGORIES</h3>\r\n");
      out.write("                <p>\r\n");
      out.write("                    At Sports Store, we sell a variety of sporting goods. From sports balls, to sport wear,\r\n");
      out.write("                    to training equipment, we've got it all. Want to see if an item is in stock?\r\n");
      out.write("                    Want to request a special item? Contact us and we will respond to your requests as\r\n");
      out.write("                    soon as possible!\r\n");
      out.write("                </p><br>\r\n");
      out.write("                <h3>ORDERS</h3>\r\n");
      out.write("                <p>\r\n");
      out.write("                    Placing an order is as easy as 1, 2, 3!\r\n");
      out.write("                    Search for the product you want to place an order for.\r\n");
      out.write("                    Fill out your shipping and payment information.\r\n");
      out.write("                    Wait eagerly for speedy delivery of your products!\r\n");
      out.write("                    Products will take 5-7 business days to be delivered. Contact us if you have any questions\r\n");
      out.write("                    about your order.\r\n");
      out.write("                </p><br>\r\n");
      out.write("                <h3>SERVICES</h3>\r\n");
      out.write("                <p>\r\n");
      out.write("                    Customer Service is our number one priority! With 24/7 customer support, we are available to\r\n");
      out.write("                    help you whenever you need. Whether it is a question about a product or concerns about\r\n");
      out.write("                    an order, we've got you covered. Call by phone or email us and we will get back to you\r\n");
      out.write("                    right away!\r\n");
      out.write("                </p><br><br>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h2 style=\"text-align:center;margin: 50px 0 25px;\">Our Management Team</h2>\r\n");
      out.write("            <hr>\r\n");
      out.write("            <div style=\"margin: 25px 0 50px; display:flex;\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <h3>Darrel Belen</h3>\r\n");
      out.write("                    <p class=\"title\">CEO & Founder</p>\r\n");
      out.write("                    <p>Responsible for overall company strategy and promoting company growth.</p>\r\n");
      out.write("                    <a href=\"#\">darrel@sportstore.com</a>\r\n");
      out.write("                    <p>SID: 72866173</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <h3>Vinh Chuong</h3>\r\n");
      out.write("                    <p class=\"title\">Sales Director</p>\r\n");
      out.write("                    <p>Responsible for the development of sales strategy and maintaining customer relations.</p>\r\n");
      out.write("                    <a href=\"#\">vinh@sportstore.com</a>\r\n");
      out.write("                    <p>SID: 20376995</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <h3>Payam Dowlatyari</h3>\r\n");
      out.write("                    <p class=\"title\">Human Resources Director</p>\r\n");
      out.write("                    <p>Responsible for the inner workings of the company.</p>\r\n");
      out.write("                    <a href=\"#\">payam@sportstore.com</a>\r\n");
      out.write("                    <p>SID: 11124675</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <h3>Sanjith Venkatesh</h3>\r\n");
      out.write("                    <p class=\"title\">Customer Service Director</p>\r\n");
      out.write("                    <p>Responsible for any customer service requests.</p>\r\n");
      out.write("                    <a href=\"#\">sanjith@sportstore.com</a>\r\n");
      out.write("                    <p>SID: 20038520</p>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "components/footer.html", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
