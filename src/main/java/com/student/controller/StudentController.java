package com.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Student;
import com.student.service.StudentService;
@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String findAllStudents(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            Model model)
	{
//		List<Student> students=new ArrayList<>();
//		students=studentService.findAll();
//		theModel.addAttribute("students", students);
//		return "students/list-students";
		Page<Student> studentPage = studentService.findPaginated(page, size);
        model.addAttribute("studentPage", studentPage);
        return "students/list-students";
	}
	
	@GetMapping("/showFormToAdd")
	public String addNewStudent(Model theModel)
	{
		Student toAddStudent=new Student();
		theModel.addAttribute("student", toAddStudent);
		return "students/student-form";
	}
	
	@PostMapping("/save")
	public String saveNewStudent(@ModelAttribute("student")@Valid Student toAdd,BindingResult result,Model theModel)
	{
		if(result.hasErrors())
		{
			return "students/student-form";
		}
		else
		{
			studentService.save(toAdd);
			return "redirect:/students/list";
		}
		
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId")Integer studentId,Model theModel)
	{
		Student foundStudent=studentService.findById(studentId);
		theModel.addAttribute("student", foundStudent);
		return "students/student-form";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId")Integer studentId)
	{
		studentService.deleteStudent(studentId);
		return "redirect:/students/list";
	}
}
