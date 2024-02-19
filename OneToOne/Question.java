package com.OneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@Column(name = "question_id")
	private int question_id;
	@Column(name = "questions")
	private String questions;
	@OneToOne
	@JoinColumn(name = "ans_id")
	private Answer answer;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(int question_id, String questions, Answer answer) {
		super();
		this.question_id = question_id;
		this.questions = questions;
		this.answer = answer;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}


}
