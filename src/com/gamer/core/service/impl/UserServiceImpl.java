package com.gamer.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamer.core.dao.UserDao;
import com.gamer.core.po.User;
import com.gamer.core.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User findUserByAccount(String account) {
		// TODO Auto-generated method stub
		User user = this.userDao.findUser(account);
		
		return user;
	}

	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.saveUser(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> lUser = this.userDao.findAllUser();
		return lUser;
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		User user = this.userDao.findUserById(id);
		
		return user;
	}

	@Override
	public void changeUserName(User u, String name) {
		// TODO Auto-generated method stub
		userDao.changeName(u.getId(), name);
	}

	@Override
	public void changeSignature(User u, String signature) {
		// TODO Auto-generated method stub
		userDao.changeSignature(u.getId(), signature);
	}


}
