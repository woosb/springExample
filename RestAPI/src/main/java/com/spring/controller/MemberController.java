package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.MemberDto;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping(value="/ajax/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@PostMapping("/register")
	public ResponseEntity<Integer> register(MemberDto dto) {
		int result = service.register(dto);
		log.info("result : " + result);
		log.info("convert.............dto" + dto);
		return result == 1
		? ResponseEntity.status(HttpStatus.OK).body(result) 
		: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> login(MemberDto dto){
		log.info("convert..............dto " + dto);
		int result = service.login(dto);
		log.info("result : " + result);
		return result == 1
		? ResponseEntity.status(HttpStatus.OK).body(result)
		: ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
