package it.consorzioformaweb.model;

public class Utente {
	private String nome;
	private String cognome;
	private String profilo;
	private String id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Utente(){}
	
	public Utente( String id, String nome, String cognome, String profilo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.profilo = profilo;
		this.id = id;
	}
	
	
}
