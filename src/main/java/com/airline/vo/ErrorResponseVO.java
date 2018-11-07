package com.airline.vo;

import java.util.List;


/**
 * This class represents the Value Object for Error Message This ErrorResponse will be returned from
 * Rest service during error conditions
 * 
 * @author Muthu
 *
 */
public class ErrorResponseVO {

  private String httpStatusCode;
  private String errorMessage;
  private List<ErrorVO> errors;
  private String errorCode;

  /**
   * This is the default constructor for ErrorRespnseVO This constructor can be used to overwrite
   * the default values using setter methods
   */
  public ErrorResponseVO() {
    this.httpStatusCode = "";
    this.errorMessage = "";
  }

  /**
   * This constructor is used to assign only error code and error message
   * 
   * @param errorMessage - The Error Message contains the error description
   */
  public ErrorResponseVO(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * This constructor is used to assign error messages including status code
   * 
   * @param httpStatus - The HttpStatus value
   * @param errorMessage - The Error Message contains the error description
   * @param errors - The Error List
   * @see #ErrorResponseVO(String, String, List)
   */
  public ErrorResponseVO(String httpStatus, String errorMessage, List<ErrorVO> errors) {
    this.httpStatusCode = httpStatus;
    this.errorMessage = errorMessage;
    this.errors.addAll(errors);
  }

  public String getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(String httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public List<ErrorVO> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorVO> errors) {
    this.errors = errors;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }


}
