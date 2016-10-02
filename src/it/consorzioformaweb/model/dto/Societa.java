package it.consorzioformaweb.model.dto;

public class Societa {
	
	public Integer id;
	public Squadra squadra;
	public String nome;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Squadra getSquadra() {
		return squadra;
	}
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Societa [id=" + id + ", squadra=" + squadra + ", nome=" + nome
				+ "]";
	}
	
	
}
