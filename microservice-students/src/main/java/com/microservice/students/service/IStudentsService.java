package com.microservice.students.service;

import com.microservice.students.entities.Student;

import java.util.List;

public interface IStudentsService {
    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);

}
