package it.consorzioformaweb.model.dto;

public class Squadra {

	private Integer id;
	private String nome;
	private Torneo torneo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + ", torneo=" + torneo
				+ "]";
	}
	
	
	
}
