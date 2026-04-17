package org.springexmaples.student_management_system.contoller;

import org.springexmaples.student_management_system.model.Course;
import org.springexmaples.student_management_system.model.Student;
import org.springexmaples.student_management_system.payload.CourseDTO;
import org.springexmaples.student_management_system.payload.CourseResponseDTO;
import org.springexmaples.student_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CourseController {




    @Autowired
    private CourseService courseService;


    @PostMapping("student/course")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course){
        CourseDTO courseDTO = courseService.createCourse(course);
        return  new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @GetMapping("student/getCourse")
    public ResponseEntity<CourseResponseDTO> getCourse(){
        CourseResponseDTO courseResponseDTO = courseService.getCourse();
        return new ResponseEntity<>(courseResponseDTO,HttpStatus.OK);
    }
    @PutMapping("student/updateCourse/{courseId}")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody Course course ,@PathVariable Long courseId){
        CourseDTO courseDTO = courseService.updateCourse(course,courseId);
        return new ResponseEntity<>(courseDTO,HttpStatus.OK);
    }

    @DeleteMapping("student/deleteCourse/{courseId}")
    public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Long courseId){
        CourseDTO courseDTO = courseService.deleteCourse(courseId);
        return  new ResponseEntity<>(courseDTO,HttpStatus.OK);
    }
}
