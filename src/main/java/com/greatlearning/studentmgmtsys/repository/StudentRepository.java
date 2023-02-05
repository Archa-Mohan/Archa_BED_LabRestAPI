package com.greatlearning.studentmgmtsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.studentmgmtsys.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
