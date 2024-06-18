package com.quiz.main.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;



@Entity
@Table(name = "semester")

public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String semesterName;

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
}