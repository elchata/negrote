<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Pedido</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Precio Final pedido : </td>
					<td><form:input path="precioFinal" value="${command.precioFinal}"/></td>
				</tr>
				<tr>
					<td>Realizado por el cliente : </td>
					<td><form:input path="auxCli" value="${command.cliente.idUser}"/></td>
				</tr>			 
				 
				<form:hidden path="idPedido"/>					 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Pedidos</a> 