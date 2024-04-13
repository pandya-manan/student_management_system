package com.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	@Query(value = "SELECT s FROM Student s WHERE s.id = :id")
    Student findByStudentId(@Param("id") Integer id);
	
	@Query(value="SELECT s FROM Student s WHERE s.firstName = :firstName")
	List<Student> findByFirstName(@Param("firstName")String firstName);
}
