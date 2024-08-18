package com.crio.learningnavigatorV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.learningnavigatorV2.entity.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByStudentId(Long id);
}
