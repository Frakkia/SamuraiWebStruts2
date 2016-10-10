package it.consorzioformaweb.model.dao;


import it.consorzioformaweb.model.dto.Atleta;
import it.consorzioformaweb.model.dto.ParameterObject;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AtletaMyBatisDAO {
	private SqlSessionFactory sessionFactory;
	private SqlSession session;
	
	public AtletaMyBatisDAO() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	public List<Atleta> search(){
		session = sessionFactory.openSession();
		List<Atleta> result = session.selectList("AtletaMapping.getAll");
		session.close();
		return result;
	}
	
	public List<Atleta> searchByIdSocieta(int id){
		session = sessionFactory.openSession();
		List<Atleta> result = session.selectList("AtletaMapping.getByIdSocieta",id);
		session.close();
		return result;
	}
	
	public List<Atleta> searchByAll(ParameterObject po){
		session = sessionFactory.openSession();
		
		List<Atleta> result = session.selectList("AtletaMapping.getByAll",po);
		session.close();
		return result;
	}
	
	public Integer create(Atleta a){
		session = sessionFactory.openSession();
		session.insert("AtletaMapping.insertPersona",a);
		session.insert("AtletaMapping.insertAtleta",a);
		session.commit();
		session.close();
		return a.getId();
	}
	
	public Atleta read(int id){
		session = sessionFactory.openSession();
		Atleta  result = session.selectOne("AtletaMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Atleta a){
		session = sessionFactory.openSession();
		session.update("AtletaMapping.updatePersona", a);
		session.update("AtletaMapping.updateAtleta", a);
		session.commit();
		session.close();
	}
	
	public void delete(Atleta a){
		
		session = sessionFactory.openSession();
		session.delete("AtletaMapping.deleteAtleta",a);
		session.delete("AtletaMapping.deletePersona", a);		
		session.commit();
		session.close();
	}
}
