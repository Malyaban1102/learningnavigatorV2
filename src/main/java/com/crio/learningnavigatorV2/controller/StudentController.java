package com.crio.learningnavigatorV2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.learningnavigatorV2.entity.Student;
import com.crio.learningnavigatorV2.service.ExamService;
import com.crio.learningnavigatorV2.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/v2/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student saved = studentService.saveStudent(student);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId){
        Student student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{studentId}/enrollsubject/{subjectId}")
    public ResponseEntity<Student> enrolledSubject(
            @PathVariable Long studentId,
            @PathVariable Long subjectId )
    {
        Student student = studentService.enrollSubject(studentId, subjectId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{studentId}/regexam/{examId}")
    public ResponseEntity<Student> regexam(
            @PathVariable Long studentId,
            @PathVariable Long  examId)
    {
        Student student = examService.registerExams(studentId, examId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
