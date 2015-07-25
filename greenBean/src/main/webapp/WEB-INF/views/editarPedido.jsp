<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Pedido</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table>
				<tr>
					<td>Precio Total productos : </td>
					<td><form:input path="precioFinal" value="${command.precioFinal}"/></td>
				</tr>
				
				 
				<form:hidden path="idPedido"/>		
				<tr>
					<td>Direccion : </td>
					<c:forEach items="${command.cliente.direcciones}" var="dir">
								<c:choose>
		                    		<c:when test="${command.cliente.direcciones.contains(dir)}"> 
		                        		<form:checkbox path="direccion" label="${dir.calle} ${dir.ciudad} ${dir.ciudad.partido }" value="${dir.idDireccion}" checked="checked"/> 
		                    		</c:when>
		                    		<c:otherwise> 
		                        		<form:checkbox path="direccion" label="${dir.calle} ${dir.ciudad} ${dir.ciudad.partido }" value="${dir.idDireccion}"/>
		                    		</c:otherwise>
		                		</c:choose>	
					</c:forEach>
				</tr>	
				<form:textarea path="estado.detalle" rows="5" cols="30" />		 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Pedidos</a> 