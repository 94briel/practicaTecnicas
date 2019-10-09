<%-- 
    Document   : registro
    Created on : 20/05/2016, 08:42:33 AM
    Author     : mateo.llano
--%>

<%@ include file="header.jsp" %>

<c:if test="${not empty mensaje}">
    <div><b><c:out value="${mensaje}" /></b></div>
</c:if>
<c:if test="${variable == false}">
    <c:out value="disabled='disabled'"/>
</c:if>
<form action="./crear_usuario" method="POST">
    Nombre: <input type="text" name="nombre"/>
    Correo: <input type="text" name="correo"/>
    <input type="submit" value="registrar" />
</form>

<%@ include file="footer.jsp" %>
