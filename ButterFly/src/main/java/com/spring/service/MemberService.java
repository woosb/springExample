package com.spring.service;

import java.util.List;

import org.springframework.ui.Model;

import com.spring.dto.MemberDTO;

public interface MemberService {
	public int login(MemberDTO dto);
	public int join(MemberDTO dto);
	public List<MemberDTO> memberInfo();
	public void memberList(Model model);
	public int modifyPw(MemberDTO dto);
}
