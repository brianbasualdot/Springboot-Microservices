package com.microservice.students.service;

import com.microservice.students.entities.Student;
import com.microservice.students.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceIMPL implements IStudentsService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findAllStudent(idCourse);
    }
}
