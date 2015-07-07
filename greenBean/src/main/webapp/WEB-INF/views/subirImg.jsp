 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form  method="POST" action="subir.htm" modelattribute="imagenAux">
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