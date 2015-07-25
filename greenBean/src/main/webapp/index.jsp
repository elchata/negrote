<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>jQuery UI Dialog - Dialogo modal</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>
<script>
$(function () {
$("#dialog").dialog({
autoOpen: false,
modal: true
});
$("#abrir")
.button()
.click(function () {
$("#dialog").dialog("open");
});
});
</script>
</head>

<body>
Di�logo:
<div id="dialog" title="Dialogo b�sico">
<p>Di�logo b�sico modal. Puede ser movido, redimensionado y cerrado haciendo clic sobre el bot�n 'X'.</p>
</div>
<button id="abrir">Abrir di�logo</button>
<a href="hello.htm">ir a pagina</a> 
</body>

</html>  
