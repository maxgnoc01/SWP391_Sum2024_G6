package com.quiz.main.controller;

import com.quiz.main.model.Course;
import com.quiz.main.model.Semester;
import com.quiz.main.repository.CourseRepository;
import com.quiz.main.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/home")
    public String managerHome(Model model) {
        model.addAttribute("semesters", semesterRepository.findAll());
        return "managerHome";
    }

    @GetMapping("/createSemester")
    public String showCreateSemesterForm(Model model) {
        model.addAttribute("semester", new Semester());
        return "createSemester";
    }

    @PostMapping("/createSemester")
    public String createSemester(@ModelAttribute Semester semester) {
        semesterRepository.save(semester);
        return "redirect:/manager/home";
    }

    @PostMapping("/deleteSemester/{id}")
    public String deleteSemester(@PathVariable Long id) {
        semesterRepository.deleteById(id);
        return "redirect:/manager/home";
    }
    @GetMapping("/viewCourses")
    public ResponseEntity<List<Course>> viewCourses(@RequestParam String semesterName) {
        List<Course> courses = courseRepository.findBySemesterName(semesterName);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/createCourse")
    public String showCreateCourseForm(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("semesters", semesterRepository.findAll());
        return "createCourse";
    }

    @PostMapping("/createCourse")
    public String createCourse(@ModelAttribute Course course, Model model) {
        courseRepository.save(course);
        return "redirect:/manager/home";
    }
}