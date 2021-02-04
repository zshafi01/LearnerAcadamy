package com.simplilearn.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String year;
	private String semester;
	
	@ManyToOne
    @JoinColumn(name="instractor_id")
	private Instructor instractor;
	
	@ManyToOne
    @JoinColumn(name="course_id")
	private Course course;
	
	 @ManyToMany()
	    @JoinTable(
	        name = "Classes_Student", 
	        joinColumns = { @JoinColumn(name = "classes_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "student_id") }
	    )
	private Set<Student> students=new HashSet<Student>();
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public Instructor getInstractor() {
		return instractor;
	}
	public void setInstractor(Instructor instractor) {
		this.instractor = instractor;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	

}
