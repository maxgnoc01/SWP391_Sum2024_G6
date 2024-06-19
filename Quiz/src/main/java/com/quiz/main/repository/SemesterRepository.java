package com.quiz.main.repository;

import com.quiz.main.model.Semester;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    List<Semester> findBySemesterName(String semesterName);
//    Semester findBySemesterId(Long semesterId);

    Semester findFirstBySemesterName(String semesterName);
}