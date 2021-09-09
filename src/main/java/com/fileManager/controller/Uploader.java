package com.fileManager.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Uploader {
	
	@GetMapping("/files")
	public  ResponseEntity<List<String>> getFolder(){
		List<String> files = Arrays.asList("data.csv","demo.csv");
		return ResponseEntity.ok().body(files);
	}
}
