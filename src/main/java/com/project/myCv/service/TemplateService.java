package com.project.myCv.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.myCv.model.Template;

/**
 * @author Karen
 * 11 de mar de 2018
 */
public interface TemplateService {
	 
	 public Page<Template> findAll(Pageable pageable);
	 
	 public Template findOne(Long id);
	 
	 public Template save(Template template);
}
