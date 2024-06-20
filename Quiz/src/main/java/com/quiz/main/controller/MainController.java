package com.quiz.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.quiz.main.model.Quiz;
import com.quiz.main.model.User;
import com.quiz.main.model.component.GooglePojo;
import com.quiz.main.model.component.GoogleUtils;
import com.quiz.main.repository.UserRepository;
import com.quiz.main.service.QuizService;


import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;



@Controller
public class MainController {
	

	@Autowired
    QuizService qService;
	
	@Autowired
	private QuizService quizService;
	Boolean submitted = false;
	

	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}



	@GetMapping("/user/home")
	public ModelAndView userHome(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null && "ROLE_USER".equals(currentUser.getRole())) {
			List<Quiz> quizzes = quizService.getAllQuizzes(); // Assuming you have this method in your QuizService
			modelAndView.addObject("quizzes", quizzes);
			modelAndView.setViewName("userHome");
		} else if (!"ROLE_USER".equals(currentUser.getRole())) {
			modelAndView.setViewName("redirect:/403");
 		} else {
			modelAndView.setViewName("redirect:/login"); // Redirect to login if not user
		}
		return modelAndView;
	}


	@GetMapping("/admin/home")
	public ModelAndView adminHome(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null && "ROLE_ADMIN".equals(currentUser.getRole())) {
			modelAndView.setViewName("adminHome");
		} else if (!"ROLE_ADMIN".equals(currentUser.getRole())) {
			modelAndView.setViewName("redirect:/403");
 		} else {
			modelAndView.setViewName("redirect:/login"); // Redirect to login if not admin
		}
		return modelAndView;
	}
	
	@GetMapping("/manager/home")
	public ModelAndView managerHome(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null && "ROLE_MANAGER".equals(currentUser.getRole())) {
			modelAndView.setViewName("managerHome");
		} else if (!"ROLE_MANAGER".equals(currentUser.getRole())) {
			modelAndView.setViewName("redirect:/403");
 		} else {
			modelAndView.setViewName("redirect:/login"); // Redirect to login if not admin
		}
		return modelAndView;
	}
	@GetMapping("/teacher/home")
	public ModelAndView teacherHome(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User currentUser = (User) session.getAttribute("currentUser");
		if (currentUser != null && "ROLE_TEACHER".equals(currentUser.getRole())) {
			modelAndView.setViewName("managerHome");
		} else if (!"ROLE_TEACHER".equals(currentUser.getRole())) {
			modelAndView.setViewName("redirect:/403");
 		} else {
			modelAndView.setViewName("redirect:/login"); // Redirect to login if not admin
		}
		return modelAndView;
	}
	
	@GetMapping("/quizTimeout")
	public String quizTimeout() {
		return "quizTimeout";
	}
	
//	  @RequestMapping("/user")
//	  public String user() {
//	    return "user";
//	  }
//	  @RequestMapping("/admin")
//	  public String admin() {
//	    return "admin";
//	  }
	  

}

