package com.project.myCv.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.project.myCv.model.User;
import com.project.myCv.service.UserService;

/**
 * @author Karen 28 de mar de 2018
 */
public class MyController {

	@Autowired
	private UserService userService;
	
	
	protected User authUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}

}
