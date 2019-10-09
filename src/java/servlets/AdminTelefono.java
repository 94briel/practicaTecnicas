package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Telefono;
import models.TelefonoDAO;

public class AdminTelefono extends HttpServlet {

    TelefonoDAO telDAO = new TelefonoDAO();
    Telefono tel = new Telefono();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("catalogo.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ncel = request.getParameter("nombrecel");
        String precio = request.getParameter("precio");
        
        RequestDispatcher view = request.getRequestDispatcher("pago.jsp");
        request.setAttribute("nombrecel", ncel);
        request.setAttribute("preciocel", telDAO.obtenerPrecio(ncel) + " COP");
        view.forward(request, response);
    }

}
