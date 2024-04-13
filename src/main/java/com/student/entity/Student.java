package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="first_name")
	@NotNull(message="First Name of a student cannot be empty")
	@NotEmpty(message="First Name of a student cannot be empty")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull(message="Last Name of a student cannot be empty")
	@NotEmpty(message="Last Name of a student cannot be empty")
	private String lastName;
	
	@Column(name="email")
	@NotNull(message="Email of a student cannot be empty")
	@NotEmpty(message="Email of a student cannot be empty")
	@Email(message="Give the appropriate email id.")
	private String email;
	
	@Column(name="city")
	@NotNull(message="City of a student cannot be empty")
	@NotEmpty(message="City of a student cannot be empty")
	private String city;
	
	@Column(name="state")
	@NotNull(message="State of a student cannot be empty")
	@NotEmpty(message="State of a student cannot be empty")
	private String state;
	
	@Column(name="course")
	@NotNull(message="Course of a student cannot be empty")
	@NotEmpty(message="Course of a student cannot be empty")
	private String course;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Student(Integer id, String firstName, String lastName, String email, String city, String state,
			String course) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.course = course;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastName, String email, String city, String state, String course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.course = course;
	}
	
	
	
	
}
