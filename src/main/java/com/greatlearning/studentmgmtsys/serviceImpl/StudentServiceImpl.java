package com.greatlearning.studentmgmtsys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentmgmtsys.model.Student;
import com.greatlearning.studentmgmtsys.repository.StudentRepository;
import com.greatlearning.studentmgmtsys.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepo;

	@Override
	public void saveRecord(Student student) {
		studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepo.deleteById(id);
	}

}
