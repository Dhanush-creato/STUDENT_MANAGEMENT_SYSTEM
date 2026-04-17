package org.springexmaples.student_management_system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springexmaples.student_management_system.model.Student;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseDTO {
    private Long courseId;
    private String title;
    private String description;
    private List<Student> student = new ArrayList<>();
}
