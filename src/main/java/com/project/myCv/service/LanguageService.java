package com.project.myCv.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.myCv.model.Language;

/**
 * @author Karen
 * 27 de fev de 2018
 */
public interface LanguageService {

	 public Page<Language> findAll(Pageable pageable);
	 
	 public Language findOne(Long id);
	 
	 public Language save(Language language);
	 
	 public Page<Language> findByDescriptionContaining(String search, Pageable pageable);
}
