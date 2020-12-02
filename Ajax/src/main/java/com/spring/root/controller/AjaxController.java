package com.spring.root.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AjaxController {
	@RequestMapping("non_ajax")
	public String non_ajax() {
		System.out.println("=== non ajax 실행 ===");
		return "non_ajax";
	}
	
	@RequestMapping("ajax")
	public String ajax() {
		System.out.println("---- ajax 실행 ----");
		return "ajax";
	}
	
	static int count = 0;
	@RequestMapping(value="ajax_result", produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajax_result(InfoDTO dto) {
		System.out.println("---- ajax_result 실행 ----");
		return dto.getName() + " " + dto.getAge();
	}
	
	@RequestMapping("count")
	public String count(HttpSession s) {
		s.setAttribute("count",  ++count + "");
		return "redirect:ajax";
	}
	
	@RequestMapping(value="ajax_json", produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> ajax_json() throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "abb");
		map.put("pw", "1234");
//		ObjectMapper mapper = new ObjectMapper();
//		String strJson = mapper.writeValueAsString(map); // return strJson
		return map;
	}
	
	@GetMapping("/rest01")
	public void rest01() {
		
	}
	
	@RequestMapping("/getUser")
	public void getUser() {
		
	}
}
