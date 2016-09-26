package com.uploadExample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uploadExample.dao.UserDAO;
import com.uploadExample.model.AppUser;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public AppUser findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public void save(AppUser user) {
		// TODO Auto-generated method stub
		userDAO.save(user);
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public void deleteByUsername(String username) {
		// TODO Auto-generated method stub
		userDAO.deleteByUsername(username);
	}

	@Override
	public AppUser updateHasProfileImage(int id, int value) {
		// TODO Auto-generated method stub
		AppUser user = userDAO.findById(id);
		user.setHasProfileImage(value);
		return user;
	}

	@Override
	public AppUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.findByUsername(username);
	}

}
