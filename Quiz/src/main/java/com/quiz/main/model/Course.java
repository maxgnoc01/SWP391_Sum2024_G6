package com.quiz.main.model;

public class Course {
    private Long id;
    private String semester;
    private String courseName;
    public Long getId() {
        return id;
    }
    public String getSemester() {
        return semester;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    

}
