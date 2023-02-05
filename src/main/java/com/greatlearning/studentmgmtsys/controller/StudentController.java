package com.greatlearning.studentmgmtsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.studentmgmtsys.model.Student;
import com.greatlearning.studentmgmtsys.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudent(Model model) {
		List<Student> studentList = studentService.getAllStudents();
		model.addAttribute("Students", studentList);
		return "list_student";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student_form";
	}

	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveRecord(student);
		return "redirect:/student/list";
	}

	@RequestMapping("showFormForUpdate/{studentId}")
	public String updateStudent(Model model, @PathVariable("studentId") int id) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student", student);
		return "student_form";
	}

	@RequestMapping("delete/{studentId}")
	public String deleteStudent(Model model, @PathVariable("studentId") int id) {
		studentService.deleteStudentById(id);
		return "redirect:/student/list";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "access_denied";
	}
}
