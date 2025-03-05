package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository<S> extends JpaRepository<Student, Integer> {
    Student findByEmailAndPassword(String email, String password);

    void save(Iterable<S> iterable);
}
