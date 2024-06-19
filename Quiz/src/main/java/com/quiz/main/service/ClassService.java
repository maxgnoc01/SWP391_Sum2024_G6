package com.quiz.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.main.repository.ClassRepository;

@Service
public class ClassService {
	@Autowired
    private ClassRepository classRepository;

    // Xóa các classes liên quan đến một course
    public void deleteClassesByCourseId(Long courseId) {
        classRepository.deleteByCourseId(courseId);
    }
}
