package org.springexmaples.student_management_system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springexmaples.student_management_system.model.Course;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private List<Course> course = new ArrayList<>();
}
