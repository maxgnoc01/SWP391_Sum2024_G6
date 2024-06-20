package com.quiz.main.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "course")
public class Course {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;
    
    @Column
    private String createdBy;
	
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "semester_id")
	private Semester semester;
    
    @OneToMany(mappedBy = "course")
    List<Classes> listClasses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public List<Classes> getListClasses() {
		return listClasses;
	}

	public void setListClasses(List<Classes> listClasses) {
		this.listClasses = listClasses;
	}
    
    
}
