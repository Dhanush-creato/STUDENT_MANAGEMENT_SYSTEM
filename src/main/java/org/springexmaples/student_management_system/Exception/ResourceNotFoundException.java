package org.springexmaples.student_management_system.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String field;
    Long filedId;

    public ResourceNotFoundException(String resourceName, String field, Long filedId) {
        super(String.format("%s is not found with %s:%d", resourceName,field,filedId));
        this.resourceName = resourceName;
        this.field = field;
        this.filedId = filedId;
    }
}
