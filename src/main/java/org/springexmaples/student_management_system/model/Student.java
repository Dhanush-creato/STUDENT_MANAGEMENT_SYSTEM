package org.springexmaples.student_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
    private Integer age;


    @ManyToMany(mappedBy = "student")
    private List<Course> course = new ArrayList<>();

}
