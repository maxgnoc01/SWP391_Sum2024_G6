package com.quiz.main.controller;



import com.quiz.main.model.Semester;
import com.quiz.main.repository.SemesterRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private SemesterRepository semesterRepository;

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
}
