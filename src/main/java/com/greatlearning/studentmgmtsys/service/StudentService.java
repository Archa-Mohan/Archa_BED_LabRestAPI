package com.greatlearning.studentmgmtsys.service;

import java.util.List;

import com.greatlearning.studentmgmtsys.model.Student;

public interface StudentService {

	public void saveRecord(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(int id);

	public void deleteStudentById(int id);
}
