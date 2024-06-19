package com.quiz.main.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quiz.main.model.Classes;
import com.quiz.main.model.Course;
import com.quiz.main.model.Semester;
import com.quiz.main.repository.ClassRepository;
import com.quiz.main.repository.CourseRepository;
import com.quiz.main.repository.SemesterRepository;


@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassRepository classRepository;

    public List<Semester> findAll() {
        return semesterRepository.findAll();
    }

    public List <Semester> findByName(String semesterName) {
        return semesterRepository.findBySemesterName(semesterName);
    }
    public Optional<Semester> findById(Long semesterId) {
    	return semesterRepository.findById(semesterId);
    }

    public Semester save(Semester semester) {
        return semesterRepository.save(semester);
    }

    public void deleteById(Long id) {
        semesterRepository.deleteById(id);
    }
    @Transactional
    public void deleteSemesterById(Long semesterId) {
        // Lấy danh sách các khóa học liên quan đến học kỳ
        List<Course> courses = courseRepository.findBySemesterId(semesterId);
        
        for (Course course : courses) {
            // Xóa tất cả các lớp học liên quan đến khóa học
        	List<Classes> classes = classRepository.findByCourseId(course.getId());
        	for (Classes clazz : classes) {
                // Xóa từng lớp học một
                classRepository.delete(clazz);
            }
        	courseRepository.delete(course);
        }

        // Cuối cùng, xóa học kỳ
        semesterRepository.deleteById(semesterId);
    }

    @Transactional
    public void saveSemester(Semester semester) {
        semesterRepository.save(semester);
    }
    public List<Semester> findSemesterBySemesterName(String semesterName) {
        return semesterRepository.findBySemesterName(semesterName);
    }

    public Semester findFirstSemesterBySemesterName(String semesterName) {
        return semesterRepository.findFirstBySemesterName(semesterName);
    }
}