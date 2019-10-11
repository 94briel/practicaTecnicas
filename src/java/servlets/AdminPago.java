package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

public class AdminPago extends HttpServlet {

    PagoDAO pagoDAO = new PagoDAO();
    Pago pago = new Pago();
    TelefonoDAO telDAO = new TelefonoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("pago.jsp");

        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int i = pagoDAO.obtenerID();
        int idCel = Integer.parseInt(request.getParameter("idcel"));
        String nu = request.getParameter("nombre");
        String iu = request.getParameter("id");
        String nc = request.getParameter("nombrecel");
        double pc = Double.parseDouble(request.getParameter("preciocel"));
        int cant = Integer.parseInt(request.getParameter("cantidad"));
        double d = Double.parseDouble(request.getParameter("desD"));
        double t = Double.parseDouble(request.getParameter("totalD").toString());
        String cc = request.getParameter("tarjeta");
        if (cc.length() != 16) {
            RequestDispatcher view = request.getRequestDispatcher("pago.jsp");
            request.setAttribute("mensaje", "¡Por favor, introduzca una tarjeta de crédito válida!");
            view.forward(request, response);
        } else {
            pago.setIdCompra(i);
            pago.setNombreCliente(nu);
            pago.setIdCliente(iu);
            pago.setNombreCel(nc);
            pago.setPrecioCel(pc);
            pago.setDescuento(d);
            pago.setTotal(t);
            pago.setTarjeta(cc);
            telDAO.restarCantidad(idCel, cant);
            pagoDAO.agregar(pago);
            RequestDispatcher view = request.getRequestDispatcher("pago.jsp");
            request.setAttribute("mensaje", "¡Gracias por su compra! Regrese al menú principal, por favor.");
            view.forward(request, response);
        }
    }
}
