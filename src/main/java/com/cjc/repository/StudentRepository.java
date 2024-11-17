package com.cjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	

}
