package com.airline.common.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.airline.common.Constants;
import com.airline.common.MessageReader;
import com.airline.common.exception.WebAuthenticationException;
import com.airline.vo.ErrorResponseVO;
import com.airline.vo.ErrorVO;

/**
 * This class represents global exception handler for all security related exceptions This class
 * contains methods to handle security specific exceptions They are Authentication, Authorization,
 * Password mismatch, etc
 * 
 * @author Muthu
 *
 */

@ControllerAdvice
public class SecurityExceptionHandler extends ResponseEntityExceptionHandler {


  @Autowired
  private MessageReader messageReader;

  /**
   * This method is used to handle Authentication Exception thrown in the system This method
   * receives the WebAuthenticationException and it converts into ErrorResponse This ErrorResponse
   * will contain the required details that will be returned as response It contains the details of
   * http status, error code, error message
   * 
   * @param webAuthenticationException - The WebAuthenticationException
   * @return ErrorResponseVO - The ErrorResponseVO contains the error details
   */
  @ExceptionHandler(WebAuthenticationException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponseVO> handleUserNotFoundException(
      final WebAuthenticationException webAuthenticationException) {
    ErrorResponseVO errorResponse = new ErrorResponseVO();
    List<ErrorVO> errors = new ArrayList<ErrorVO>();
    ErrorVO error = new ErrorVO();
    String errorCode = webAuthenticationException.getMessage();
    String errorMessage = messageReader.readMessage(errorCode);
    errorResponse.setHttpStatusCode(HttpStatus.FORBIDDEN.getReasonPhrase());
    error.setErrorCode(errorCode);
    error.setErrorMessage(errorMessage);
    errors.add(error);
    error.setErrorType(Constants.ERROR_MESSAGE_TYPE);
    errorResponse.setErrors(errors);
    return new ResponseEntity<ErrorResponseVO>(errorResponse, HttpStatus.FORBIDDEN);
  }


}
