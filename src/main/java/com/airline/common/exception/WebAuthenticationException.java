package com.airline.common.exception;

/**
 * This class is a Custom Exception for tracking Authentication and Authorization errors occurred in
 * the system
 * 
 * @author Muthu
 *
 */
public class WebAuthenticationException extends Exception {

  private static final long serialVersionUID = -4538341946614742115L;

  /**
   * Creates a new WebAuthenticationException with the specified message.
   * 
   * @param message The Exception Message
   */
  public WebAuthenticationException(final String message) {

    super(message);
  }

  /**
   * Creates a new WebAuthenticationException with the specified cause.
   * 
   * @param cause The Exception cause
   */
  public WebAuthenticationException(final Throwable cause) {

    super(cause);
  }

  /**
   * Creates a new WebAuthenticationException with the specified message and cause.
   * 
   * @param message The Exception Message
   * @param cause The Exception cause
   */
  public WebAuthenticationException(final String message, final Throwable cause) {

    super(message, cause);
  }


}
