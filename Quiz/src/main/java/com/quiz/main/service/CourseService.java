package com.quiz.main.service;



import com.quiz.main.model.Course;
import com.quiz.main.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> getCoursesBySemesterId(Long semesterId) {
        return courseRepository.findBySemesterId(semesterId);
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public List<Course> findBySemesterId(Long semesterId) {
        return courseRepository.findBySemesterId(semesterId);
    }
   
}