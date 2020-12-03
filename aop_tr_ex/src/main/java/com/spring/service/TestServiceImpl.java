package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;

import com.spring.dao.TestDAO;

@Service
public class TestServiceImpl {
	@Autowired TestDAO dao;
	
	@Transactional
	public void buy(Model model, int num) {
		int[] result = {0, 0};
		try {
			result[0] = dao.userInsert(num);
			result[1] = dao.systemInsert(num);
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
		model.addAttribute("result", result);
	}
	
	public void db_result(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", dao.user_db_result());
		map.put("system", dao.sys_db_result());
		model.addAttribute("db_result", map);
	}
}
