package com.students.grades.students.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Student {
    private Long id;
    private String name;
    private Double averageGrade;

    // Constructor
    public Student(Long id, String name, Double averageGrade) {
        this.id = id;
        this.name = name;
        this.averageGrade = averageGrade;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getAverageGrade() { return averageGrade; }
    public void setAverageGrade(Double averageGrade) { this.averageGrade = averageGrade; }
}


