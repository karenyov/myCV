package com.project.myCv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.myCv.model.Language;
import com.project.myCv.service.LanguageService;

/**
 * @author Karen 25 de fev de 2018
 */
@Controller
@RequestMapping("/admin/language")
public class LanguageController {
	
	private LanguageService languageService;
	
	 @Autowired
	    public void setAgenteService(LanguageService languageService) {
	        this.languageService = languageService;
	    }
	
	@GetMapping("/")
	public ModelAndView index(Pageable pageable) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Languages");
		
		Page<Language> languagePage = languageService.findAll(pageable);
		PageWrapper<Language> page = new PageWrapper<Language>(languagePage, "/admin/language/");
		
		modelAndView.addObject("languages", page.getContent());
		modelAndView.addObject("page", page);
		modelAndView.setViewName("admin/language/index");
		return modelAndView;
	}
	

}
