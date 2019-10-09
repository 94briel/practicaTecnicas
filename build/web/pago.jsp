<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
<link href="css/stylecat.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pago</title>
    </head>
    <body align="center">
        <h1>Formulario de pago</h1>
        <form action="./pago" method="POST" onsubmit="return registro()">
            Nombre del cliente:         
            <%
                try {
                    if (null != request.getAttribute("nombre")) {
                        out.print(request.getAttribute("nombre"));
                    }%>
            <br />
            <br />
            Identificación:         
            <%

                if (null != request.getAttribute("id")) {
                    out.print(request.getAttribute("id"));
                }%>
            <br />
            <br />            
            Nombre del celular:         
            <%

                if (null != request.getAttribute("nombrecel")) {
                    out.print(request.getAttribute("nombrecel"));
                }%>
            <br />
            <br />
            Precio del celular:
            <%
                if (null != request.getAttribute("preciocel")) {
                    out.print(request.getAttribute("preciocel"));
                }%>            
            <br />
            <br />
            Descuento: <%
                    /*if (null != request.getAttribute("nombrecel")) {
                    out.print(request.getAttribute("nombrecel"));*/
                    out.print("¡No tenemos por el momento!");
                } catch (Exception e) {
                }%>
            <br />
            <br />
            <%--Cantidad: <select name="ja" size="1">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
            <br />
            <br />
            --%>
            Costo total:
            <%
                if (null != request.getAttribute("preciocel")) {
                    out.print(request.getAttribute("preciocel"));
                }%>        
            <br />
            <br />  
            Número de tarjeta de crédito: <input type="text" name="tarjeta" placeholder="XXXX  XXXX  XXXX  XXXX  XXXX" size="29"/>
            <br />
            <br />      
            <input type="submit" value="Comprar" name="completar" />
            <%
                if (null != request.getAttribute("mensaje")) {
                    out.print(request.getAttribute("mensaje"));
                }%>   
            <input type="reset" value="Borrar todos los campos" name="borrar" />
        </form>
            <br/>
<hr/>
    <a href="index.html"><input type="button" value="Regresar a la página principal" name="index"/></a>
    <br/> 
    <br/> 
    </body>
    
</html>
