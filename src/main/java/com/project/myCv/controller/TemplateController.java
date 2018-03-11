package com.project.myCv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.myCv.model.Template;
import com.project.myCv.service.TemplateService;

/**
 * @author Karen
 * 11 de mar de 2018
 */
@Controller
@RequestMapping("/admin/template")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@GetMapping("/")
	public ModelAndView index(Pageable pageable) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Templates");

		Page<Template> templatePage = templateService.findAll(pageable);
		PageWrapper<Template> page = new PageWrapper<Template>(templatePage, "/admin/template/");

		modelAndView.addObject("templates", page.getContent());
		modelAndView.addObject("page", page);
		modelAndView.setViewName("admin/template/index");
		return modelAndView;
	}
	
	@GetMapping("/enable/{id}")
	public @ResponseBody Template enable(@PathVariable Long id) {
		Template template = templateService.findOne(id);
		template.setActive(true);
		template = templateService.save(template);
		return template;
	}
	
	@GetMapping("/disable/{id}")
	public @ResponseBody Template disable(@PathVariable Long id) {
		Template template = templateService.findOne(id);
		template.setActive(false);
		template = templateService.save(template);
		return template;
	}
	
	@GetMapping("/new")
	public ModelAndView newTemplate() {
		ModelAndView modelAndView = new ModelAndView();
		Template template = new Template();
		modelAndView.addObject("title", "Template - Create");
		modelAndView.addObject("template", template);
		modelAndView.setViewName("admin/template/new");
		return modelAndView;
	}
	
	@PostMapping("/new")
	public ModelAndView newTemplate(Template template) {
		ModelAndView modelAndView = new ModelAndView();
		if (templateService.save(template) != null) {
			modelAndView.addObject("success", "Template cadastrado com sucesso!");
		} else {
			modelAndView.addObject("error", "Problemas ao alterar dados!");
		}
		modelAndView.addObject("title", "Template - Create");
		modelAndView.setViewName("admin/template/new");
		return modelAndView;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		Template template = templateService.findOne(id);
		modelAndView.addObject("title", "Template - Edit");
		modelAndView.addObject("template", template);
		modelAndView.setViewName("admin/template/edit");
		return modelAndView;
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(Template template) {
		ModelAndView modelAndView = new ModelAndView();
		if (templateService.save(template) != null) {
			modelAndView.addObject("success", "Template alterado com sucesso!");
		} else {
			modelAndView.addObject("error", "Problemas ao alterar dados!");
		}
		modelAndView.addObject("title", "Template - Edit");
		modelAndView.addObject("template", template);
		modelAndView.setViewName("admin/template/edit");
		return modelAndView;
	}
}
