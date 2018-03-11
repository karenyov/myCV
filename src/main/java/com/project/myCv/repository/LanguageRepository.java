package com.project.myCv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.myCv.model.Language;

/**
 * @author Karen 25 de fev de 2018
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {

	public Page<Language> findByDescriptionContaining(String search, Pageable pageable);

}
