package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO dao;
	
	@Override
	public int register(MemberDTO dto) {
		return dao.register(dto);
	}

	@Override
	public int login(MemberDTO dto, HttpServletRequest request) {
		MemberDTO user = dao.getMember(dto);
		if(user != null	) {
			if(user.getPw().equals(dto.getPw())) {
				HttpSession session = request.getSession();
				session.setAttribute("id", dto.getId());
				return 1;
			}else {
				return 0;
			}
		}
		return -1;
	}
	
	@Override
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.getMemberList();
		return list;
	}

	@Override
	public MemberDTO getMember(MemberDTO dto) {
		return dao.getMember(dto);
	}
	
}
