/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-23 09:34:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.components;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"header\">\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"./home\">\r\n");
      out.write("                        <h1>Sports Store</h1>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"navbar\">\r\n");
      out.write("                <ul class=\"content\">\r\n");
      out.write("                    ");
 if(request.getRequestURI().startsWith("/Project3/home")) { 
      out.write("\r\n");
      out.write("                    <li><a href=\"./home\" class=\"active\">Home</a></li>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                    <li><a href=\"./home\">Home</a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");
 if(request.getRequestURI().startsWith("/Project3/products")) { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./products\" class=\"active\">Products</a></li>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./products\">Products</a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");
 if(request.getRequestURI().startsWith("/Project3/about.jsp")) { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./about.jsp\" class=\"active\">About Us</a></li>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./about.jsp\">About Us</a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");
 if(request.getRequestURI().startsWith("/Project3/contact.jsp")) { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./contact.jsp\" class=\"active\">Contact Us</a></li>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                        <li><a href=\"./contact.jsp\">Contact Us</a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");
 if(request.getRequestURI().startsWith("/Project3/cart") || request.getRequestURI().startsWith("/Project3/checkout")) { 
      out.write("\r\n");
      out.write("                        <li><a href =\"./cart\" class=\"active\">\r\n");
      out.write("                            <img src=\"./assets/cart.png\" width=\"20\"/>\r\n");
      out.write("                            <span class='badge badge-warning' id='lblCartCount'> 0 </span>\r\n");
      out.write("                        </a></li>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                        <li><a href =\"./cart\">\r\n");
      out.write("                            <img src=\"./assets/cart.png\" width=\"20\"/>\r\n");
      out.write("                            <span class='badge badge-warning' id='lblCartCount'> 0 </span>\r\n");
      out.write("                        </a></li>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>");
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
