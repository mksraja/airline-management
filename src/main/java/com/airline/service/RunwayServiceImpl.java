package com.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.dao.RunwayDAO;
import com.airline.vo.Runway;

/**
 * This Service class is used to provide implementation details for interface RunwayService
 * 
 * @author Muthu
 *
 */
@Service
public class RunwayServiceImpl implements RunwayService {

  @Autowired
  private RunwayDAO runwayDAO;
  
  
  /**
   * This method is used to return Type of runways (as indicated in "surface" column) per country
   * 
   * @return runwayList- List of Runways
   */
  public List<Runway> getTypeOfRunways() {
      return runwayDAO.getAllRunways();
  }
  
  
  /**
   * This method is used to return the top 10 most common runway identifications (indicated in "le_ident" column)
   * 
   * @return runwayList - List of Runways
   */
  public List<Runway> getCommonRunways() {
    return runwayDAO.findTopTenCommonRunways();
  }
  
  
}
