package io.petstore.swagger.exeptions;

import io.petstore.swagger.enums.Exception;

public class GenerateException extends AssertionError{
    
    public static final String STATUS_CODE_ERROR = Exception.STATUS_CODE_ERROR.getExceptionText();
    public static final String ERROR_PET_NAME_MISMATCH = Exception.ERROR_PET_NAME_MISMATCH.getExceptionText();
    public static final String JSON_TEMPLATE_READ_ERROR = Exception.JSON_TEMPLATE_READ_ERROR.getExceptionText();

    public GenerateException(String message, Throwable cause){
        super(message,cause);
    }

    public GenerateException(String message){
        super(message);
    }
    
}
