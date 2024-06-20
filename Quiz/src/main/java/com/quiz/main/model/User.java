package com.quiz.main.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

//    @Column(nullable = false)
//    private String password;

    @Column(nullable = false)
    private String role; // Now a simple String field

    // Constructors, getters, and setters
    
    @Enumerated(EnumType.STRING)
    private Provider provider;
    
    @ManyToMany(mappedBy = "studentList")
    List<Classes> classList;
    
    
    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    // Inside User class
    public boolean isAdmin() {
        return "ADMIN".equals(this.role); // Assuming 'role' is a String attribute in User class
    }

}
