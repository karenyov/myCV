package com.project.myCv.service;

import com.project.myCv.model.User;

/**
 * @author Karen 21 de fev de 2018
 */
public interface UserService {
	public User findUserByEmail(String email);

	public void saveUser(User user);
}
