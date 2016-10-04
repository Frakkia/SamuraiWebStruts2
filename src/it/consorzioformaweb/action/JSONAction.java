package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SocietaMyBatisDAO;
import it.consorzioformaweb.model.dao.SquadraMyBatisDAO;
import it.consorzioformaweb.model.dao.TorneoMyBatisDAO;
import it.consorzioformaweb.model.dto.Societa;
import it.consorzioformaweb.model.dto.Squadra;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.List;
/**
 * Classe che restituisce i dati delle varie classi di modello
 * (Torneo, Squadra, Societa) in formato JSON
 * @author Corso
 *
 */
public class JSONAction {

	private Squadra squadra;
	private Torneo torneo;
	
	private List<Squadra> squadre;	
	private List<Societa> societas;
	private List<Torneo> tornei;
	
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
}
