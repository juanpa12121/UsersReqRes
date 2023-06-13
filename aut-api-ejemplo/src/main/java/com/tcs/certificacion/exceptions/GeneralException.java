package com.tcs.certificacion.exceptions;

public class GeneralException extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code services response isn't expected";

    //Constructor
    public GeneralException(String message, Throwable cause){
        super(message, cause);
    }    public GeneralException(String message){
        super(message);
    }
}
