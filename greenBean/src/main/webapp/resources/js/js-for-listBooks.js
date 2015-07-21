
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
	
	$("#prodDialog").dialog({
		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Cerrar" : function() {
				$(this).dialog('close');
			}
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


function multiplicar(val){
	m1 = document.getElementById("mult").value;
	m2 = val;
	r = m1*m2;
	document.getElementById("resultado").innerHTML= "$ " + r;
} 

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

function verProd(id) {
	$.get("mostrar.htm?idProd=" + id, function(result) {
		$("#prodDialog").html(result);
		$('#prodDialog').dialog("option", "title", 'Datos Producto');
		$("#prodDialog").dialog('open'); 
	});
} 

function resetDialog(form) {
	form.find("input").val("");
} 
