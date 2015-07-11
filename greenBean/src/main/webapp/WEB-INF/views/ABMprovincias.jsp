
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<h2>Provincias:</h2>
<table border="1">
  <tr>
    <th>Nombre</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${provincias}" var="prov">	
	  <tr>
	    <td><c:out value="${prov.nombre}"/></td>
	    <c:url value="./editar.htm" var="catURL2">
			<c:param name="idProv" value="${prov.idProvincia}"/>
		</c:url>
		<c:url value="./eliminar.htm" var="catURL3">
			<c:param name="idProv" value="${prov.idProvincia}"/>
		</c:url>
		<td>
			<a href="${catURL2}">editar</a> /
			<a href="${catURL3}">eliminar</a>
		</td>
	  </tr>
  </c:forEach>
</table>
<a href="./new.htm" >Nueva Provincia </a>   