package com.crio.learningnavigatorV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.learningnavigatorV2.entity.Subject;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    List<Subject> findAllBySubjectId(Long SubjectId);
}
