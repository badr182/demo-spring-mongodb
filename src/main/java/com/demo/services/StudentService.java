package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	
	private final StudentRepository studentRepository; 
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
