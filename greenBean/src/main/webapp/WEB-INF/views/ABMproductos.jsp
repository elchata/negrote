
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM productos</title>
</head>
<body>
<h2>Productos:</h2>
<table border="1">
  <tr>
    <th>Nombre</th> 
    <th>Acciones</th>
  </tr>
  <c:forEach items="${productos}" var="prod">	
	  <tr>
	    <td><c:out value="${prod.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idProd" value="${prod.idProducto}"/>
		</c:url>
		<td>
		<a href="${catURL2}">editar</a> / 
		<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./nuevo.htm" >Nuevo Producto </a>  
</body>
</html>