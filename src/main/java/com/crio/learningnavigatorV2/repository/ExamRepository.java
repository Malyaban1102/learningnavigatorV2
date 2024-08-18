package com.crio.learningnavigatorV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.learningnavigatorV2.entity.Exam;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> findAllByExamId(Long ExamId);
}
