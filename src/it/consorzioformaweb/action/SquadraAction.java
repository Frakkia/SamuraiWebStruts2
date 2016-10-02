package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.SquadraMyBatisDAO;
import it.consorzioformaweb.model.dao.TorneoMyBatisDAO;
import it.consorzioformaweb.model.dto.Squadra;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SquadraAction extends ActionSupport {
	
	private Squadra squadra;
	private List<Squadra> elenco = new ArrayList<Squadra>();
	private String actionDaInvocare;
	private String id;
	private Integer id_torneo;
	private boolean inserito = false;
	
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	public HashMap<Integer, String> createMap(){
		map = new HashMap<Integer, String>();
		TorneoMyBatisDAO dao = null;
		try {
			dao = new TorneoMyBatisDAO();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Torneo> tornei = dao.search();
		for (Torneo t:tornei){
			map.put(t.getId(), t.getNome());
		}
		
		return map;
	}
	
	public String search() throws IOException{
		createMap();
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		if (id_torneo == null)
			elenco = dao.search();
		else
			elenco = dao.searchByTorneo(id_torneo);	
		return "success";
	}
	
	
	public String create() throws IOException {
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
		Torneo t = dao.read(id_torneo);
		
		squadra.setTorneo(t);
		
		SquadraMyBatisDAO daoSq = new SquadraMyBatisDAO();
		daoSq.create(squadra);
		inserito = true;
		return "success";		
	}
	
	public String read() throws IOException{
		createMap();
		actionDaInvocare = "squadraCreateAction";
				
		if (id != null && id.length()>0){
			actionDaInvocare = "squadraUpdateAction";
			SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
			squadra = dao.read(Integer.parseInt(id));
		}
		return "success";
	}
	
	public String delete() throws IOException{
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		squadra = dao.read(Integer.parseInt(id));
		dao.delete(squadra);
		return "success";
	}
	
	public String update() throws IOException {
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
		Torneo t = dao.read(id_torneo);
		
		squadra.setTorneo(t);
		
		SquadraMyBatisDAO daoSq = new SquadraMyBatisDAO();
		
		daoSq.update(squadra);
		return "success";
	}
	
	public void validateCreate(){
		if (squadra.getNome().length() == 0 || squadra.getNome() == null){
			addFieldError("ErroreNome", getText("squadra.nome.required"));
			createMap();
		}
		if (id_torneo == -1){
			addFieldError("ErroreTorneo", "Scegliere il torneo");
			createMap();
		}
	}
	
	public void validateUpdate(){
		if (squadra.getNome().length() == 0 || squadra.getNome() == null){
			addFieldError("ErroreNome", getText("squadra.nome.required"));
			createMap();
		}
		if (id_torneo == -1){
			addFieldError("ErroreTorneo", "Scegliere il torneo");
			createMap();
		}

	}
	
	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public List<Squadra> getElenco() {
		return elenco;
	}

	public void setElenco(List<Squadra> elenco) {
		this.elenco = elenco;
	}

	public String getActionDaInvocare() {
		return actionDaInvocare;
	}

	public void setActionDaInvocare(String actionDaInvocare) {
		this.actionDaInvocare = actionDaInvocare;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}
	public Integer getId_torneo() {
		return id_torneo;
	}
	public void setId_torneo(Integer id_torneo) {
		this.id_torneo = id_torneo;
	}
	public boolean isInserito() {
		return inserito;
	}
	public void setInserito(boolean inserito) {
		this.inserito = inserito;
	}
}
