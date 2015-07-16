function addProv() {
	$('#provDialog').dialog("option", "title", 'Agregar provincia');
	$('#provDialog').dialog('open');
}

function editarProv(id) {
	$.get("editar.htm?idProv=" + id, function(result) {
		$("#provDialog").html(result);
		$('#provDialog').dialog("option", "title", 'Editar Provincia');
		$("#provDialog").dialog('open'); 
	});
} 

function resetDialog(form) {
	form.find("input").val("");
} 
