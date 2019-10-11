package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
public class AdminTelefono extends HttpServlet {

    TelefonoDAO telDAO = new TelefonoDAO();
    PersonaDAO perDAO = new PersonaDAO();
    Telefono tel = new Telefono();
    DescuentoDAO des = new DescuentoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("catalogo.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ncel = request.getParameter("celelegido");
        String idcliente = request.getParameter("idcliente");
        String descuento = request.getParameter("desc");
        double porcentaje = des.obtenerPorcentaje(descuento);
        int cc = Integer.parseInt(request.getParameter("cc"));
        int idCel = Integer.parseInt(request.getParameter("idcel"));
        int cantidadcel = Integer.parseInt(request.getParameter("cantidadcel"));
        RequestDispatcher view = request.getRequestDispatcher("pago.jsp");
        request.setAttribute("nombrecel", ncel);
        request.setAttribute("nombre", perDAO.obtenerNombre(idcliente));
        request.setAttribute("id", idcliente);
        request.setAttribute("cc", cc);
        request.setAttribute("idcel", idCel);
        request.setAttribute("cantidadcel", cantidadcel);
        request.setAttribute("preciocel", telDAO.obtenerPrecio(idCel));
        request.setAttribute("desc", descuento);
        request.setAttribute("porcentaje", porcentaje);
        view.forward(request, response);
    }

}
