package com.quiz.main.model;

import com.quiz.main.model.Quiz;
import com.quiz.main.model.User;

import java.util.Date;

import javax.persistence.*;

@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Quiz quiz;

    @Column
    private double score;
    
    @Column
    private Date startDate;
    
    @Column
    private Date endDate;

    public QuizResult() {

    }

    // Constructors, Getters, and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public QuizResult(Long id, User user, Quiz quiz, double score) {
        this.id = id;
        this.user = user;
        this.quiz = quiz;
        this.score = score;
    }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
