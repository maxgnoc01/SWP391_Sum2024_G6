package com.quiz.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
    private String className;
	
	@Column
	private String createdBy;
	
	@Column(nullable = false)
	private Long teacherId;
	
	@ManyToMany
	@JoinTable(
			name = "user_class",
			joinColumns = @JoinColumn(name="class_id"),
			inverseJoinColumns = @JoinColumn (name="user_id"))
	private List<User> studentList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public List<User> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<User> studentList) {
		this.studentList = studentList;
	}
	
	
}
