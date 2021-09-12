package com.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Student;
import com.demo.services.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v2/students")
@AllArgsConstructor
public class StudentController {
	
	
	private final StudentService studentService;
	
	@GetMapping("")
	public List<Student> fetchAllStudents(){
		return  studentService.getAllStudents();
		
	}
}
