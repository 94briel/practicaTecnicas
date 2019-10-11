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
<title>�Inscr�base!</title>
<div align="center">
    <body>    
<h2><%
    if(null!=request.getAttribute("mensaje"))
    {
        out.println(request.getAttribute("mensaje"));
        out.println("");
    }
%></h2>
    <h1>�Todav�a no se ha registrado? Por favor, introduzca los siguientes datos.</h1>
    <form action="./registro_usuario" method="POST" onsubmit="return registro()">
        Identificaci�n * : <input type="text" name="id" placeholder="N�mero de identificaci�n"/>
        <br />
        <br />
        Primer nombre: <input type="text" name="nombre" placeholder="Nombre"/>
        <br />
        <br />
        Primer apellido: <input type="text" name="apellido" placeholder="Apellido"/>
        <br />
        <br />
        Correo electr�nico * : <input type="text" name="correo" placeholder="ejemplo@gabrielsstore.com" size="33"/>
        <br />
        <br />
        Contrase�a * : <input type="password" name="contrasena" placeholder="Contrase�a que desea asignar" size="27"/>
        <br />
        <br />        
        <input type="submit" value="Registrarse" name="registro" />
        <input type="reset" value="Borrar todos los campos" name="borrar" />
    </form>
    <br /> 
    <hr/>                
    <h1>�Ya se encuentra registrado? Por favor, introduzca su identificaci�n y contrase�a.</h1>
    <form action="./inicio_sesion" method="POST">
        Identificaci�n: <input type="text" name="idus" placeholder="N�mero de identificaci�n"/>
        <br />
        <br />
        Contrase�a: <input type="password" name="passus" placeholder="Contrase�a"/>
        <br />
        <br />        
        <input type="submit" value="Iniciar sesi�n" name="login" />
        <input type="reset" value="Borrar todos los campos" name="borrar" />
    </form>
    <br/>    
    <hr/> 
    <a href="index.html"><input type="button" value="Regresar a la p�gina principal" name="index"/></a>
    <br/> 
    <br/> 
</div>
</body>