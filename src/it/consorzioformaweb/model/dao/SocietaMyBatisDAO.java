package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Societa;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SocietaMyBatisDAO {
	private SqlSessionFactory sessionFactory;
	private SqlSession session;
	
	public SocietaMyBatisDAO() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	public List<Societa> search(){
		session = sessionFactory.openSession();
		List<Societa> result = session.selectList("SocietaMapping.getAll");
		session.close();
		return result;
	}
	
	public List<Societa> searchBySquadra(Integer s){
		List<Societa> result;
		session = sessionFactory.openSession();
		if (s == -1){
			result = session.selectList("SocietaMapping.getAll");
		} else{
			result = session.selectList("SocietaMapping.getBySquadra",s);
		}
		session.close();
		return result;
	}
	
	public Integer create(Societa s){
		session = sessionFactory.openSession();
		session.insert("SocietaMapping.insert",s);
		session.commit();
		session.close();
		return s.getId();
	}
	
	public Societa read(int id){
		session = sessionFactory.openSession();
		Societa  result = session.selectOne("SocietaMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Societa s){
		session = sessionFactory.openSession();
		session.update("SocietaMapping.update", s);
		session.commit();
		session.close();
	}
	
	public void delete(Societa s){
		session = sessionFactory.openSession();
		session.delete("SocietaMapping.delete", s);
		session.commit();
		session.close();
	}
}
