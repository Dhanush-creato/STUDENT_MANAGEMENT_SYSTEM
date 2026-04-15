package org.springexmaples.student_management_system.repo;

import org.springexmaples.student_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {




    List<Student> findByStudentNameLikeIgnoreCase(String s);
}
