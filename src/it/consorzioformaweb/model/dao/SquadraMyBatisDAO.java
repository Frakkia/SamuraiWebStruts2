package it.consorzioformaweb.model.dao;

import it.consorzioformaweb.model.dto.Squadra;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SquadraMyBatisDAO {

	private SqlSessionFactory sessionFactory;
	private SqlSession session;
	
	public SquadraMyBatisDAO() throws IOException{
		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	public List<Squadra> search(){
		session = sessionFactory.openSession();
		List<Squadra> result = session.selectList("SquadraMapping.getAll");
		session.close();
		return result;
	}
	
	public List<Squadra> searchByTorneo(Integer t){
		List<Squadra> result;
		session = sessionFactory.openSession();
		if (t == -1){
			result = session.selectList("SquadraMapping.getAll");
		} else{
			result = session.selectList("SquadraMapping.getByTorneo",t);
		}
		session.close();
		return result;
	}
	
	public Integer create(Squadra s){
		session = sessionFactory.openSession();
		session.insert("SquadraMapping.insert",s);
		session.commit();
		session.close();
		return s.getId();
	}
	
	public Squadra read(int id){
		session = sessionFactory.openSession();
		Squadra  result = session.selectOne("SquadraMapping.getById", id);
		session.close();
		return result;
	}
	
	public void update(Squadra s){
		session = sessionFactory.openSession();
		session.update("SquadraMapping.update", s);
		session.commit();
		session.close();
	}
	
	public void delete(Squadra s){
		session = sessionFactory.openSession();
		session.delete("SquadraMapping.delete", s);
		session.commit();
		session.close();
	}
}

