package com.pixelware.dao;

import java.util.List;

import com.pixelware.model.User;

public interface UserDao {

	List<User>getAll();
	User getByName(String name);
	User getByCode(int code);
	
	
}
