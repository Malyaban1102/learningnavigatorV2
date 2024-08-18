package com.crio.learningnavigatorV2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.learningnavigatorV2.entity.Exam;
import com.crio.learningnavigatorV2.service.ExamService;
import java.util.List;

@RestController
@RequestMapping("/v2/exams")
public class ExamController {
   

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExam() {
        List<Exam> exam = examService.getAllExams();
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exam> AddExam(@RequestBody Exam exam) {
        Exam savedSubject = examService.save(exam);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
