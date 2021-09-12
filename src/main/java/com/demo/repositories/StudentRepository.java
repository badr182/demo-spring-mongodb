package com.demo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.entities.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
	
	
	Optional<Student> findStudentByEmail(String email);

}
