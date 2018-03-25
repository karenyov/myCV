package com.project.myCv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myCv.model.User;
import com.project.myCv.model.UserLanguage;
import com.project.myCv.repository.UserLanguageRepository;
import com.project.myCv.service.LanguageService;
import com.project.myCv.service.UserService;

/**
 * @author Karen 16 de mar de 2018
 */
@Controller
@RequestMapping("/language")
public class UserLanguageController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserLanguageRepository userLanguageRepository;
	
	@Autowired
	private LanguageService languageService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Meus Idiomas");
		modelAndView.addObject("myLanguages", userLanguageRepository.findByUserId(this.authUser().getId()));
		
		//info - modal cadastro
		modelAndView.addObject("languages", languageService.findByActive(true));
		modelAndView.addObject("userLanguage", new UserLanguage());

		modelAndView.setViewName("user_language/index");
		return modelAndView;
	}

	@PostMapping("/new")
	public ModelAndView newUserLanguage(UserLanguage userLanguage) {
		ModelAndView modelAndView = new ModelAndView();
		
		userLanguageRepository.save(userLanguage);

		return modelAndView;
	}

	private User authUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}

}
