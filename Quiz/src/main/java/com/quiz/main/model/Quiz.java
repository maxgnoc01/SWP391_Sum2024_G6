package com.quiz.main.model;

import com.quiz.main.model.Question;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();
    @NotNull(message = "Duration is required.")
    @Min(value = 1, message = "Duration must be at least 1 minute.")
    private Integer duration;
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuizResult> quizResults = new HashSet<>();
    
    @Column
    private double score;
    
    @Column
    private String title;
    
    @Column
    private Date startDate;

    @Column
    private Date endDate;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

	public Set<QuizResult> getQuizResults() {
		return quizResults;
	}

	public void setQuizResults(Set<QuizResult> quizResults) {
		this.quizResults = quizResults;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
    
    

}
