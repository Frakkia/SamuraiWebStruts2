package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Torneo;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TorneoMyBatisDAO {

	private SqlSessionFactory sessionFactory;
	private SqlSession session;
	
	public TorneoMyBatisDAO() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	public List<Torneo> search(){
		session = sessionFactory.openSession();
		List<Torneo> result = session.selectList("TorneoMapping.getAll");
		session.close();
		return result;
	}
	
	public Integer create(Torneo t){
		session = sessionFactory.openSession();
		session.insert("TorneoMapping.insert",t);
		session.commit();
		session.close();
		return t.getId();
	}
	
	public Torneo read(int id){
		session = sessionFactory.openSession();
		Torneo  result = session.selectOne("TorneoMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Torneo torneo){
		session = sessionFactory.openSession();
		session.update("TorneoMapping.update", torneo);
		session.commit();
		session.close();
	}
	
	public void delete(Torneo torneo){
		session = sessionFactory.openSession();
		session.delete("TorneoMapping.delete", torneo);
		session.commit();
		session.close();
	}
}
