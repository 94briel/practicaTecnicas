package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Telefono;
import models.TelefonoDAO;

public class AdminIngresarCelular extends HttpServlet {

    TelefonoDAO telDAO = new TelefonoDAO();
    Telefono tel = new Telefono();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("inscribir.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = Integer.parseInt(request.getParameter("id"));
        String m = request.getParameter("marca");
        String n = request.getParameter("nombre");
        String c = request.getParameter("color");
        double gb = Double.parseDouble(request.getParameter("capacidad"));
        double p = Double.parseDouble(request.getParameter("precio"));
        int cant = Integer.parseInt(request.getParameter("cantidad"));
        tel.setId(i);
        tel.setMarca(m);
        tel.setNombre(n);
        tel.setColor(c);
        tel.setPrecio(p);
        tel.setCapacidad(gb);
        tel.setCantidad(cant);
        telDAO.agregar(tel);
        RequestDispatcher view = request.getRequestDispatcher("ingresoCelular.jsp");
        request.setAttribute("mensaje2", "¡El dispositivo fue añadido exitosamente!");
        view.forward(request, response);
    }
}
