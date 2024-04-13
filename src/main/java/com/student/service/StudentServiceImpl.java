package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.entity.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> findAll() {
		List<Student> students=studentRepo.findAll();
		return students;
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public Student findById(Integer theId) {
		Student found=studentRepo.findByStudentId(theId);
		return found;
	}

	@Override
	public void deleteStudent(Integer theId) {
		studentRepo.deleteById(theId);
		
	}

	@Override
	public Page<Student> findPaginated(int page, int size) {
        return studentRepo.findAll(PageRequest.of(page, size));
    }

}
