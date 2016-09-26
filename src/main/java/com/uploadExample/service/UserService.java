package com.uploadExample.service;

import java.util.List;

import com.uploadExample.model.AppUser;

public interface UserService {
	public AppUser findById(int id);
	public void save(AppUser user);
	public List<AppUser> findAll();
	void deleteByUsername(String firstName);
	public AppUser updateHasProfileImage(int id, int value);
	public AppUser findByUsername(String username);
}
