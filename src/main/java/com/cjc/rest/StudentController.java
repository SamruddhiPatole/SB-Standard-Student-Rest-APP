package com.cjc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.model.Student;
import com.cjc.service.StudentService;

@RestController
@RequestMapping(value = "/api/v1")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping(value = "/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> list = studentService.getStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		Student stu = studentService.getStudents(id);
		if (stu != null) {
			return new ResponseEntity<Student>(stu, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
		boolean flag = studentService.deleteStudent(id);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,@RequestBody Student student)
	{
     Student stud=  studentService.updateStudent(id,student);
     if(stud!=null)
     {
    	 return new ResponseEntity<Student>(stud,HttpStatus.OK);
     }
     return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
	Student stu=studentService.addStudent(student);
	return new ResponseEntity<Student>(stu,HttpStatus.OK);
	}
}
