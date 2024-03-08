package com.map.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
	private Long id;
	
	
	@Column
	  private String content;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="tutorial_id",nullable = false)
	private Tutorial tutorial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	public Comment() {
		
	}

	public Comment(Long id, String content, Tutorial tutorial) {
		super();
		this.id = id;
		this.content = content;
		this.tutorial = tutorial;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", tutorial=" + tutorial + "]";
	}
	
	
	

}
