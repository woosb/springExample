package com.spring.dao;

import com.spring.dto.MemberDto;

public interface MemberDao {
	public int register(MemberDto dto);
	public MemberDto login(MemberDto dto);
	public void delete(MemberDto dto);
}
