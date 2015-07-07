
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABM categorias</title>
</head>
<body>
<h2>Categorias:</h2>
<table border="1">
  <tr>
    <th>Nombre</th>
    <th>Categoria Padre</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${categorias}" var="cat">	
	  <tr>
	    <td><c:out value="${cat.nombre}"/></td>
	    <td><c:out value="${cat.padre.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url>
		<c:url value="./verProd.htm" var="catURL4">
			<c:param name="idCat" value="${cat.idCategoria}"/>
		</c:url>
		<td>
		<a href="${catURL2}">editar</a> /
		<a href="${catURL3}">eliminar</a> /
		<c:if test="${cat.productos.size() > 0 }">
		<a href="${catURL4}">ver sus productos</a>
		</c:if></td>
	  </tr>
  </c:forEach>
</table>
<a href="./nueva.htm" >Nueva Categoria </a>  
</body>
</html>