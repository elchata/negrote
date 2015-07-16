<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
function mensaje(valor){

var algo = valor;
}  
</script>
 <div id="menuCategorias" style="float: right;">
	 <ul>
	  <c:forEach items="${categorias}" var="cat"> 
	   <c:if test="${ cat.hijos.size() > 0 }">
	 	<li onclick="mensaje(${cat.idCategoria})"><c:out value="${cat.nombre}" />
	 		<ul>
	 		<c:forEach items="${cat.hijos}" var="hijo">
	 			<li onclick="mensaje(${hijo.idCategoria})"><c:out value="${hijo.nombre}" /></li>
	 		</c:forEach>	 		
	 		</ul>	 	
	 	</li>
	   </c:if>
	   <c:if test="${ cat.hijos.size() == 0 && cat.padre == null }">
	   <li onclick="mensaje(${cat.idCategoria})"><c:out value="${cat.nombre}" /></li>
	   </c:if>
	  </c:forEach>
	 </ul>
 </div>
 
 <h2>Productos:</h2>
 <c:forEach items="${productos}" var="prod"> 
 
	 <div id="detalle" align="center" onClick="javascript:location.href='./mostrar.htm?idProd=${prod.idProducto}';" style="border-style: solid;  cursor: pointer; width:150px ; height:150px;  border-width: 2px; float: left; margin: 8px; padding: 2px ;" >
	 	<c:out value="${prod.nombre}"/><br>
	 	<img src="producto/mostrarimagen.htm?id=${prod.idProducto}" alt="prod.nombre" width="80%"  height="80%">
	 </div>
	 
 </c:forEach> 
<c:out value='<%=request.getParameter("algo") %>'/>