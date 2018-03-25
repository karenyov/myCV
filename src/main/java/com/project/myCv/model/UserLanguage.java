package com.project.myCv.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.myCv.common.Level;

/**
 * @author Karen 16 de mar de 2018
 */
@Entity
public class UserLanguage implements Serializable {

	private static final long serialVersionUID = -5431395260889710715L;
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	@Enumerated(EnumType.STRING)
	private Level writing;

	@Enumerated(EnumType.STRING)
	private Level reading;

	@Enumerated(EnumType.STRING)
	private Level conversation;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the writing
	 */
	public Level getWriting() {
		return writing;
	}

	/**
	 * @param writing
	 *            the writing to set
	 */
	public void setWriting(Level writing) {
		this.writing = writing;
	}

	/**
	 * @return the reading
	 */
	public Level getReading() {
		return reading;
	}

	/**
	 * @param reading
	 *            the reading to set
	 */
	public void setReading(Level reading) {
		this.reading = reading;
	}

	/**
	 * @return the conversation
	 */
	public Level getConversation() {
		return conversation;
	}

	/**
	 * @param conversation
	 *            the conversation to set
	 */
	public void setConversation(Level conversation) {
		this.conversation = conversation;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

}
