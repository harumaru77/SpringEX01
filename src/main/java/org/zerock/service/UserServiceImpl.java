package org.zerock.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.UserVO;
import org.zerock.dto.LoginDTO;
import org.zerock.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDAO;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return userDAO.login(dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) throws Exception {
		userDAO.keepLogin(uid, sessionId, next);		
	}

	@Override
	public UserVO checkLoginBefore(String value) {
		return userDAO.checkUserWithSessionKey(value);
	}

}
