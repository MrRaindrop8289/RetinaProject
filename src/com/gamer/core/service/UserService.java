package com.gamer.core.service;

import java.util.List;

import com.gamer.core.po.User;

public interface UserService {
	public User findUserByAccount(String account);
	public User findUserById(Integer id);
	public int saveUser(User user);
	public List<User> findAllUser();
	public void changeUserName(User u,String name);
	public void changeSignature(User u,String signature);
	
}
