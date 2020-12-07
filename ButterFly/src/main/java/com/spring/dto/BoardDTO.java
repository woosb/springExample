package com.spring.dto;

import lombok.Data;

@Data
public class BoardDTO {
	/*
	create table mvc_board(
		write_no number(10) primary key,
		title varchar2(100),
		content varchar2(300),
		savedate date default sysdate,
		hit number(10) default 0,
		image_file_name varchar(100),
		id varchar(20)
	);
	*/
	private int write_no;
	private String title;
	private String content;
	
}
