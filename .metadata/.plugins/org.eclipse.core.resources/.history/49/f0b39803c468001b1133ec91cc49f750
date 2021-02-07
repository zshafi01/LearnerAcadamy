package com.simplilearn.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
import com.simplilearn.model.Student;

public class StudentReposetory {
	Session getSession() {
		Configuration cnfg = new Configuration();
		cnfg.configure("hibernate.cfg.xml");
		Session session = cnfg.buildSessionFactory().openSession();
		return session;
	}

	public boolean insert(Student student) {
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean update(Student student) {
		boolean result = true;
		Transaction transaction = null;
		Session session = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			result = false;
		} finally {
			session.close();
		}
		return result;

	}

	public void delete(int a) {
		// TODO Auto-generated method stub

	}

	public List<Student> getAll() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Student> studentList = session.createQuery("FROM Student").list();

		transaction.commit();
		session.close();
		return studentList;
	}

	public Student getById(int id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("FROM Student where id=:id");
		query.setParameter("id", id);
		List resultList = query.getResultList();
		Student st = null;
		if (resultList != null && !resultList.isEmpty()) {
			st = (Student) resultList.get(0);
		}
		transaction.commit();
		session.close();
		return st;
	}

//	public static void main(String[] args) {
//		StudentReposetory reposetory = new StudentReposetory();
//
//		List<Student> students = reposetory.getAll();
//		for (Student s : students) {
//			System.out.println("Name:" + s.getFname());
//		}
//	}
//
//	public Student getByName(String name) {
//		return null;
//	}

}
