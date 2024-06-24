package com.quiz.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.main.model.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findBySemesterId(Long semesterId);
    List<Course> findByCourseName(String courseName);
    void deleteBySemesterId(Long semesterId);

}