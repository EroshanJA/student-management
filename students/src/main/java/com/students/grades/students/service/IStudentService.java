package com.students.grades.students.service;

import com.students.grades.students.model.Student;
import java.util.List;


public interface IStudentService {
    List<Student> getAllStudents();
    Student addStudent(Student student);
    void deleteStudent(Long id);
}