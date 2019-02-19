package com.gamer.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gamer.core.po.User;

public interface UserDao {
	public User findUser(@Param("account") String account);
	public User findUserById(@Param("id") Integer id);
	public List<User> findAllUser();
	public void truncateTableUser();
	public int saveUser(User user);
	
	public void changeName(@Param("id") Integer id,@Param("name") String name);
	public void changeSignature(@Param("id") Integer id,@Param("signature") String signature);
}
