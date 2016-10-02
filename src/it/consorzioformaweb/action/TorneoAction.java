package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.TorneoMyBatisDAO;
import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TorneoAction extends ActionSupport{

	private Torneo torneo;
	private List<Torneo> elenco = new ArrayList<Torneo>();
	private String actionDaInvocare;
	// campo che viene inviato dalla pagina di lista per la modifica o cancellazione
	private String id;
	
	public String search() throws IOException{
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
		elenco = dao.search();		
		return "success";
	}
	
	public String create() throws IOException {
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();		
		dao.create(torneo);
		return "success";		
	}
	
	public String read() throws IOException{
		actionDaInvocare = "torneoCreateAction";
		if (id != null && id.length()>0){
			actionDaInvocare = "torneoUpdateAction";
			TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
			torneo = dao.read(Integer.parseInt(id));
		}
		return "success";
	}
	
	public String delete() throws IOException{
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
		torneo = dao.read(Integer.parseInt(id));
		dao.delete(torneo);
		return "success";
	}
	
	public String update() throws IOException {
		TorneoMyBatisDAO dao = new TorneoMyBatisDAO();
		//torneo = dao.read(Integer.parseInt(id));
		dao.update(torneo);
		return "success";
	}
	public List<Torneo> getElenco() {
		return elenco;
	}

	public void setElenco(List<Torneo> elenco) {
		this.elenco = elenco;
	}
	
	public void validateCreate(){
		if (torneo.getNome().length() == 0 || torneo.getNome() == null){
			addFieldError("ErroreNome", "nome obbligatorio");
		}
		try{
			if (torneo.getAnnoEdizione().toString().length() != 4){
				addFieldError("ErroreAnno", "L'anno deve dessere di 4 cifre");
			}
		} catch (Exception e ){
			addFieldError("ErroreAnno", "Anno obbligatorio");
		}
	}
	
	public void validateUpdate(){
		
		try{
			if (torneo.getId() == null || torneo.getId().toString().equals("")){
				addFieldError("ErroreID", "Errore ID");
			}
		} catch (Exception e ){
			addFieldError("ErroreAnno", "L'anno deve dessere di 4 cifre");
		}
		validateCreate();
	}
	
	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
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
}
