package org.springexmaples.student_management_system.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExecption {

         @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<String> resoureceNotFoundExcprtion(ResourceNotFoundException e){

                 String Mesaage = e.getMessage();
                return new ResponseEntity<>(Mesaage, HttpStatus.NOT_FOUND);
                           }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> myApiException(ApiException e){
             String message = e.getMessage();
             return  new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

}
