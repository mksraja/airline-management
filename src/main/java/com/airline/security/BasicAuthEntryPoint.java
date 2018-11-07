package com.airline.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.airline.common.Constants;

/**
 * This class is used to handle Basic Authentication, BasicAuthenticationEntryPoint provisioned by
 * Spring Security returns a 401 Unauthorized response back to the client
 * 
 * @author Muthu
 *
 */
@Component
public class BasicAuthEntryPoint extends BasicAuthenticationEntryPoint {

  /**
   * This method is used to return response to Access Denied
   * 
   * @param request - The HttpServletRequest
   * @param response - The HttpServletResponse
   * @param authEx - The AuthenticationException
   * 
   */
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authEx) throws IOException, ServletException {
    response.addHeader(Constants.WWW_AUTHENTICATE, Constants.BASIC_REALM + getRealmName());
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    writer.println(Constants.HTTP_STATUS_401 + authEx.getMessage());
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    setRealmName(Constants.TEST_USR);
    super.afterPropertiesSet();
  }
}
