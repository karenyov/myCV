package com.project.myCv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myCv.common.MyController;
import com.project.myCv.model.UserLanguage;
import com.project.myCv.repository.UserLanguageRepository;
import com.project.myCv.service.LanguageService;

/**
 * @author Karen 16 de mar de 2018
 */
@Controller
@RequestMapping("/language")
public class UserLanguageController extends MyController {

	@Autowired
	private UserLanguageRepository userLanguageRepository;

	@Autowired
	private LanguageService languageService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Meus Idiomas");
		modelAndView.addObject("myLanguages", userLanguageRepository.findByUserId(this.authUser().getId()));
		modelAndView.setViewName("user_language/index");
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView newUserLanguage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Meus Idiomas - Cadastro");
		modelAndView.addObject("languages", languageService.findByActive(true));
		modelAndView.addObject("userLanguage", new UserLanguage());
		modelAndView.setViewName("user_language/new");
		return modelAndView;
	}

	@PostMapping("/new")
	public ModelAndView newUserLanguage(UserLanguage userLanguage) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Meus Idiomas - Cadastro");

		userLanguage.setUser(this.authUser());
		if (userLanguageRepository.save(userLanguage) != null) {
			modelAndView.addObject("success", "Template cadastrado com sucesso!");
		} else {
			modelAndView.addObject("error", "Problemas ao alterar dados!");
		}
		modelAndView.setViewName("user_language/new");
		return modelAndView;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Meus Idiomas - Editar");
		UserLanguage userLanguage = userLanguageRepository.findOne(id);
		modelAndView.addObject("languages", languageService.findByActive(true));
		modelAndView.addObject("userLanguage", userLanguage);
		modelAndView.setViewName("user_language/edit");
		return modelAndView;
	}

}
