package it.consorzioformaweb.action;

import java.io.IOException;
import java.util.List;

import it.consorzioformaweb.model.dao.AtletaMyBatisDAO;
import it.consorzioformaweb.model.dao.SocietaMyBatisDAO;
import it.consorzioformaweb.model.dao.SquadraMyBatisDAO;
import it.consorzioformaweb.model.dao.TorneoMyBatisDAO;
import it.consorzioformaweb.model.dto.Atleta;
import it.consorzioformaweb.model.dto.Societa;
import it.consorzioformaweb.model.dto.Squadra;
import it.consorzioformaweb.model.dto.Torneo;
/**
 * Classe che restituisce i dati delle varie classi di modello
 * (Torneo, Squadra, Societa) in formato JSON
 * @author Corso
 *
 */
public class JSONAction {

	private Squadra squadra;
	private Torneo torneo;
	private Atleta atleta;
	private Societa societa;
	
	private int id_societa;
	
	
	private List<Squadra> squadre;	
	private List<Societa> societas;
	private List<Torneo> tornei;
	private List<Atleta> atleti;
	
	
	public String torneiJSON() throws IOException{
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
				tornei = dao.search();
		return "success";
	}

	public String squadreJSON() throws IOException{
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		
		if (torneo != null &&
		torneo.getId() != -1)
		{
			squadre = dao.searchByTorneo(torneo.getId());
		} 
		else
		{
			squadre = dao.search();
		}
		
		return "success";
	}
	
	public String atletiJSON() throws IOException{
		AtletaMyBatisDAO dao = new AtletaMyBatisDAO();
		
		if (id_societa != 0 &&
				id_societa != -1)
		{	
			atleti = dao.searchByIdSocieta(societa.getId());
		}
		else
			atleti = dao.search();
		return "success";
	}
	
	public String societaJSON() throws IOException{
		SocietaMyBatisDAO dao = new SocietaMyBatisDAO();
		
		if (torneo!=null &&
		torneo.getId() != -1)
		{
			societas = dao.searchBySquadra(squadra.getId());
		} 
		else
		{
			societas = dao.search();
		}
		
		return "success";
	}
	
	
	// Costruttori
	
	
	public List<Societa> getSocietas() {
		return societas;
	}

	public void setSocietas(List<Societa> societas) {
		this.societas = societas;
	}

	public List<Torneo> getTornei() {
		return tornei;
	}

	public void setTornei(List<Torneo> tornei) {
		this.tornei = tornei;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	
	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	
	public List<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(List<Squadra> squadre) {
		this.squadre = squadre;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public List<Atleta> getAtleti() {
		return atleti;
	}

	public void setAtleti(List<Atleta> atleti) {
		this.atleti = atleti;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public int getId_societa() {
		return id_societa;
	}

	public void setId_societa(int id_societa) {
		this.id_societa = id_societa;
	}
}
