package com.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entities.Address;
import com.demo.entities.Gender;
import com.demo.entities.Student;
import com.demo.repositories.StudentRepository;

@SpringBootApplication
public class FileManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileManagerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(StudentRepository repo,MongoTemplate mongoTemplate) {
		
		return args -> {
			Address address = new Address(
					"Morocco",
					"Casa",
					"NE9"
					);
			String email = "badr@badr.com";
			Student student = new Student(
					"Badr",
					"Akkar",
					email,
					Gender.MALE,
					address,
					List.of("Computer Science","Math", "PC"),
					BigDecimal.TEN,
					LocalDateTime.now());
			// usingMongoTemplateAndQuery(repo, mongoTemplate, student, email);
			
			repo.findStudentByEmail(email)
			.ifPresentOrElse(s -> {
				System.out.println(s + " already exist");
			}, () -> {
				System.out.println("Inserting student"+ student);
				repo.insert(student);	
			});
			
		
		};
	}
	
	public void usingMongoTemplateAndQuery(StudentRepository repo,MongoTemplate mongoTemplate,Student student,String email) {
		Query query = new Query();			
		query.addCriteria(Criteria.where("email").is(email));
		List<Student>  students = mongoTemplate.find(query, Student.class);
		if (students.size() > 1) {
			//throw new IllegalStateException("Found many students with this email");
		}
		if ( students.isEmpty() ) {
			System.out.println();
			repo.insert(student);				
		}else {
			System.out.println(student + " already exist");
		}
		
	}

}
