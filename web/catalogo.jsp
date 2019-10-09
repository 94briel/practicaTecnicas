<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
<link href="css/stylecat.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DB"%>
<%
    String driverName = "com.mysql.jdbc.Driver";
    DB conn = null;
    try {
        Class.forName(driverName);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
%>
<h1 align="center"><font><strong>Catálogo de celulares de Gabriel's Store</strong></font></h2>
<h1><%
    if (null != request.getAttribute("mensaje")) {
        out.println(request.getAttribute("mensaje"));
    }
    %></h1>
<table align="center" cellpadding="15" cellspacing="0" border="1" bordercolor="#696969">
    <tr>

    </tr>
    <tr bgcolor="#1093c7">
        <td align="center">Marca</td>
        <td align="center">Nombre</td>
        <td align="center">Color</td>
        <td align="center">Capacidad</td>
        <td align="center">Precio</td>
        </tr>
    <%
        try {
            connection = conn.getConexion();
            statement = connection.createStatement();
            String sql = "SELECT * FROM telefono where cantidad != '0'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
    %>
    <tr bgcolor="#f2f3f5">
        <td align="center"><%=resultSet.getString("marca")%></td>
        <td name="nombrecel" align="center"><%=resultSet.getString("nombre")%></td>
        <td align="center"><%=resultSet.getString("color")%></td>
        <td align="center"><%=String.format("%1$,.0f", resultSet.getDouble("capacidad")) + " GB"%></td>
        <td align="center"><%=String.format("%1$,.3f", resultSet.getDouble("precio")) + " COP"%></td>
    </tr>
    <%
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<hr/>
<h1 align="center"><font><strong><i class="fa fa-mobile-phone"></i> Comprar dispositivo <i class="fa fa-mobile-phone"></i></strong></font></h2>
<body align="center">
<form action="./pago" method="POST">
    ¿Cuál es el nombre exacto del modelo que desea comprar?: <input type="text" name="nombrecel" value="" size="26" placeholder="Nombre del dispositivo"/>
    <br/>
    <br/>
    <input type="submit" value="Comprar" name="comprar" />
</form>
<hr/>
    <a href="index.html"><input type="button" value="Regresar a la página principal" name="index"/></a>
    <br/> 
    <br/> 
</body>