<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
		<h2>Datos Partido</h2>
		<form:form method="POST" action="./create.htm" modelattribute="command">		
			<table> 
				<tr>
					<td>Provincia:</td>
					<td>
					<form:select path="provincia.idProvincia"> 
					 		<c:forEach items="${provincias}" var="prov">
					  			<c:choose>
		                    		<c:when test="${prov.idProvincia== command.provincia.idProvincia}">
		                        		<form:option value="${prov.idProvincia}" selected="selected" label="${prov.nombre}"/>
		                    		</c:when>
		                    		<c:otherwise>
		                        		<form:option value="${prov.idProvincia}" label="${prov.nombre}"/>
		                    		</c:otherwise>
		                		</c:choose>			
					 		</c:forEach>
					</form:select></td>
				</tr>
				<tr>
					<td>Nombre: </td>
					<td><form:input path="nombre" value="${command.nombre}"/></td>
				</tr>
			<form:hidden path="idPartido"/>		 			 
				<tr>
					<td colspan="3"><input type="submit" value="Enviar Datos"/></td>
				</tr>
			</table>
		</form:form>
		<br>
		
<a href="./ver.htm">Ver Partidos</a> 