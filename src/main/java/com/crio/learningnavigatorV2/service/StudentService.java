package com.crio.learningnavigatorV2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crio.learningnavigatorV2.entity.Student;
import com.crio.learningnavigatorV2.entity.Subject;
import com.crio.learningnavigatorV2.repository.StudentRepository;
import com.crio.learningnavigatorV2.repository.SubjectRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student saveStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

     @Transactional
    public Student enrollSubject(Long studentId, Long subjectId) {
        Student student = getStudentById(studentId);
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Subject not found"
        ));
        student.getEnrolledSubjects().add(subject);
        return studentRepository.save(student);
    }
}
