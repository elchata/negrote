
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<div style="width: 95%; margin: 0 auto;">

	<div id="bandaDialog" style="display: none;">
		<%@ include file="editarBanda.jsp"%>
	</div>
	<h1>Lista de Bandas Horarias</h1>
	<button class="pure-button pure-button-primary" onclick="addProv()">
		<i class="fa fa-plus"></i> Crear Banda Horaria
	</button>
	<br>
<table border="1">
  <tr>
    <th>Horarios</th>
    <th>Acciones</th>
  </tr>
  <c:forEach items="${bandas}" var="banda">	
	  	<tr>
		  	<td><c:out value="${banda.horaInicio} - ${banda.horaFin}" /></td>
		  	<td>
			<button class="pure-button pure-button-primary" onclick="editarBanda(${banda.idBanda})">
				<i class="fa fa-pencil"></i> Editar
			</button>
			<a class="pure-button pure-button-primary" onclick="return confirm('Seguro queres eliminar la Banda?');"
			href="./eliminar.htm?idProv=${banda.idBanda}"> 
				<i class="fa fa-times"></i>Borrar</a>
			</td> 
		</tr>
  </c:forEach>
</table> 
</div>