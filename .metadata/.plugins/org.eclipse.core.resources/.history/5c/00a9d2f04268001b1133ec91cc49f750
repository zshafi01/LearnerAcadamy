package com.simplilearn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.simplilearn.model.User;

public class UserRepository {
	
	Session getSession(){
		Configuration cnfg= new Configuration();
    	cnfg.configure("hibernate.cfg.xml");
    	Session session = cnfg.buildSessionFactory().openSession();
    	return session;
	}

	public boolean insert(User user) {
		// TODO Auto-generated method stub
		try {
		Session session=getSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public List<User> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<User> users = session.createQuery("FROM User").list();
	
		
		
		transaction.commit();
		session.close();
		return users;
	}

	public User findbyemail(String email) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM User where email=:e");
		query.setParameter("e", email);
		List resultList = query.getResultList();
		User user=null;
		if(resultList!=null && !resultList.isEmpty()) {
		user= (User)resultList.get(0);
		}
		transaction.commit();
		session.close();
		return user;
	}




//	@Override
//	public void update(User a) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(int a) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public User getById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User getByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
