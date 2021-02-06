package com.simplilearn.repository;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;
import com.simplilearn.model.Instructor;
import com.simplilearn.model.Student;
import com.simplilearn.model.User;

public class ClassRepository {
	
	Session getSession(){
		Configuration cnfg= new Configuration();
    	cnfg.configure("hibernate.cfg.xml");
    	Session session = cnfg.buildSessionFactory().openSession();
    	return session;
	}

	public boolean insert(Classes cls, Integer instructorid, Integer courseid) {
		// TODO Auto-generated method stub
		try {
		Session session=getSession();
		Transaction transaction = session.beginTransaction();
//		Student student = session.get(Student.class, studentid);
		Course course = session.get(Course.class, courseid);
		Instructor instructor = session.get(Instructor.class, instructorid);
		cls.setCourse(course);
		cls.setInstractor(instructor);
		
		
		session.save(cls);
		transaction.commit();
		session.close();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public List<Classes> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Classes> classesList = session.createQuery("FROM Classes").list();

		transaction.commit();
		session.close();
		return classesList;
	}

	public Classes findbyid(int id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM Classes where id=:id");
		query.setParameter("id", id);
		List resultList = query.getResultList();
		Classes cls=null;
		if(resultList!=null && !resultList.isEmpty()) {
		cls= (Classes)resultList.get(0);
		}
		transaction.commit();
		session.close();
		return cls;
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
