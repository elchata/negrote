<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

		<c:url var="actionUrl" value="create.htm" /> 
		
		<form:form id="bandaForm" action="${actionUrl }" commandName="bandainc" method="post">		
			<fieldset>
				<legend></legend>
					<label for="horaInicio">Horario de Inicio:</label>
					<form:input path="horaInicio"/>
					<label for="horaFin">Horario de Fin:</label>
					<form:input path="horaFin"/>
					<label for="activo">Activo: </label>
					<form:checkbox path="activo" value="${command.activo}"/>
				</tr>	
					<form:input path="idBanda" type="hidden" /> 
			</fieldset> 
		</form:form>  