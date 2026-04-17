package org.springexmaples.student_management_system.repo;

import org.springexmaples.student_management_system.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course , Long> {
    Course findByTitle(String title);
}
