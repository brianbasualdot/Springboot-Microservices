package com.microservice.course.services;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceIMPL implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    // Aqui es donde nuestro microservicio CURSO se conecta con el de ESTUDIANTES //

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        // hacemos la consulta del curso //

        Course course = courseRepository.findById(idCourse).orElse(new Course());

        // obtenemos los estudiantes //

        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);


        return StudentByCourseResponse.builder()
                    .courseName(course.getName())
                    .teacher(course.getTeacher())
                    .studentDTOList(studentDTOList)
                    .build();
    }
}
