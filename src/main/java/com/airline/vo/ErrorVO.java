package com.airline.vo;



/**
 * This class represents the Value Object for Error Message This Error will be returned from Rest
 * service during error conditions
 * 
 * @author Muthu
 *
 */
public class ErrorVO {

  private String errorType;
  private String errorCode;
  private String errorMessage;

  /**
   * This is the default constructor for ErrorRespnseVO This constructor can be used to overwrite
   * the default values using setter methods
   */
  public ErrorVO() {
    this.errorType = "";
    this.errorCode = "";
    this.errorMessage = "";
  }

  /**
   * This constructor is used to assign only error code and error message
   * 
   * @param errorCode - The Error Code
   * @param errorMessage - The Error Message contains the error description
   */
  public ErrorVO(String errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  /**
   * This constructor is used to assign error messages including status code
   * 
   * @param errorType - The Error Type
   * @param errorCode - The Error Code
   * @param errorMessage - The Error Message contains the error description
   */
  public ErrorVO(String errorType, String errorCode, String errorMessage) {
    this.errorType = errorType;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }


}
