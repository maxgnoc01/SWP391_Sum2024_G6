package com.quiz.main.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	private Long bankId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@OneToMany(mappedBy = "questions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<QuestionChoice> listChoice = new HashSet<QuestionChoice>();
	
	@Column
	private QuestionType type;
	
	@Column
	private String content;

	// Standard getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<QuestionChoice> getListChoice() {
		return listChoice;
	}

	public void setListChoice(Set<QuestionChoice> listChoice) {
		this.listChoice = listChoice;
	}
}
