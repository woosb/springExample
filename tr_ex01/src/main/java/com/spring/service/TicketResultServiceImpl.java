package com.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.spring.dao.TicketDAO;
import com.spring.dto.TicketDTO;

import jdk.internal.org.jline.utils.Log;

public class TicketResultServiceImpl implements TicketService{

	private TicketDAO dao;
	
	public TicketResultServiceImpl() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		dao = ctx.getBean("dao", TicketDAO.class);
	}
	
	@Override
	public void execute(Model model) {
		model.addAttribute("result", dao.resultTicket());
	}
}
