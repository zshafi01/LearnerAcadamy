package com.simplilearn.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;

public class CourseRepository {
	Session getSession(){
		Configuration cnfg= new Configuration();
    	cnfg.configure("hibernate.cfg.xml");
    	Session session = cnfg.buildSessionFactory().openSession();
    	return session;
	}

	public boolean insert(Course course) {
		try {
			Session session=getSession();
			Transaction transaction = session.beginTransaction();
			session.save(course);
			transaction.commit();
			session.close();
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		
	}

	
	public void update(Course a) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Course> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Course> courseList = session.createQuery("FROM Course").list();

		transaction.commit();
		session.close();
		return courseList;
	}

	
	public Course getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Course getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
