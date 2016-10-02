package it.consorzioformaweb.model.dto;

import java.util.Date;

public class Persona {

	private Integer id;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String sesso;
	private String comuneNascita;
	private String indirizzoResidenza;
	private String telefono;
	private String mail;
	private String codiceFiscale;
	
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTel(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getIndirizzoResidenza() {
		return indirizzoResidenza;
	}
	public void setIndirizzoResidenza(String indirizzoResidenza) {
		this.indirizzoResidenza = indirizzoResidenza;
	}
	@Override
	public String toString() {
		return " id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", dataNascita=" + dataNascita + ", sesso=" + sesso
				+ ", comuneNascita=" + comuneNascita + ", indirizzoResidenza="
				+ indirizzoResidenza + ", telefono=" + telefono + ", mail="
				+ mail + ", codiceFiscale=" + codiceFiscale + " ";
	}
	
	
}
