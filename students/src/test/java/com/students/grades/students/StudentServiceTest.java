package com.students.grades.students;

import com.students.grades.students.model.Student;
import com.students.grades.students.service.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
    }

    @Test
    void testAddStudent() {
        Student student = new Student(null, "Simon Jake", 85.0);
        Student addedStudent = studentService.addStudent(student);

        assertNotNull(addedStudent.getId());
        assertEquals("Simon Jake", addedStudent.getName());
        assertEquals(85.0, addedStudent.getAverageGrade());
    }

    @Test
    void testGetAllStudents() {
        studentService.addStudent(new Student(null, "Simon Jake", 85.0));
        studentService.addStudent(new Student(null, "Irine Fernanderz", 75.0));

        List<Student> students = studentService.getAllStudents();
        assertEquals(2, students.size());
    }

    @Test
    void testDeleteStudent() {
        Student student = studentService.addStudent(new Student(null, "Simon Jake", 85.0));
        studentService.deleteStudent(student.getId());

        List<Student> students = studentService.getAllStudents();
        assertTrue(students.isEmpty());
    }
}
