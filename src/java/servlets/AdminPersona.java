package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Persona;
import models.PersonaDAO;

public class AdminPersona extends HttpServlet {

    PersonaDAO perDAO = new PersonaDAO();
    Persona per = new Persona();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("inscribir.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String i = request.getParameter("id");
        String n = request.getParameter("nombre");
        String a = request.getParameter("apellido");
        String c = request.getParameter("correo");
        String p = request.getParameter("contrasena");
        if (i.length()> 11 || i.equals("") || i.equals(null) || p.equals("") || p.equals(null) || c.equals("") 
                || c.equals(null) || !c.contains("@") || !c.contains(".")) {
        RequestDispatcher view = request.getRequestDispatcher("inscribir.jsp");
        request.setAttribute("mensaje", "¡Por favor, introduzca correctamente los datos marcados con asterisco (*)!");
        view.forward(request, response);
        }else{
        per.setId(i);
        per.setPrimerNombre(n);
        per.setPrimerApellido(a);
        per.setCorreo(c);
        per.setContrasena(p);
        perDAO.agregar(per);
        RequestDispatcher view = request.getRequestDispatcher("catalogo.jsp");
        if (n.equals("") || n.equals(null) || a.equals("") || a.equals(null)) {
            n = "cliente";
            a = "nuevo";
        }
        request.setAttribute("mensaje", "¡Bienvenid@, " + n + " " + a + "!");
        view.forward(request, response);
        }
    }
}
