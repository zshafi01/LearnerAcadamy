package com.simplilearn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.simplilearn.model.Course;
import com.simplilearn.model.Instructor;
import com.simplilearn.model.Student;

public class InstructorRepository {
	Session getSession(){
		Configuration cnfg= new Configuration();
    	cnfg.configure("hibernate.cfg.xml");
    	Session session = cnfg.buildSessionFactory().openSession();
    	return session;
	}

	
	public boolean insert(Instructor instructor) {
		try {
			Session session=getSession();
			Transaction transaction = session.beginTransaction();
			session.save(instructor);
			transaction.commit();
			session.close();
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		
	}

	public void update(Instructor a) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Instructor> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Instructor> instructorList = session.createQuery("FROM Instructor").list();

		transaction.commit();
		session.close();
		return instructorList;
	}

	
	public Instructor getById(int id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM Instructor where id=:id");
		query.setParameter("id", id);
		List resultList = query.getResultList();
		Instructor ins=null;
		if(resultList!=null && !resultList.isEmpty()) {
		ins= (Instructor)resultList.get(0);
		}
		transaction.commit();
		session.close();
		return ins;
	}

	
	public Instructor getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
