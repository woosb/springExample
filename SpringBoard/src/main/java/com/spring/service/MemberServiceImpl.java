package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.Criteria;
import com.spring.dto.MemberDTO;
import com.spring.dto.MemberLogDTO;

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

	@Override
	public List<MemberLogDTO> getLog(Criteria cri) {
		return dao.getLog(cri);
	}

	@Override
	public Integer getLogCount() {
		return dao.getLogCount();
	}
}
