<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="create.htm" /> 
		
		<form:form id="queryForm" action="${actionUrl }" commandName="confirmadoInc" method="post">		
			<fieldset>
				<legend></legend>
					<label for="auxString">Observaciones:</label>
					<form:textarea path="estado.auxString" disabled="true" rows="5" cols="30" />		
					<form:input path="idPedido" type="hidden" /> 
			</fieldset> 
		</form:form>  