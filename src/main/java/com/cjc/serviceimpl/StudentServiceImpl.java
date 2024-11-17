package com.cjc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cjc.model.Student;
import com.cjc.repository.StudentRepository;
import com.cjc.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudents(int id) {
		if (studentRepository.existsById(id)) {
			return studentRepository.findById(id).get();
		}
		return null;
	}
	
	@Override
	public boolean deleteStudent(int id) { 
		if(studentRepository.existsById(id))
		{
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public Student updateStudent(int id, Student student) {
		if(studentRepository.existsById(id))
		{
			student.setRollNo(id);
			return studentRepository.save(student);
		}
		return null;
	}
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
}
