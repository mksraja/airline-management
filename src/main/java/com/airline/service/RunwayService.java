package com.airline.service;

import java.util.List;

import com.airline.vo.Runway;

/**
 * This Service is used to provide business operations for Runway related functionalities
 * 
 * @author Muthu
 *
 */
public interface RunwayService {
  
  
  /**
   * This method is used to return Type of runways (as indicated in "surface" column) per country
   * 
   * @return runwayList- List of Runways
   */
  public List<Runway> getTypeOfRunways();
  
  
  /**
   * This method is used to return the top 10 most common runway identifications (indicated in "le_ident" column)
   * 
   * @return runwayList - List of Runways
   */
  public List<Runway> getCommonRunways();
  

}
