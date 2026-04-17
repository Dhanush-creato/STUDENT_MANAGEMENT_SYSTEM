package org.springexmaples.student_management_system.service;

import org.springexmaples.student_management_system.model.Course;
import org.springexmaples.student_management_system.payload.CourseDTO;
import org.springexmaples.student_management_system.payload.CourseResponseDTO;

public interface CourseService {
    CourseDTO createCourse(Course course);

    CourseResponseDTO getCourse();



    CourseDTO updateCourse(Course course, Long courseId);

    CourseDTO deleteCourse(Long courseId);
}
