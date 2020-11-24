package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.dto.MemberDTO;

public interface MemberService {
	public int register(MemberDTO dto);
	public int login(MemberDTO dto, HttpServletRequest request);
	public List<MemberDTO> getMemberList();
	public MemberDTO getMember(MemberDTO dto);
}
