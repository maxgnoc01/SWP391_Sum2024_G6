package com.quiz.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "semester")

public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String semesterName;
    
    @Column(nullable = false)
    private Date startDate;
    
    @Column(nullable = false)
    private Date endDate;
    
    @Column
    private String createdBy;
    
    @OneToMany(mappedBy = "semester")
    private List<Course> courseList;
    

    public Semester(){    	
    }
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}