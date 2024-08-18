package com.crio.learningnavigatorV2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crio.learningnavigatorV2.entity.Exam;
import com.crio.learningnavigatorV2.entity.Student;
import com.crio.learningnavigatorV2.repository.ExamRepository;
import com.crio.learningnavigatorV2.repository.StudentRepository;
import java.util.List;

@Service
public class ExamService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamRepository examRepository;

    public Exam save(Exam exam) {
        examRepository.save(exam);
        return exam;
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student registerExams(Long studentId, Long subjectId) {
        Student student = getStudentById(studentId);
        Exam exam = examRepository.findById(subjectId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "exam not found"
        ));
        student.getRegisteredExams().add(exam);
        return studentRepository.save(student);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
