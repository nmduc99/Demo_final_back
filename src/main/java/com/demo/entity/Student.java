package com.demo.entity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;



@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String codeStudent;
	private String address;
	private String email;
	@ManyToMany	
	@JoinTable(name= "student_course", // Tạo ra một join table tên là"student_course"
			joinColumns = @JoinColumn(name= "student_id"), // Trong đó, khóa ngoại chính là student_id trỏ tới class hiện tại (Student)
			inverseJoinColumns =@JoinColumn(name= "course_id") //Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới (Course)
			)
	
	private List<Course> course;
	
	public Student() {
		super();
	}
	public Student(long id,String name, String codeStudent, String addresss, String email) {
		this.id= id;
		this.name= name;
		this.codeStudent= codeStudent;
		this.email= email;
		}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeStudent() {
		return codeStudent;
	}
	public void setCodeStudent(String codeStudent) {
		this.codeStudent = codeStudent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
}