package com.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String descrition;
	@ManyToMany //(mappedBy = "course")// mappedBy trỏ tới tên biến course ở trong Course.
	@JoinTable(name= "student_course", // Tạo ra một join table tên là"student_course"
		joinColumns = @JoinColumn(name= "student_id"), // Trong đó, khóa ngoại chính là student_id trỏ tới class hiện tại (Student)
		inverseJoinColumns =@JoinColumn(name= "course_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Course)
	)
	@JsonIgnore
	private List<Student> student;
		
	public Course() {
		super();
	}

	public Course(Long id, String code, String name, String descrition) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.descrition = descrition;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}