package org.springexmaples.student_management_system.contoller;


import org.springexmaples.student_management_system.model.Student;
import org.springexmaples.student_management_system.payload.StudentDTO;
import org.springexmaples.student_management_system.payload.StudentResponseDTO;
import org.springexmaples.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/createStudent")
      public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);

      }

      @GetMapping("/student/getStudent")
    public ResponseEntity<StudentResponseDTO> getStudent(){
        StudentResponseDTO studentResponseDTO = studentService.getStudent();
        return  new ResponseEntity<>(studentResponseDTO,HttpStatus.OK);
      }

      @GetMapping("/student/getStudent/{studentId}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long studentId){
        StudentResponseDTO studentResponseDTO = studentService.getStudentsById(studentId);
        return  new ResponseEntity<>(studentResponseDTO,HttpStatus.OK);
      }

    @GetMapping("/student/getStudentByName/{name}")
    public ResponseEntity<StudentResponseDTO> getStudentByName(@PathVariable String name){
        StudentResponseDTO studentResponseDTO = studentService.getStudentsByName(name);
        return  new ResponseEntity<>(studentResponseDTO,HttpStatus.OK);
    }

    @PutMapping("/student/updateStudent/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO ,@PathVariable Long studentId)
    {
        StudentDTO updateStudent = studentService.updateStudent(studentDTO,studentId);
        return new ResponseEntity<>(updateStudent,HttpStatus.CREATED);
    }

    @DeleteMapping("/student/deleteStudent/{studentId}")
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable Long studentId){
        StudentDTO deleteStudent = studentService.deleteStudent(studentId);
        return  new ResponseEntity<>(deleteStudent,HttpStatus.OK);
    }

}
