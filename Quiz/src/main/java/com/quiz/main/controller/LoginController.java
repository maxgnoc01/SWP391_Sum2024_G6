package com.quiz.main.controller;

import com.quiz.main.model.User;
import com.quiz.main.model.component.GooglePojo;
import com.quiz.main.model.component.GoogleUtils;
import com.quiz.main.repository.UserRepository;
import com.quiz.main.service.UserService;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
	private GoogleUtils googleUtils;

    @PostMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
//            if (user.getPassword().equals(password)) {
                // Assuming password is stored as plain text for demonstration; typically, you'd compare a hashed password.
                session.setAttribute("currentUser", user);
                // Adjust role check to match stored role strings
                if ("ROLE_ADMIN".equals(user.getRole())) {
                    return new ModelAndView("redirect:/admin/home"); // Redirect to admin home page
                } else if ("ROLE_USER".equals(user.getRole())) {
                    return new ModelAndView("redirect:/user/home"); // Redirect to user home page
                } else {
                    // Handle unexpected role
                    ModelAndView modelAndView = new ModelAndView("login");
                    modelAndView.addObject("error", "User role is not recognized.");
                    return modelAndView;
                }
//            }
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", "Invalid username or password");
        return modelAndView; // Stay on the login page and show an error message
    }
    

	
	@RequestMapping("/login-google")
	  public String loginGoogle(HttpServletRequest request, HttpSession session) throws ClientProtocolException, IOException {
	    String code = request.getParameter("code");
	    
	    if (code == null || code.isEmpty()) {
	      return "redirect:/login?google=error";
	    }
	    String accessToken = googleUtils.getToken(code);
	    
	    GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
	    UserDetails userDetail = googleUtils.buildUser(googlePojo);
	    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
	        userDetail.getAuthorities());
	    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String mail = googlePojo.getEmail();
	    Optional<User> userOptional = userService.findUserByEmail(mail);
	    if (userOptional.isPresent()) {
            User user = userOptional.get();
//            if (user.getPassword().equals(password)) {
                // Assuming password is stored as plain text for demonstration; typically, you'd compare a hashed password.
                session.setAttribute("currentUser", user);
                // Adjust role check to match stored role strings
                if ("ROLE_ADMIN".equals(user.getRole())) {
                    return "redirect:/admin/home"; // Redirect to admin home page
                } else if ("ROLE_USER".equals(user.getRole())) {
                    return "redirect:/user/home"; // Redirect to user home page
                } else if ("ROLE_MANAGER".equals(user.getRole())) {
                    return "redirect:/manager/home";
                } else if ("ROLE_TEACHER".equals(user.getRole())) 
                	return "redirect:/teacher/home";
            } else {
            	User newUser = userService.registerNewGoogleUser(googlePojo);
            	userOptional = userService.findUserByEmail(mail);
            }
	    session.setAttribute("currentUser",userOptional.get());
	    return "redirect:/user/home";
	  }
	
	@RequestMapping("/403")
	  public String accessDenied() {
	    return "403";
	  }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; // Redirect to login page after logout
    }
}
