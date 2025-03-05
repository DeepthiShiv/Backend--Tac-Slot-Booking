package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @SuppressWarnings("rawtypes")
    @Autowired
    private StudentRepository studentRepository;

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}