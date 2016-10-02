package it.consorzioformaweb.action;

import it.consorzioformaweb.model.Utente;

public class LoginAction {

	private String username;
	private String password;
	// campo che viene restituito/usato in Welcome.jsp
	private Utente utente;
	
	public String execute(){
		if (username.equalsIgnoreCase("admin") && password.equals("123")){
			utente = new Utente("2","Francesco","Grivet","Amministratore");
			return "success";
		} else {
			return "error";
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
}
