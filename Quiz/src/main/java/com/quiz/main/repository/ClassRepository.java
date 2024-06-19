package com.quiz.main.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.main.model.Classes;

@Repository
public interface ClassRepository extends JpaRepository<Classes, Long> {
    List<Classes> findByCourseId(Long courseId);
    void deleteByCourseId(Long courseId);
    
}