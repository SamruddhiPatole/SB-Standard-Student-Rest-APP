package com.cjc.service;

import java.util.List;

import com.cjc.model.Student;

public interface StudentService {

	List<Student> getStudents();

	Student getStudents(int id);

	boolean deleteStudent(int id);

	Student updateStudent(int id, Student student);

	Student addStudent(Student student);


}
