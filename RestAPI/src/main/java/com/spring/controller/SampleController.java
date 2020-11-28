package com.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.Ticket;
import com.spring.dto.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112,"스타", "로드");
	}
	
	//produces 생략 가능
	@GetMapping("/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList(){
		ArrayList<SampleVO> list = new ArrayList<SampleVO>();
		for(int i = 0; i < 10; i ++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName(i+"first");
			vo.setLastName(i+"last");
			vo.setMno(i);
			list.add(vo);
		}
		
		return list;
	}
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put( "First", new SampleVO(111, "groot", "junyer") );
		return map;
	}
	
	//ResponseBody를 사용하면 HttpStatus를 같이 전달해 줄 수 있다.
	@GetMapping(value="/check", params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath( @PathVariable("cat") String cat,@PathVariable("pid") Integer pid) {
		return new String[] {"category : " + cat, "Productid: " + pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert.............ticket" + ticket);
		return ticket;
	}
}
