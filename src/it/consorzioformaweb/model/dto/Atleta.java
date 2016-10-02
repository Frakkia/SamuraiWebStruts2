package it.consorzioformaweb.model.dto;

public class Atleta extends Persona {

	//getId() id di t_persona
	private Integer idAtleta;
	private Societa societa;
	private Integer annoIscrizione;
	
	
	public Integer getIdAtleta() {
		return idAtleta;
	}
	public void setIdAtleta(Integer idAtleta) {
		this.idAtleta = idAtleta;
	}
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public Integer getAnnoIscrizione() {
		return annoIscrizione;
	}
	public void setAnnoIscrizione(Integer annoIscrizione) {
		this.annoIscrizione = annoIscrizione;
	}
	@Override
	public String toString() {
		return "Atleta" + super.toString() + " [idAtleta=" + idAtleta + ", societa=" + societa
				+ ", annoIscrizione=" + annoIscrizione + "]";
	}
	
	
}
