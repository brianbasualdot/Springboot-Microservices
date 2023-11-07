package com.microservice.students.controller;

import com.microservice.students.entities.Student;
import com.microservice.students.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentsService studentsService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudents(@RequestBody Student student){
        studentsService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(studentsService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentsService.findById(id));
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentsService.findByIdCourse(idCourse));
    }
}
