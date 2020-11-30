package com.spring.root.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUpLoadController {
	private final String IMAGE_REPO = "E:\\CARELAB\\image_repo";
	
	@RequestMapping("/form")
	public String form() {
		return "/uploadForm";
	}
	/*
	 * multipart/form-data는 파일 업로드가 있는 양식요소에 사용되는 enctype 속성의 값중 하나이고, 
	 * multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미합니다.
	 * */
	@RequestMapping("/upload")
	public ModelAndView upload(MultipartHttpServletRequest mul, HttpServletResponse response){
		try{
			mul.setCharacterEncoding("utf-8");
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		Enumeration enu = mul.getParameterNames();
		while(enu.hasMoreElements()){
			String name = (String)enu.nextElement();
			String value = mul.getParameter(name);
			System.out.println(name+" : " + value);
			map.put(name, value);
		}
		
		List fileList = fileProcess(mul);
		map.put("fileList",  fileList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.setViewName("result");
		return mv;
	}
	
	private List<String> fileProcess(MultipartHttpServletRequest mul){
		List<String> fileList = new ArrayList<String>();
		
		//html에서 넘어온 여러개의 파일(name)을 가져온다.
		Iterator<String> fileNames = mul.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();//name을 가져온다(file1, 2..)
			MultipartFile mFile = mul.getFile(fileName);
			String originFile = mFile.getOriginalFilename();//실제 파일명
			fileList.add(originFile);//실제 파일명을 리스트에 저장
			
			File file = new File(IMAGE_REPO+"\\"+fileName);
			file.getParentFile().mkdir();//해당 위치에 디렉터리 생성(없을경우)
			
			//사용자가 파일을 선택하지 않았을 경우 파일 크기가 0으로 처리 x
			//사용자가 파일을 업로드 했을 경우 크기가 0보다 크기 때문에 파일 저장
			if(mFile.getSize() != 0) {
				try{
					//괄호안의 경로로 파일 저장
					mFile.transferTo(new File(IMAGE_REPO+"\\"+originFile));
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return fileList;
	}
}