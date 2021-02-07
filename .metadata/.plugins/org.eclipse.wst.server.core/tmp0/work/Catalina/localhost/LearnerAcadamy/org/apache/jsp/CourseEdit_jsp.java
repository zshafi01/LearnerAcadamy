/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2021-02-06 19:04:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.simplilearn.model.*;
import com.simplilearn.repository.*;

public final class CourseEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.simplilearn.model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("com.simplilearn.repository");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Editing page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form method=\"post\" action=\"courseEditingHandler\">\r\n");
      out.write("\r\n");

List<Instructor> instructors=(List<Instructor>)session.getAttribute("instructorList");
String command = request.getParameter("command");
Course course=new Course();

String id = request.getParameter("id");
CourseRepository courseRepository = new CourseRepository();
course=courseRepository.getById(Integer.parseInt(id));


      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("\r\n");
      out.write("<td>Course Title:</td><td>\r\n");
      out.write("<input type=\"hidden\" name=\"id\" value=");
      out.print(course.getId());
      out.write(">\r\n");
      out.write("<input type=\"text\" name=\"c_name\" value=");
      out.print(course.getTitle() );
      out.write(">\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Course hour:</td><td><input type=\"text\" name=\"c_hour\" value=");
      out.print(course.getHours() );
      out.write("></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Course Price:</td><td><input type=\"text\" name=\"c_price\" value=");
      out.print(course.getPrice());
      out.write("></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>Course Description:</td><td><textarea name=\"c_desc\" >");
      out.print(course.getDescription());
      out.write("</textarea></td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<td>Instructor:</td><td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<select name=\"instructor\">\r\n");
 for(Instructor instractor:instructors) { 
      out.write("\r\n");
      out.write("    <option value=");
      out.print(instractor.getId() );
      out.write('>');
      out.print(instractor.getFname() );
      out.write("</option>\r\n");
      out.write("\t ");
} 
      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<td>Class:</td><td><select name=\"class\">\r\n");
      out.write("    <option value=\"classA\">Class A</option>\r\n");
      out.write("    <option value=\"classB\">Class B</option>\r\n");
      out.write("\t <option value=\"classC\">Class C</option>\r\n");
      out.write("</select>\r\n");
      out.write("</td></tr>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");

if(command!=null && "edit".equalsIgnoreCase(command)) {

      out.write("\r\n");
      out.write("<input type=\"submit\" value=\"Edit\">\r\n");

} else if(command!=null && "delete".equalsIgnoreCase(command)) {

      out.write("\r\n");
      out.write("<input type=\"submit\" value=\"Delete\">\r\n");
 
}else{

      out.write("\r\n");
      out.write("<input type=\"submit\" value=\"Save\">\r\n");
}
      out.write("\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
