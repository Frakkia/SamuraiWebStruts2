<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>

<script type="text/javascript">
$(function populateSocieta(idSquadra) {
			$.getJSON("../json/societaJSON.action?squadra.id=" + idSquadra,
					function(data) {

						var societaSel = $("#form_idSocieta");
						societaSel.html("");
						var defOption = $("<option>");
						defOption.text("Scegli..");
						defOption.attr("value", -1);
						societaSel.append(defOption);
						//for each
						$.each(data.societas, function(key, val) {
							var option = $("<option>");
							option.text(val.nome);
							option.attr("value", val.id);
							societaSel.append(option);
						});
					});

		})
</script>
</head>
<body>

<form id="formAtleta">
	Nome: <input id="form_nomeAtleta" type="text" name="atleta.nome" />
	Società: <select id="form_idSocieta" name="atleta.societa.id">
		
	</select>
	<input id="form_button" type="button" name="Invia" value="Invia dati"/>
</form>
</body>
</html>