package com.example.spring.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.dao.LoginDAO;
import com.example.spring.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginDAO logindao;

	public void setLoginDAO(LoginDAO logindao) {
		this.logindao = logindao;
	}

	@Override
	@Transactional
	public boolean validateuser(String username, String password) {
		// TODO Auto-generated method stub
		boolean flag = this.logindao.validateuser(username, password);
		return flag;
	}
}
