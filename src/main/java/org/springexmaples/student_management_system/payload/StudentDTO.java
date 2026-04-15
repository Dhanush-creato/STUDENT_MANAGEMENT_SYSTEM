package org.springexmaples.student_management_system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private Integer age;
}
