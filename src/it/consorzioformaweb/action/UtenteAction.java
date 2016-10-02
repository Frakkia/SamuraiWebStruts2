package it.consorzioformaweb.action;

import java.util.ArrayList;

import it.consorzioformaweb.model.Utente;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UtenteAction extends ActionSupport{
	
	private Utente utente;

	private ArrayList<Utente> elenco = new ArrayList<Utente>();
	
	@Override
	public String execute() throws Exception {
		elenco.add(new Utente("2","gino","rossi","Utonto"));
		elenco.add(new Utente("3","mario","verdi","Utonto"));
		elenco.add(utente);
		return "success";
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	@Override
	public void validate() {
		if (utente.getId().length() == 0 || utente.getId().equals("0")) {
			addFieldError("ErroreID", "id obbligatorio");
		}
		if (utente.getNome().length() == 0){
			addFieldError("ErroreNome", "Campo nome obbligatorio");
		}
	}

	public ArrayList<Utente> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<Utente> elenco) {
		this.elenco = elenco;
	}
}
