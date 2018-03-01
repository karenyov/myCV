package com.project.myCv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.myCv.model.Language;
import com.project.myCv.repository.LanguageRepository;

/**
 * @author Karen 27 de fev de 2018
 */
@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.project.myCv.service.LanguageService#findAll(org.springframework.data
	 * .domain.Pageable)
	 */
	@Override
	public Page<Language> findAll(Pageable pageable) {
		
		Page<Language> languages = languageRepository.findAll(pageable);
		return languages;
	}

}
