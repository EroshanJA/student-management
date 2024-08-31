package com.students.grades.students;

import com.students.grades.students.controller.StudentController;
import com.students.grades.students.model.Student;
import com.students.grades.students.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentService studentService;

    @BeforeEach
    void setUp() {
        Student student1 = new Student(1L, "Simon Jake", 85.0);
        Student student2 = new Student(2L, "Irine Fernanderz", 75.0);
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(student1, student2));
        when(studentService.addStudent(any(Student.class))).thenAnswer(invocation -> {
            Student student = invocation.getArgument(0);
            student.setId(1L);
            return student;
        });
    }

    @Test
    void testGetAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Simon Jake"))
                .andExpect(jsonPath("$[1].name").value("Irine Fernanderz"));
    }

    @Test
    void testAddStudent() throws Exception {
        String studentJson = "{\"name\":\"Simon Jake\",\"averageGrade\":85.0}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Simon Jake"))
                .andExpect(jsonPath("$.averageGrade").value(85.0));
    }

    @Test
    void testDeleteStudent() throws Exception {
        Mockito.doNothing().when(studentService).deleteStudent(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/students/1"))
                .andExpect(status().isOk());
    }
}
