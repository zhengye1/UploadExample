package com.uploadExample.dao;

import java.util.List;

import com.uploadExample.model.AppUser;

public interface UserDAO {
	public AppUser findById(int id);
	public void save(AppUser user);
	public List<AppUser> findAll();
	void deleteByUsername(String username);
	public AppUser findByUsername(String username);
	
}
