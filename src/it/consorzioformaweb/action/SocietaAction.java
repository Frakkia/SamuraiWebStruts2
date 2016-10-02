package it.consorzioformaweb.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.consorzioformaweb.model.dao.SocietaMyBatisDAO;
import it.consorzioformaweb.model.dao.SquadraMyBatisDAO;
import it.consorzioformaweb.model.dto.Societa;
import it.consorzioformaweb.model.dto.Squadra;

@SuppressWarnings("serial")
public class SocietaAction extends ActionSupport {

	private Societa societa;
	private List<Societa> elenco = new ArrayList<Societa>();
	private String actionDaInvocare;
	private HashMap<Integer, String> map = new HashMap<Integer, String>();
	private Integer id_squadra;
	private String id;
	private String start;
	private String startText;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<Integer, String> createMap(){
		map = new HashMap<Integer, String>();
		SquadraMyBatisDAO dao = null;
		try {
			dao = new SquadraMyBatisDAO();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Squadra> squadre = dao.search();
		for (Squadra s:squadre){
			map.put(s.getId(), s.getNome());
		}
		
		return map;
	}
	
	public String search() throws IOException{
		createMap();
		SocietaMyBatisDAO dao = new SocietaMyBatisDAO();
		if (id_squadra == null)
			setElenco(dao.search());
		else
			setElenco(dao.searchBySquadra(id_squadra));	
		return "success";
	}
	
	
	public String create() throws IOException {
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		Squadra s = dao.read(id_squadra);
		
		societa.setSquadra(s);
		
		SocietaMyBatisDAO daoSoc = new SocietaMyBatisDAO();
		daoSoc.create(societa);
		
		return "success";		
	}
	
	public String read() throws IOException{
		createMap();
		start="-1";
		startText=getText("societa.squadra.tutti");
		setActionDaInvocare("societaCreateAction");
				
		if (id != null && id.length()>0){
			setActionDaInvocare("societaUpdateAction");
			SocietaMyBatisDAO dao = new SocietaMyBatisDAO();
			societa = dao.read(Integer.parseInt(id));
			start=societa.getSquadra().getId().toString();
			startText=societa.getSquadra().getNome();
		}
		return "success";
	}
	
	public String delete() throws IOException{
		SocietaMyBatisDAO dao = new SocietaMyBatisDAO();
		societa = dao.read(Integer.parseInt(id));
		dao.delete(societa);
		return "success";
	}
	
	public String update() throws IOException {
		SquadraMyBatisDAO dao = new SquadraMyBatisDAO();
		Squadra s = dao.read(id_squadra);
		
		societa.setSquadra(s);
		
		SocietaMyBatisDAO daoSoc = new SocietaMyBatisDAO();
		
		daoSoc.update(societa);
		return "success";
	}
	
	public void validateCreate(){
		if (societa.getNome().length() == 0 || societa.getNome() == null){
			addFieldError("ErroreNome", getText("societa.nome.required"));
			createMap();
		}
		if (id_squadra == -1){
			addFieldError("ErroreSquadra", "Scegliere la squadra");
			createMap();
		}
	}
	
	public void validateUpdate(){
		if (societa.getNome().length() == 0 || societa.getNome() == null){
			addFieldError("ErroreNome", getText("societa.nome.required"));
			createMap();
		}
		if (id_squadra == -1){
			addFieldError("ErroreSquadra", "Scegliere la squadra");
			createMap();
		}

	}

	
	
	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

	public void setMap(HashMap<Integer, String> map) {
		this.map = map;
	}

	public Integer getId_squadra() {
		return id_squadra;
	}

	public void setId_squadra(Integer id_squadra) {
		this.id_squadra = id_squadra;
	}
	public List<Societa> getElenco() {
		return elenco;
	}

	public void setElenco(List<Societa> elenco) {
		this.elenco = elenco;
	}

	public String getActionDaInvocare() {
		return actionDaInvocare;
	}

	public void setActionDaInvocare(String actionDaInvocare) {
		this.actionDaInvocare = actionDaInvocare;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStartText() {
		return startText;
	}

	public void setStartText(String startText) {
		this.startText = startText;
	}
}
