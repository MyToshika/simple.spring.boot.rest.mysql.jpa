package com.mytoshika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytoshika.entity.TestDto;
import com.mytoshika.service.XLSXFileHandler;


@RestController
public class TestController {

	@Autowired
	private XLSXFileHandler xLSXFileHandler;
	
	@GetMapping("/test")
	public ResponseEntity<?> readExcel(){
		
		return new ResponseEntity<List<TestDto>>(xLSXFileHandler.readFile(), HttpStatus.OK);
		
	}
}
