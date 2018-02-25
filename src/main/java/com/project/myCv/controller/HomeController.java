package com.project.myCv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Karen
 * 20 de fev de 2018
 */

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "My CV");    
		modelAndView.setViewName("index");
		return modelAndView;
	}

}
