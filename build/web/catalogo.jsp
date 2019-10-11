<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700" rel="stylesheet">
<link href="css/stylecat.css" rel="stylesheet">
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="img/favicon.png" rel="icon">
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.DB"%>
<title>Catálogo</title>
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
    PreparedStatement ps = null;
%>
<div align="center">
    <h1><font><strong>Catálogo de Celulares</strong></font></h2>
        En caso de tener un código de descuento, introdúzcalo.
        <h1>
            <%
                if (null != request.getAttribute("mensaje")) {
                    out.println(request.getAttribute("mensaje"));
                }
            %>
        </h1>
        <table align="center" cellpadding="15" cellspacing="0" border="1" bordercolor="#696969">
            <tr>

            </tr>
            <tr bgcolor="#1093c7">
                <td align="center">Marca</td>
                <td align="center">Nombre</td>
                <td align="center">Color</td>
                <td align="center">Capacidad</td>
                <td align="center">Precio<br/>individual</td>
                <td align="center">Cantidad que<br/>desea comprar</td>
            </tr>
            <%
                String i = "";
                try {
                    i = request.getAttribute("idcliente").toString();
                } catch (Exception e) {
                }
                if (i.equals("")) {
                    i = "Sin identificación";
                }
                try {
                    connection = conn.getConexion();
                    statement = connection.createStatement();
                    String sql = "SELECT * FROM telefono where cantidad != '0'";
                    resultSet = statement.executeQuery(sql);
                    while (resultSet.next()) {
            %>
            <tr bgcolor="#f2f3f5">
                <td align="center"><%=resultSet.getString("marca")%></td>
                <td align="center"><%=resultSet.getString("nombre")%></td>
                <td align="center"><%=resultSet.getString("color")%></td>
                <td align="center"><%=String.format("%1$,.0f", resultSet.getDouble("capacidad")) + " GB"%></td>
                <td align="center"><%=String.format("%1$,.3f", resultSet.getDouble("precio")) + " COP"%></td>

                <td align="center">
                    <form action="./pago" method="POST">
                        <input type="text" name="cc" size="17" placeholder="Máxima cantidad: <%=resultSet.getString("cantidad")%>"/>       
                        <br/>
                        <br/>
                        <input type="text" name="desc" size="17" placeholder="Código de descuento"/>
                        <br/>
                        <br/>
                        <input type="hidden" name="celelegido" value="<%=resultSet.getString("nombre")%>"/>
                        <input type="hidden" name="cantidadcel" value="<%=resultSet.getString("cantidad")%>"/>
                        <input type="hidden" name="idcel" value="<%=resultSet.getString("id")%>"/>
                        <input type="hidden" name="idcliente" value="<%=i%>"/>

                        <input type="submit" value="Comprar" name="comprar" />
                    </form>

                </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </table>
        <hr/>
        <a href="index.html"><input type="button" value="Regresar a la página principal" name="index"/></a>
</div>

<br/> 
<br/> 