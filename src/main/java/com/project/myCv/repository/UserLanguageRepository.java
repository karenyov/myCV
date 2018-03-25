package com.project.myCv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.myCv.model.UserLanguage;

/**
 * @author Karen 16 de mar de 2018
 */
public interface UserLanguageRepository extends JpaRepository<UserLanguage, Long> {

	List<UserLanguage> findByUserId(Long id);
}
