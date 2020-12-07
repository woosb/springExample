package com.spring.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface MailService {
	public void authCheck(String id, String email, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException ;
}
