package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;
	
	@Override
	public void insertMember(MemberDTO dto) {
		dao.insertMember(dto);
	}

	@Override
	public List<MemberDTO> memberview() {
		return dao.memberview();
	}
}
