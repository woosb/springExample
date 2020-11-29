package com.spring.service;

import com.spring.dto.MemberDto;

public interface MemberService {
	public int register(MemberDto dto);
	public int login(MemberDto dto);
}
