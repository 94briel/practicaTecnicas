<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
<link href="css/stylecat.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="img/favicon.png" rel="icon">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
    </head>
    <body align="center">
        <h2><%
            if (null != request.getAttribute("mensaje")) {
                out.println(request.getAttribute("mensaje"));
            }
            %></h2>
        <h1><b>Formulario de Pago</b></h1>  
        <form action="./compra" method="POST" onsubmit="return registro()" target="pagar">
            <b>Nombre del cliente:</b>       
            <%
                try {
                    if (null != request.getAttribute("nombre")) {
                        out.print(request.getAttribute("nombre"));
                    } else {
                        out.print("Sin nombre");
                    }
            %>
            <input type="hidden" name="nombre" value="<%=request.getAttribute("nombre")%>"/>
            <br />
            <br />
            <b>Identificación:</b>        
            <%

                if (null != request.getAttribute("id")) {
                    out.print(request.getAttribute("id"));

                } else {
                    out.print("Sin identificación");
                }%>
            <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>        
            <br />
            <br />            
            <b>Nombre del celular:</b>        
            <%
                if (null != request.getAttribute("nombrecel")) {
                    out.print(request.getAttribute("nombrecel"));
                } else {
                    out.print("Ningún celular seleccionado");
                }%>
            <input type="hidden" name="nombrecel" value="<%=request.getAttribute("nombrecel")%>"/>
            <br />
            <br />
            <b>Precio del celular:</b>
            <%
                if (null != request.getAttribute("preciocel")) {
                    out.print(String.format("%1$,.3f", request.getAttribute("preciocel")));
                } else {
                    out.print("Sin precio");
                }%>
            <b>COP</b>
            <input type="hidden" name="preciocel" value="<%=request.getAttribute("preciocel")%>"/>
            <br />
            <br />
            <b>Cantidad de celulares a comprar:</b>        
            <%
                int cant = 1;
                if (null != request.getAttribute("cc")) {
                    if (Integer.parseInt(request.getAttribute("cantidadcel").toString()) - Integer.parseInt(request.getAttribute("cc").toString()) >= 0) {
                        cant = Integer.parseInt(request.getAttribute("cc").toString());
                        out.print(cant);
                    }
                } else {
                    out.print(cant);
                }
            %>
            <input type="hidden" name="cantidad" value="<%=cant%>"/>
            <br />
            <br />
            <b>Descuento:</b>
            <%
                double des = 0;
                String desS = "";
                double por = Double.parseDouble(request.getAttribute("porcentaje").toString());
                if (por != 0) {
                    des = (Double.parseDouble(request.getAttribute("preciocel").toString()) * cant) * por / 100;
                    desS = String.format("%1$,.3f", des);
                    out.print("El descuento total es de " + desS + " COP");

                } else {
                    out.print("No hay descuento");
                }
            %>
            <input type="hidden" name="desD" value="<%=des%>"/>
            <input type="hidden" name="descuento" value="<%=desS%>"/>
            <br />
            <br />
            <b>Costo total:</b>
            <%
                double costo = 0;
                String costoS = "";
                if (null != request.getAttribute("preciocel")) {
                    costo = (Double.parseDouble(request.getAttribute("preciocel").toString()) * cant) - des;
                    costoS = String.format("%1$,.3f", costo);
                    out.print(costoS);
                } else {
                    out.print("Sin costo");
                }
            %>
            <b> COP</b>
            <input type="hidden" name="totalD" value="<%=costo%>"/>
            <input type="hidden" name="total" value="<%=costoS%>"/>
            <input type="hidden" name="idcel" value="<%=request.getAttribute("idcel")%>"/>
            <br />
            <br />  
            <b>Número de tarjeta de crédito:</b> <input type="text" name="tarjeta" placeholder="XXXX  XXXX  XXXX  XXXX" size="22"/>
            <br />
            <br />
            <input type="submit" value="Realizar compra" name="completar"/>         
            <br/>
            <iframe name="pagar" scrolling="no" frameborder="0"></iframe> 
            <hr/>
            <%} catch (Exception e) {
                }%>
            <a href="index.html"><input type="button" value="Regresar a la página principal" name="index"/></a>
            <br/> 
            <br/> 
    </body>

</html>
