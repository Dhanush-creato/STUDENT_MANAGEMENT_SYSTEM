package org.springexmaples.student_management_system.service;


import org.modelmapper.ModelMapper;
import org.springexmaples.student_management_system.Exception.ApiException;
import org.springexmaples.student_management_system.Exception.ResourceNotFoundException;
import org.springexmaples.student_management_system.model.Course;
import org.springexmaples.student_management_system.model.Student;
import org.springexmaples.student_management_system.payload.StudentDTO;
import org.springexmaples.student_management_system.payload.StudentResponseDTO;
import org.springexmaples.student_management_system.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
   private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO createStudent(StudentDTO students) {


        Student student = modelMapper.map(students, Student.class);
        Student findName = studentRepo.findByStudentName(student.getStudentName());
        if(findName != null){
            throw  new ApiException("The name:"+student.getStudentName()+" is Already present change Name");
        }
     Student student1 =  studentRepo.save(student);
       StudentDTO  studentDTO = modelMapper.map(student1, StudentDTO.class);
       return studentDTO;
    }

    @Override
    public StudentResponseDTO getStudent() {

     List<Student> students  =  studentRepo.findAll();
     if(students.isEmpty()){
         throw new ApiException("Students are Empty Add Students");
     }
     List<StudentDTO> studentDTOS = students.stream().map(student->modelMapper.map(student, StudentDTO.class)).toList();
     StudentResponseDTO studentResponseDTO =new StudentResponseDTO();
      studentResponseDTO.setStudents(studentDTOS);
        return studentResponseDTO ;
    }

    @Override
    public StudentResponseDTO getStudentsById(Long studentId) {
     Optional<Student> student = studentRepo.findById(studentId);
     if(student.isEmpty()){
         throw new ResourceNotFoundException("Student ","Student ID",studentId);
     }
        List<StudentDTO> studentDTOS = student.stream().map(stu->modelMapper.map(stu, StudentDTO.class)).toList();
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setStudents(studentDTOS);

        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudentsByName(String name) {
      List<Student> studentsByName = studentRepo.findByStudentNameLikeIgnoreCase("%"+name+"%");

      if(studentsByName.isEmpty()){
          throw  new ApiException("Students with name:"+name+" Not found");
      }

        List<StudentDTO> studentDTOS = studentsByName.stream().map(stu->modelMapper.map(stu, StudentDTO.class)).toList();
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setStudents(studentDTOS);
        return studentResponseDTO;
    }

    @Override
    public StudentDTO updateStudent( StudentDTO studentDTO, Long studentId) {

        Student getStudent = studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student","Student ID",studentId));



        getStudent.setStudentId(studentId);
             getStudent.setStudentName(studentDTO.getStudentName());
             getStudent.setPhoneNumber(studentDTO.getPhoneNumber());
             getStudent.setEmail(studentDTO.getEmail());
             getStudent.setAge(studentDTO.getAge());

        Student updatedStudent = studentRepo.save(getStudent);
        StudentDTO studentDTO1 = modelMapper.map(updatedStudent, StudentDTO.class);
        return studentDTO1;

    }

    @Override
    public StudentDTO deleteStudent(Long studentId) {
        Student deleteFind = studentRepo.findById(studentId) .orElseThrow(()->new ResourceNotFoundException("Student","Student ID",studentId));
         studentRepo.delete(deleteFind);
        StudentDTO studentDTO = modelMapper.map(deleteFind, StudentDTO.class);
        return studentDTO ;
    }


}
