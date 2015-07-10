<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Cliente</h2>	
			<table>
				<tr>
					<td>Numero de Usuario : </td>
					<td><c:out value="${cliente.idUser}"/></td>
				</tr>	
				<tr>
					<td>Logeado a travez de : </td>
					<td><c:out value="${cliente.empresa.nombre}"/></td>
				</tr>	 	
				<tr>
					<td>Sus pedidos son: </td>
					 <c:forEach items="${cliente.pedidos}" var="ped">
						<td><a href="../pedido/mostrar.html?idPed=${ped.idPedido}">${ped.idPedido}</a></td>
					</c:forEach>
				</tr>
				<tr>
					<td>Datos: </td>
					 <c:forEach items="${cliente.datos}" var="dato">
						<td>${dato.key} : ${dato.value}</td>
					</c:forEach>
				</tr> 
			</table>
		<br>
		
<a href="./ver.htm">Ver Clientes</a> 