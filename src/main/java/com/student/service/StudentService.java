package com.student.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.student.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	public void save(Student student);
	
	public Student findById(Integer theId);
	
	public void deleteStudent(Integer theId);

	public Page<Student> findPaginated(int page, int size);
	
	public List<Student> findByFirstName(String firstName);
}
