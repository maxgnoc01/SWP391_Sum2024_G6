package com.quiz.main.controller;

import com.quiz.main.model.Course;
import com.quiz.main.model.Semester;
import com.quiz.main.model.User;
import com.quiz.main.repository.CourseRepository;
import com.quiz.main.repository.SemesterRepository;
import com.quiz.main.repository.UserRepository;
import com.quiz.main.service.CourseService;
import com.quiz.main.service.SemesterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/viewStudents")
    public String viewStudents(Model model) {
        List<User> students = userRepository.findByRole("ROLE_STUDENT");
        model.addAttribute("students", students);
        return "/manager/viewStudents";
    }

    @GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new User());
        return "/manager/addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@Valid @ModelAttribute User student) {
        student.setRole("ROLE_STUDENT");
        userRepository.save(student);
        return "redirect:/manager/viewStudents";
    }

    @GetMapping("/updateStudent/{id}")
    public String showUpdateStudentForm(@PathVariable Long id, Model model) {
        Optional<User> student = userRepository.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "/manager/updateStudent";
        } else {
            return "redirect:/manager/viewStudents";
        }
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute User student) {
        student.setId(id);
        student.setRole("ROLE_STUDENT");
        userRepository.save(student);
        return "redirect:/manager/viewStudents";
    }

    @PostMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/manager/viewStudents";
    }

    
   

    @GetMapping("/viewTeachers")
    public String viewTeachers(Model model) {
        List<User> teachers = userRepository.findByRole("ROLE_TEACHER");
        model.addAttribute("teachers", teachers);
        return "/manager/viewTeachers";
    }

    @GetMapping("/addTeacher")
    public String showAddTeacherForm(Model model) {
        model.addAttribute("teacher", new User());
        return "/manager/addTeacher";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@Valid @ModelAttribute User teacher) {
        teacher.setRole("ROLE_TEACHER");
        userRepository.save(teacher);
        return "redirect:/manager/viewTeachers";
    }

    @GetMapping("/updateTeacher/{id}")
    public String showUpdateTeacherForm(@PathVariable Long id, Model model) {
        Optional<User> teacher = userRepository.findById(id);
        if (teacher.isPresent()) {
            model.addAttribute("teacher", teacher.get());
            return "/manager/updateTeacher";
        } else {
            return "redirect:/manager/viewTeachers";
        }
    }

    @PostMapping("/updateTeacher/{id}")
    public String updateTeacher(@PathVariable Long id, @Valid @ModelAttribute User teacher) {
        teacher.setId(id);
        teacher.setRole("ROLE_TEACHER");
        userRepository.save(teacher);
        return "redirect:/manager/viewTeachers";
    }

    @PostMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/manager/viewTeachers";
    }

}
