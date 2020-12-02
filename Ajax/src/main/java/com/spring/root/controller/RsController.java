package com.spring.root.controller;

import java.security.Provider.Service;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RsController {
	@GetMapping(value="rest", produces="application/text; charset=utf-8")
	public String get() {
		return "get실행 : 데이터 요청";
	}
	@PostMapping(value="rest", produces="application/text; charset=utf-8")
	public String post() {
		return "post실행 : 데이터 추가";
	}
	@PutMapping(value="rest", produces="application/text; charset=utf-8")
	public String put() {
		return "put실행 : 데이터 수정";
	}
	@DeleteMapping(value="rest", produces="application/text; charset=utf-8")
	public String delete() {
		return "delete실행 : 데이터 삭제";
	}
	
	static int k = 1;
	@GetMapping(value="users/{cnt}", produces="application/json; charset=utf8")
	public String getUser(@PathVariable int cnt) throws JsonProcessingException {
		System.out.println(cnt);
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i = 0; i < (cnt*k); i++) {
			InfoDTO dto = new InfoDTO();
			dto.setName("홍길동 " + i);
			dto.setAge(i*10);
			list.add(dto);
		}
		k++;
		
		ObjectMapper mapper = new ObjectMapper();
		String strJson = mapper.writeValueAsString(list);
		return strJson;
	}
}