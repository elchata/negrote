<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form  method="POST" action="subir.htm" modelattribute="command">
    <table>
        <tr>
           <td>Selecciona fichero: </td>
           <td><form:input type="file" path="imagen"/></td>
        </tr>    
        <tr><td colspan="2" align="center">
    	<input type="submit" value="Subir fichero"></td>
        </tr>
     </table>
</form:form >
</body>
</html>