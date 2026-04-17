package org.springexmaples.student_management_system.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiException extends RuntimeException{


    public ApiException(String message) {
     super(message);
    }

}
