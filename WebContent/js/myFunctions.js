function printTabella()
{
	// eseguo la chiamata ajax per recuperare i dati
	$.ajax(
	{
		type: "GET",
		url: "../json/atletiJSON.action",	// chiamata che mi da i dati in formato json
		dataType: "json",
		success: function(dati)
				{
					var atleti = dati.atleti;
					var sceltaSocieta = $('#selectSocieta').val();
					var sceltaSquadra = $('#selectSquadra').val();
					var sceltaTorneo = $('#selectTorneo').val();
					ris = "<table border='1'>";
					ris += "<thead>";
					ris += "<th>Nome Atleta</th><th>Cognome Atleta</th><th>Societa'</th><th>Squadra</th><th>Torneo</th><th>Anno Iscrizione</th>";
					ris += "</thead>";
					ris += "<tbody>";
					for (i = 0; i < atleti.length; i++)
					{
						if (((sceltaSocieta == null || sceltaSocieta == '-1') 
								&& (sceltaSquadra == null || sceltaSquadra == '-1') 
								&& (sceltaTorneo == null || sceltaTorneo == '-1'))  // tutti e 3 vuoti
									|| (sceltaSocieta == atleti[i].societa.id 
										&& ((sceltaSquadra == null || sceltaSquadra == '-1') || sceltaSquadra == atleti[i].societa.squadra.id)
										&& ((sceltaTorneo == null || sceltaTorneo == '-1') || sceltaTorneo == atleti[i].societa.squadra.torneo.id)) // societa selezionato e gli altri selezionati o no
											|| (sceltaSquadra == atleti[i].societa.squadra.id 
												&& ((sceltaSocieta == null || sceltaSocieta == '-1') || sceltaSocieta == atleti[i].societa.id)
												&& ((sceltaTorneo == null || sceltaTorneo == '-1') || sceltaTorneo == atleti[i].societa.squadra.torneo.id))  // squadra selezionato e gli altri si o no
													|| (sceltaTorneo == atleti[i].societa.squadra.torneo.id
															&& ((sceltaSocieta == null || sceltaSocieta == '-1') || sceltaSocieta == atleti[i].societa.id)
															&& ((sceltaSquadra == null || sceltaSquadra == '-1') || sceltaSquadra == atleti[i].societa.squadra.id))){
						//if (sceltaSocieta == null || sceltaSocieta == '-1' || sceltaSocieta == atleti[i].societa.id){
							ris += "<tr><td>" + atleti[i].nome + "</td>";
							ris += "<td>" + atleti[i].cognome + "</td>";
							ris += "<td>" + atleti[i].societa.nome + "</td>";
							ris += "<td>" + atleti[i].societa.squadra.nome + "</td>";
							ris += "<td>" + atleti[i].societa.squadra.torneo.nome + "</td>";
							ris += "<td>" + atleti[i].annoIscrizione + "</td></tr>";
						}
					}
					ris += "</tbody>";
					ris += "</table>";
					
					$("#target").html(ris);
				},
		error: function(){alert("Chiamata fallita!");}
	});	
}

function initSelectSocieta()
{
	$.ajax(
	{
		type: "GET",
		url: "../json/societaJSON.action",
		dataType: "json",
		success: function(dati)
			{
				var societas = dati.societas;
				ris = "<option value='-1'>Tutte le societa'</option>";
				for (i = 0; i < societas.length; i++)
				{
					ris += "<option value='" + societas[i].id +"'>" + societas[i].nome + "</option>";
				}
				$("#selectSocieta").html(ris);
			}
	});
}

function initSelectSquadre()
{
	$.ajax(
	{
		type: "GET",
		url: "../json/squadreJSON.action",
		dataType: "json",
		success: function(dati)
			{
				var squadre = dati.squadre;
				ris = "<option value='-1'>Tutte le squadre</option>";
				for (i = 0; i < squadre.length; i++)
				{
					ris += "<option value='" + squadre[i].id +"'>" + squadre[i].nome + "</option>";
				}
				$("#selectSquadra").html(ris);
			}
	});
}

function initSelectTornei()
{
	$.ajax(
	{
		type: "GET",
		url: "../json/torneiJSON.action",
		dataType: "json",
		success: function(dati)
			{
				var tornei = dati.tornei;
				ris = "<option value='-1'>Tutti i tornei</option>";
				for (i = 0; i < tornei.length; i++)
				{
					ris += "<option value='" + tornei[i].id +"'>" + tornei[i].nome + "</option>";
				}
				$("#selectTorneo").html(ris);
			}
	});
}