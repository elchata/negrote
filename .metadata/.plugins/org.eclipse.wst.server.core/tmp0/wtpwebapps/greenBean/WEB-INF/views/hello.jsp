<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="${now}"/><br>
<c:out value="${pedido.precioFinal}"/><br>
<c:forEach items="${pedido.productos}" var="hash" >
	<c:out value="${hash.key.nombre}"/><br>
	<c:out value="${hash.value}"/><br>
	<c:forEach items="${hash.key.categorias}" var="cat" >
		<c:out value="${cat.nombre}"/><br>
	</c:forEach>
</c:forEach>
</body>
</html>