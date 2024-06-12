package com.quiz.main.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.main.model.Semester;
import com.quiz.main.repository.SemesterRepository;


@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    public Semester findByName(String semesterName) {
        return semesterRepository.findBySemesterName(semesterName);
    }

    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }

    public void deleteById(Long id) {
        semesterRepository.deleteById(id);
    }
}