package com.quiz.main.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
@Getter
@Setter
@Table(name = "semester")

public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String semesterName;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(nullable = false, name = "start_date")
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(nullable = false, name = "end_date")    
    private Date endDate;
    
    @OneToMany(mappedBy = "semester", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> persons;
    public Semester(){    	
    }
    
    
    
}