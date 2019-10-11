package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inscribir_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700\" rel=\"stylesheet\">\n");
      out.write("<link href=\"css/stylecat.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"lib/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"lib/animate/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"img/favicon.png\" rel=\"icon\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>¡Inscríbase!</title>\n");
      out.write("<div align=\"center\">\n");
      out.write("    <body>    \n");
      out.write("<h2>");

    if(null!=request.getAttribute("mensaje"))
    {
        out.println(request.getAttribute("mensaje"));
        out.println("");
    }

      out.write("</h2>\n");
      out.write("    <h1>¿Todavía no se ha registrado? Por favor, introduzca los siguientes datos.</h1>\n");
      out.write("    <form action=\"./registro_usuario\" method=\"POST\" onsubmit=\"return registro()\">\n");
      out.write("        Identificación * : <input type=\"text\" name=\"id\" placeholder=\"Número de identificación\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        Primer nombre: <input type=\"text\" name=\"nombre\" placeholder=\"Nombre\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        Primer apellido: <input type=\"text\" name=\"apellido\" placeholder=\"Apellido\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        Correo electrónico * : <input type=\"text\" name=\"correo\" placeholder=\"ejemplo@gabrielsstore.com\" size=\"33\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        Contraseña * : <input type=\"password\" name=\"contrasena\" placeholder=\"Contraseña que desea asignar\" size=\"27\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />        \n");
      out.write("        <input type=\"submit\" value=\"Registrarse\" name=\"registro\" />\n");
      out.write("        <input type=\"reset\" value=\"Borrar todos los campos\" name=\"borrar\" />\n");
      out.write("    </form>\n");
      out.write("    <br /> \n");
      out.write("    <hr/>                \n");
      out.write("    <h1>¿Ya se encuentra registrado? Por favor, introduzca su identificación y contraseña.</h1>\n");
      out.write("    <form action=\"./inicio_sesion\" method=\"POST\">\n");
      out.write("        Identificación: <input type=\"text\" name=\"idus\" placeholder=\"Número de identificación\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />\n");
      out.write("        Contraseña: <input type=\"password\" name=\"passus\" placeholder=\"Contraseña\"/>\n");
      out.write("        <br />\n");
      out.write("        <br />        \n");
      out.write("        <input type=\"submit\" value=\"Iniciar sesión\" name=\"login\" />\n");
      out.write("        <input type=\"reset\" value=\"Borrar todos los campos\" name=\"borrar\" />\n");
      out.write("    </form>\n");
      out.write("    <br/>    \n");
      out.write("    <hr/> \n");
      out.write("    <a href=\"index.html\"><input type=\"button\" value=\"Regresar a la página principal\" name=\"index\"/></a>\n");
      out.write("    <br/> \n");
      out.write("    <br/> \n");
      out.write("</div>\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
