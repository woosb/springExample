package com.spring.service;

import java.util.List;

import javax.swing.event.TableColumnModelListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	
	@Override
	public int login(MemberDTO dto) {
		MemberDTO user = dao.login(dto);
		if(user != null) {
			if( user.getPw().equals(dto.getPw()) )
				return 1;
			else
				return 0;
		}
		return -1;
	}
	
	@Override
	public int join(MemberDTO dto) {
		int reuslt = dao.join(dto);
		return reuslt;
	}

	@Override
	public List<MemberDTO> memberInfo() {
		return dao.memberInfo();
	}

	@Override
	public void memberList(Model model) {
		model.addAttribute("list", dao.getLog());
	}
	
}
