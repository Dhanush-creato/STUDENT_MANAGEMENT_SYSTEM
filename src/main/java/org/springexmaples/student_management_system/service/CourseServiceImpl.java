package org.springexmaples.student_management_system.service;

import org.modelmapper.ModelMapper;
import org.springexmaples.student_management_system.Exception.ApiException;
import org.springexmaples.student_management_system.Exception.ResourceNotFoundException;
import org.springexmaples.student_management_system.model.Course;
import org.springexmaples.student_management_system.payload.CourseDTO;
import org.springexmaples.student_management_system.payload.CourseResponseDTO;
import org.springexmaples.student_management_system.repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    private final CourseRepo courseRepo;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepo courseRepo, ModelMapper modelMapper) {
        this.courseRepo = courseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDTO createCourse(Course course) {
        Course course1 = courseRepo.findByTitle(course.getTitle());
        if(course1 != null){
            throw new ApiException("The Course"+ course.getTitle()+"is Already is Regerted");
        }
      Course createdcourse =  courseRepo.save(course);
        CourseDTO courseDTO = modelMapper.map(createdcourse, CourseDTO.class);
        return courseDTO;
    }

    @Override
    public CourseResponseDTO getCourse() {
        List<Course> findCourse = courseRepo.findAll();
        if(findCourse.isEmpty()){
            throw new ApiException("No Course is Found Create Course!!!");
        }
        List<CourseDTO> courseDTOList = findCourse.stream().map(course -> modelMapper.map(course, CourseDTO.class)).toList();
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourse(courseDTOList);
        return courseResponseDTO;
    }

    @Override
    public CourseDTO updateCourse(Course course, Long courseId) {
        Course course1 = courseRepo.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course","Course Id", courseId));

        course1.setCourseId(courseId);
        course1.setTitle(course.getTitle());
        course1.setDescription(course.getDescription());

        Course updatedCourse = courseRepo.save(course1);
        CourseDTO courseDTO = modelMapper.map(updatedCourse, CourseDTO.class);
        return courseDTO;
    }

    @Override
    public CourseDTO deleteCourse(Long courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("Course ","Course ID",courseId));

        CourseDTO courseDTO = modelMapper.map(course, CourseDTO.class);
        courseRepo.delete(course);
        return courseDTO;
    }
}
