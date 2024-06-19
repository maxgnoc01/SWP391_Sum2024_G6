package com.quiz.main.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String className;

    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="courseId")
    private Course course;
    
   
}