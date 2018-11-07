package com.airline.common.exception;

/**
 * This class is a Custom Exception for tracking BusinessServiceRuntimeException occurred in the
 * system
 * 
 * @author Muthu.
 *
 */
public class BusinessServiceRuntimeException extends RuntimeException {

  private static final long serialVersionUID = -4922307489011453020L;

  /**
   * Creates a new BusinessServiceRuntimeException with the specified message.
   * 
   * @param message The Exception Message
   */
  public BusinessServiceRuntimeException(final String message) {

    super(message);
  }

  /**
   * Creates a new BusinessServiceRuntimeException with the specified cause.
   * 
   * @param cause The Exception cause
   */
  public BusinessServiceRuntimeException(final Throwable cause) {

    super(cause);
  }

  /**
   * Creates a new BusinessServiceRuntimeException with the specified message and cause.
   * 
   * @param message The Exception Message
   * @param cause The Exception cause
   */
  public BusinessServiceRuntimeException(final String message, final Throwable cause) {

    super(message, cause);
  }

}
