<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Dialog - Modal form</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<style>
label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
.hidden {
	visibility: hidden
}
</style>

<script>
	$(function() {

		var idSocieta = "-1";
		var idSquadra = "-1";
		var idTorneo = "-1";

		// POPOLO LA LISTA TORNEI!

		function populateTornei() {
			$.getJSON("../json/torneiJSON.action", function(data) {
				var torneoSel = $("#torneo_sel");
				var defOption = $("<option>");
				defOption.text("Scegli..");
				defOption.attr("value", -1);
				torneoSel.append(defOption);
				//for each
				$.each(data.tornei, function(key, val) {
					var option = $("<option>");
					option.text(val.nome);
					option.attr("value", val.id);
					torneoSel.append(option);
				});
				torneoSel.on("change", function(sender) {
					$("#torneo_sel option:selected").each(function() {
						idTorneo = $(this).val();
						populateList(idTorneo, -1, -1);
						populateSquadre(idTorneo);
					});
				});
			});
		}

		// POPOLO LE SQUADRE

		function populateSquadre(idTorneo) {
			$.getJSON("../json/squadreJSON.action?torneo.id=" + idTorneo,
					function(data) {

						var squadreSel = $("#squadra_sel");
						squadreSel.html("");
						var defOption = $("<option>");
						defOption.text("Scegli..");
						defOption.attr("value", "");
						squadreSel.append(defOption);
						//for each
						$.each(data.squadre, function(key, val) {
							var option = $("<option>");
							option.text(val.nome);
							option.attr("value", val.id);
							squadreSel.append(option);
						});
						squadreSel.on("change", function(sender) {
							$("#squadra_sel option:selected").each(function() {
								idSquadra = $(this).val();
								populateSocieta(idSquadra);
							});
						});
						squadreSel.removeClass("hidden");
					});

		}

		// POPOLO LE SOCIETA'

		function populateSocieta(idSquadra) {
			$.getJSON("../json/societaJSON.action?squadra.id=" + idSquadra,
					function(data) {

						var societaSel = $("#societa_sel");
						societaSel.html("");
						var defOption = $("<option>");
						defOption.text("Scegli..");
						defOption.attr("value", "");
						societaSel.append(defOption);
						//for each
						$.each(data.societas, function(key, val) {
							var option = $("<option>");
							option.text(val.nome);
							option.attr("value", val.id);
							societaSel.append(option);
						});
						societaSel.on("change", function(sender) {
							$("#societa_sel option:selected").each(function() {
								idSocieta = $(this).val();
								populateList(idTorneo, idSquadra, idSocieta);
							});
						});
						societaSel.removeClass("hidden");
					});

		}

		// RIEMPIO LE SOCIETA' NEL SELECT DEL FORM

		function populateSocietaForm() {
			$.getJSON("../json/societaJSON.action?societa.id=-1",
					function(data) {

						var societaSel = $("#societa");
						societaSel.html("");
						var defOption = $("<option>");
						defOption.text("Scegli..");
						defOption.attr("value", "");
						societaSel.append(defOption);
						//for each
						$.each(data.societas, function(key, val) {
							var option = $("<option>");
							option.text(val.nome);
							option.attr("value", val.id);
							option.attr("id", "option" + val.id);
							societaSel.append(option);
						});
					});

		}

		// POPOLO LA LISTA

		function populateList(idTorneo, idSquadra, idSocieta) {
			
			$.ajax({
				type : "GET",
				url : "../json/atletiJSONNew.action?po.idTorneo="
						+ idTorneo + "&po.idSquadra=" + idSquadra
						+ "&po.idSocieta=" + idSocieta, // chiamata che mi da i dati in formato json
				dataType : "json",
				success : function(dati) {
					var table = $("#atleta_tab");
					table.html("");
					if (dati.atleti.length != 0) {
						table.removeClass("hidden");
						table
								.append("<thead><tr class='ui-widget-header '><th>Nome</th><th>Cognome</th><th>Società</th><th>Elimina</th></tr></thead>");
						for (var i = 0; i < dati.atleti.length; i++) {
							var tr = $("<tr>");
							var td1 = $("<td>");
							td1.text(dati.atleti[i].nome);
							var td2 = $("<td>");
							td2.text(dati.atleti[i].cognome);
							var td3 = $("<td>");
							var tdDelete = $("<td>");
							td3.text(dati.atleti[i].societa.nome);
							tr.append(td1);
							tr.append(td2);
							tr.append(td3);
							tr.append(tdDelete);
							tdDelete.append("<a href='atletaDeleteAction.action?id="+ dati.atleti[i].id +"'><img src='../img/elimina.png' width='20px'/ ></a>");						
							table.append(tr);

						}
					}
				},
				error : function() {
					alert("Chiamata fallita!");
				}
			});
		}

		populateTornei();
		populateSocietaForm();
		populateList('-1', '-1', '-1');
		/* }); */

		//$(function() {
		var dialog, form,

		// From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
		//emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/"",
		name = $("#name"), surname = $("#surname"), email = $("#email"), societa = $("#societa"), allFields = $(
				[]).add(name).add(surname).add(email).add(societa), //.add( password ),
		tips = $(".validateTips");

		function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
				tips.removeClass("ui-state-highlight", 1500);
			}, 500);
		}

		function checkLength(o, n, min, max) {
			if (o.val().length > max || o.val().length < min) {
				o.addClass("ui-state-error");
				updateTips("Length of " + n + " must be between " + min
						+ " and " + max + ".");
				return false;
			} else {
				return true;
			}
		}

		function checkRegexp(o, regexp, n) {
			if (!(regexp.test(o.val()))) {
				o.addClass("ui-state-error");
				updateTips(n);
				return false;
			} else {
				return true;
			}
		}

		function addUser() {
			var valid = true;
			allFields.removeClass("ui-state-error");

			valid = valid && checkLength(name, "name", 3, 16);
			valid = valid && checkLength(surname, "surname", 3, 16);
			valid = valid && checkLength(email, "email", 6, 80);
			//valid = valid && checkLength( password, "password", 5, 16 );

			valid = valid
					&& checkRegexp(
							name,
							/^[a-z]([0-9a-z_\s])+$/i,
							"Name may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
			valid = valid
					&& checkRegexp(
							surname,
							/^[a-z]([0-9a-z_\s])+$/i,
							"Surname may consist of a-z, 0-9, underscores, spaces and must begin with a letter.");
			/* valid = valid
					&& checkRegexp(email, emailRegex, "eg. ui@jquery.com");  */

			if (valid) {
				$.ajax({
					type : "GET",
					url : "atletaCreateAction.action",
					data : {
						'atleta.nome' : name.val(),
						'atleta.cognome' : surname.val(),
						'atleta.societa.id' : societa.val()
					},
					dataType: "json",
					success : function(dati) {
						$("#atleta_tab tbody").append(
								"<tr>" + "<td>" + name.val() + "</td>" + "<td>"
										+ surname.val() + "</td>" + "<td>"
										+ $("#option" + societa.val()).text()
										+ "</td>" + "<td><a href='atletaDeleteAction.action?id=" + dati.atleta.id + "'><img src='../img/elimina.png' width='20px'/></a></td></tr>");
						dialog.dialog("close");
					}
				});
				return valid;
			}
		}

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 350,
			modal : true,
			buttons : {
				"Inserisci atleta" : addUser,
				Cancel : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				allFields.removeClass("ui-state-error");
			}
		});

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			addUser();
		});

		$("#create-user").button().on("click", function() {
			dialog.dialog("open");
		});
		
	});
</script>
</head>
<body>

	<div id="dialog-form" title="Inserisci un nuovo atleta">
		<p class="validateTips">Tutti i campi sono obbligatori.</p>

		<form>
			<fieldset>
				<label for="name">Name</label> <input type="text" name="name"
					id="name" value="" class="text ui-widget-content ui-corner-all">
				<label for="surname">Cognome</label> <input type="text"
					name="surname" id="surname" value=""
					class="text ui-widget-content ui-corner-all"> <label
					for="email">Email</label> <input type="text" name="email"
					id="email" value="your@mail.com"
					class="text ui-widget-content ui-corner-all"> <label
					for="societa">Società</label> <select id="societa"
					class="text ui-widget-content ui-corner-all">
				</select>

				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1"
					style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>

	<select id="torneo_sel">

	</select>

	<select id="squadra_sel" class="hidden">

	</select>

	<select id="societa_sel" class="hidden">

	</select>

	<table border='1' id="atleta_tab"
		class="hidden ui-widget ui-widget-content"></table>

	<!--<div id="users-contain" class="ui-widget">
  <h1>Existing Users:</h1>
  <table id="users" class="ui-widget ui-widget-content">
    <thead>
      <tr class="ui-widget-header ">
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John Doe</td>
        <td>john.doe@example.com</td>
        <td>johndoe1</td>
      </tr>
    </tbody>
  </table>
</div> -->


	<button id="create-user">Aggiungi atleta</button>


</body>
</html>