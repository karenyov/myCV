package com.project.myCv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.myCv.model.Template;
import com.project.myCv.repository.TemplateRepository;

/**
 * @author Karen 11 de mar de 2018
 */
@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateRepository templateRepository;

	/* (non-Javadoc)
	 * @see com.project.myCv.service.TemplateService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Template> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return templateRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.project.myCv.service.TemplateService#findOne(java.lang.Long)
	 */
	@Override
	public Template findOne(Long id) {
		// TODO Auto-generated method stub
		return templateRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.project.myCv.service.TemplateService#save(com.project.myCv.model.Template)
	 */
	@Override
	public Template save(Template template) {
		// TODO Auto-generated method stub
		template.setActive(true);
		return templateRepository.save(template);
	}

}
