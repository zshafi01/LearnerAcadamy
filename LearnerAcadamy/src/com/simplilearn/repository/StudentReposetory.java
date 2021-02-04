package com.simplilearn.repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import com.simplilearn.model.Instructor;
import com.simplilearn.model.Student;

public class StudentReposetory  {
	Session getSession(){
		Configuration cnfg= new Configuration();
    	cnfg.configure("hibernate.cfg.xml");
    	Session session = cnfg.buildSessionFactory().openSession();
    	return session;
	}

	
	public boolean insert(Student student) {
		try {
			Session session=getSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			session.close();
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
			
		
	}

	
	public void update(Student a) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int a) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> getAll(){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Student> studentList = session.createQuery("FROM Student").list();

		transaction.commit();
		session.close();
		return studentList;
	}

	public static void main(String[] args) {
		StudentReposetory reposetory=new StudentReposetory();
				
		List<Student>students=reposetory.getAll();
		for(Student s:students) {System.out.println("Name:"+s.getFname());}
	}
	
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Student getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
