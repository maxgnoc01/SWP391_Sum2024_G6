package com.quiz.main.controller;

import com.quiz.main.model.User;
import com.quiz.main.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
	 @Autowired
	    private UserRepository userRepository;

	    @GetMapping("/home")
	    public String adminHome() {
	        return "adminHome";
	    }

	    @GetMapping("/manaacc")
	    public String manageManagers(Model model) {
	        List<User> managers = userRepository.findByRole("ROLE_MANAGER");
	        model.addAttribute("managers", managers);
	        return "/admin/manageManagers";
	    }

	    @GetMapping("/addManager")
	    public String showAddManagerForm(Model model) {
	        model.addAttribute("manager", new User());
	        return "/admin/addManager";
	    }

	    @PostMapping("/addManager")
	    public String addManager(@Valid @ModelAttribute User manager) {
	        manager.setRole("ROLE_MANAGER");
	        userRepository.save(manager);
	        return "redirect:/admin/manaacc";
	    }

	    @GetMapping("/updateManager/{id}")
	    public String showUpdateManagerForm(@PathVariable Long id, Model model) {
	        Optional<User> manager = userRepository.findById(id);
	        if (manager.isPresent()) {
	            model.addAttribute("manager", manager.get());
	            return "/admin/updateManager";
	        } else {
	            return "redirect:/admin/manaacc";
	        }
	    }

	    @PostMapping("/updateManager/{id}")
	    public String updateManager(@PathVariable Long id, @Valid @ModelAttribute User manager) {
	        manager.setId(id);
	        manager.setRole("ROLE_MANAGER");
	        userRepository.save(manager);
	        return "redirect:/admin/manaacc";
	    }

	    @PostMapping("/deleteManager/{id}")
	    public String deleteManager(@PathVariable Long id) {
	        userRepository.deleteById(id);
	        return "redirect:/admin/manaacc";
	    }

}