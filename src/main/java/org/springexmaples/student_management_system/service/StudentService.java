package org.springexmaples.student_management_system.service;

import org.springexmaples.student_management_system.payload.StudentDTO;
import org.springexmaples.student_management_system.payload.StudentResponseDTO;

public interface StudentService {
    StudentDTO createStudent(StudentDTO student);

    StudentResponseDTO getStudent();

    StudentResponseDTO getStudentsById(Long studentId);

    StudentResponseDTO getStudentsByName(String name);

    StudentDTO updateStudent(StudentDTO student, Long studentId);

    StudentDTO deleteStudent(Long studentId);
}
