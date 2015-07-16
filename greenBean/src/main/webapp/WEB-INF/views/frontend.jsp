<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<link rel="stylesheet" href='<c:url value="/resources/css/pure-0.4.2.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" href='<c:url value="/resources/css/jquery-ui-1.10.4.custom.css"/>'>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script type="text/javascript" src='<c:url value="/resources/js/js-for-listBooks.js"/>'></script>
<style type="text/css">
th {
	text-align: left
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GreenBean</title>
<script>

$(function() {
	$("#provDialog").dialog({
		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Guardar" : function() {
				$('#provForm').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {	
			resetDialog($('#provForm'));	
			$(this).dialog('close');
		}
	});
	
	function resetDialog(form) {
	
		form.find("input").val("");
	}
	
	$("#abrido").button().click(function () {
		$("#provDialog").dialog("option", "title", 'Crear Provincia');
		$("#provDialog").dialog("open");
	});
});
</script>
</head>
<body>
<nav>
	<jsp:include page="menuAdmin.jsp" />
</nav>
<div id="cuerpo">
	<jsp:include page="${vista}" />
</div> 
</body>
</html>