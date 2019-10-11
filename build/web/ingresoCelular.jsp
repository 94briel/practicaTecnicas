<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
<link href="css/stylecat.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="img/favicon.png" rel="icon">
<%-- 
    Document   : inscribir
    Created on : Oct 6, 2019, 5:42:21 PM
    Author     : gabri
--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Añadir dispositivo</title>
<div align="center">
    <body>    
        <h2><%
            if (null != request.getAttribute("mensaje")) {
                out.println(request.getAttribute("mensaje"));
                out.println("");
            } else if (null != request.getAttribute("mensaje2")) {
                out.println(request.getAttribute("mensaje2"));
                out.println("");
            }
            %></h2>
        <h1>Ingrese el nuevo dispositivo.</h1>
        <form action="./ingresar_cel" method="POST" onsubmit="return registro()">
            Identificación del dispositivo : <input type="text" name="id"/>
            <br />
            <br />
            Nombre del dispositivo: <input type="text" name="nombre"/>
            <br />
            <br />
            Marca del dispositivo: <input type="text" name="marca" />
            <br />
            <br />
            Color del dispositivo: <input type="text" name="color" size="33"/>
            <br />
            <br />
            Capacidad de almacenamiento del dispositivo (en GB): <input type="text" name="capacidad" />
            <br />
            <br />
            Precio del dispositivo (en COP): <input type="text" name="precio"/>
            <br />
            <br />
            ¿Cuántos desea añadir?: <input type="text" name="cantidad"/>
            <br />
            <br />   
            <input type="submit" value="Añadir" name="añadir" />
            <input type="reset" value="Borrar todos los campos" name="borrar" />
        </form>
        <hr/>
        <a href="index.html"><input type="button" value="Regresar a la página principal" name="index"/></a>
