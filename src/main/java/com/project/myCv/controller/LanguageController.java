package com.project.myCv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		Language language = languageService.findOne(id);
		modelAndView.addObject("title", "Language - Edit");
		modelAndView.addObject("language", language);
		modelAndView.setViewName("admin/language/edit");
		return modelAndView;
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(Language language) {
		ModelAndView modelAndView = new ModelAndView();
		if(languageService.save(language) != null) {
			modelAndView.addObject("success", "Language alterada com sucesso!");
		} else {
			modelAndView.addObject("error", "Problemas ao alterar dados!");
		}
		modelAndView.addObject("title", "Language - Edit");
		modelAndView.addObject("language", language);
		modelAndView.setViewName("admin/language/edit");
		return modelAndView;
	}

}
