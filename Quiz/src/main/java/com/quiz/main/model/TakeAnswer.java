package com.quiz.main.model;

import java.util.Map;

import javax.persistence.Entity;

@Entity
public class TakeAnswer {
	
    private Long quizId;
    private Map<Long, String> answers; // Question ID -> Answer ('A', 'B', 'C')

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }
// Getters and setters
}
