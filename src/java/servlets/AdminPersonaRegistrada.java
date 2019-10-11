package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Persona;
import models.PersonaDAO;

public class AdminPersonaRegistrada extends HttpServlet {

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
        RequestDispatcher view;
        String i = request.getParameter("idus");
        String p = request.getParameter("passus");
        String nombre = perDAO.obtenerNombre(i);        
        int nivel = perDAO.validar(i, p);
        switch (nivel) {
            case 2:
                view = request.getRequestDispatcher("ingresoCelular.jsp");
                request.setAttribute("mensaje", "¡Bienvenido, administrador!");
                request.setAttribute("idcliente", i);
                view.forward(request, response);
                break;
            case 1:
                view = request.getRequestDispatcher("catalogo.jsp");
                request.setAttribute("mensaje", "¡Bienvenid@, " + nombre + "!");
                request.setAttribute("idcliente", i);
                view.forward(request, response);
                break;
            default:
                view = request.getRequestDispatcher("inscribir.jsp");
                request.setAttribute("mensaje", "El usuario no se encuentra registrado o ha ingresado incorrectamente los datos.");
                view.forward(request, response);
                break;
        }
    }
}
