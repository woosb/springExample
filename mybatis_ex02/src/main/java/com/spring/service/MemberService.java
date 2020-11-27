package com.spring.service;

import java.util.List;

import com.spring.dto.MemberDTO;

public interface MemberService {
	public void insertMember(MemberDTO dto);
	public List<MemberDTO> memberview();
}
