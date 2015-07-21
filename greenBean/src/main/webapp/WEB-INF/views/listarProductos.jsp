<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="prodDialog" style="display: none;">
	<%@ include file="comprarProducto.jsp"%>
</div>
<%--............. para incluir los menu de categoria al costado

 <div id="menuCategorias" style="float: right;">
	 <ul>
	  <c:forEach items="${categorias}" var="cat"> 
	   <c:if test="${ cat.hijos.size() > 0 }">
	 	<li><c:out value="${cat.nombre}" />
	 		<ul>
	 		<c:forEach items="${cat.hijos}" var="hijo">
	 			<li><c:out value="${hijo.nombre}" /></li>
	 		</c:forEach>	 		
	 		</ul>	 	
	 	</li>
	   </c:if>
	   <c:if test="${ cat.hijos.size() == 0 && cat.padre == null }">
	   <li><c:out value="${cat.nombre}" /></li>
	   </c:if>
	  </c:forEach>
	 </ul>
 </div>
 
--%>
 <h2>Productos:</h2>
 <c:forEach items="${productos}" var="prod"> 
 
	 <div id="detalle" align="center" onClick="verProd(${prod.idProducto})" style="border-style: solid;  cursor: pointer; width:150px ; height:150px;  border-width: 2px; float: left; margin: 8px; padding: 2px ;" >
	 	<c:out value="${prod.nombre}"/><br>
	 	<img src="producto/mostrarimagen.htm?id=${prod.idProducto}" alt="prod.nombre" width="80%"  height="80%">
	 </div>
	 
 </c:forEach> 