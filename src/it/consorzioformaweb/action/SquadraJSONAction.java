package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SquadraMyBatisDAO;
import it.consorzioformaweb.model.dto.Squadra;

import java.io.IOException;
import java.util.List;

public class SquadraJSONAction {

	private Squadra squadra;
	private List<Squadra> squadre;
	
	
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
	
	public String execute() throws IOException{
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		if (squadra!=null && squadra.getTorneo() != null &&
				squadra.getTorneo().getId() != null &&
				squadra.getTorneo().getId() != -1){
			squadre = dao.searchByTorneo(squadra.getTorneo().getId());
		} else {
			squadre = dao.search();
		}
		return "success";
	}
}
