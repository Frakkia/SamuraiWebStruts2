package it.consorzioformaweb.action;

import it.consorzioformaweb.model.dao.AtletaMyBatisDAO;
import it.consorzioformaweb.model.dto.Atleta;

import java.io.IOException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AtletaAction extends ActionSupport{

	private List<Atleta> atleti;
	private Atleta atleta;
	private String id;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String read(){
		
		return SUCCESS;
	}

	
	public String create() throws IOException{
		AtletaMyBatisDAO dao = new AtletaMyBatisDAO();
			dao.create(atleta);
		return SUCCESS;
	}
	
	public String delete() throws IOException{
		AtletaMyBatisDAO dao = new AtletaMyBatisDAO();
		atleta = dao.read(Integer.parseInt(id));
		dao.delete(atleta);
		return SUCCESS;
	}
	
	public void validateCreate(){
		
	}
	
	public List<Atleta> getAtleti() {
		return atleti;
	}

	public void setAtleti(List<Atleta> atleti) {
		this.atleti = atleti;
	}


	public Atleta getAtleta() {
		return atleta;
	}


	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
}
