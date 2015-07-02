<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Datos Categoria</h2>
		<form:form method="POST" action="nuevitaCat.htm" modelattribute="command">		
			<table>
			<tr>
			<td>Nombre de Categoria : </td>
			<td><form:input path="nombre" /></td>
			</tr>			 
			<tr>
			<td>Categoria Padre : </td>
			<td>
			<form:select path="idCategoria">
			 <form:option value="0" label="--- Select ---"/>
			 <c:forEach items="${categorias}" var="categoria">
			 <form:option value="${categoria.idCategoria}" label="${categoria.nombre}"/>
			 </c:forEach>
			</form:select>
			</td>
			</tr>			 			 
			<tr>
			<td colspan="3"><input type="submit" /></td>
			</tr>
			</table>
		</form:form>
</body>
</html>