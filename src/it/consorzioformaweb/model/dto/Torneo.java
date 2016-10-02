package it.consorzioformaweb.model.dto;

public class Torneo {
	
	private Integer id;
	private Integer annoEdizione;
	private String nome;
	
	
	public Torneo(Integer id, Integer annoEdizione, String nome) {
		super();
		this.id = id;
		this.annoEdizione = annoEdizione;
		this.nome = nome;
	}
	public Torneo(Integer annoEdizione, String nome) {
		super();
		this.annoEdizione = annoEdizione;
		this.nome = nome;
	}
	public Torneo() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAnnoEdizione() {
		return annoEdizione;
	}
	public void setAnnoEdizione(Integer annoEdizione) {
		this.annoEdizione = annoEdizione;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Torneo [id=" + id + ", annoEdizione=" + annoEdizione
				+ ", nome=" + nome + "]";
	}
	
	
}
