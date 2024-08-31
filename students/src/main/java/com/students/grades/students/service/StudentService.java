package com.students.grades.students.service;

import com.students.grades.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService implements IStudentService {

    private final Map<Long, Student> studentRepository = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentRepository.values());
    }

    @Override
    public Student addStudent(Student student) {
        Long id = idCounter.incrementAndGet();
        student.setId(id);
        studentRepository.put(id, student);
        return student;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.remove(id);
    }
}