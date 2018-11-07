package com.airline.dao;

import java.util.List;

import com.airline.vo.Runway;

/**
 * This interface defines the methods to Create, Read, Update, Delete, View and list operations
 * on the Runway table. It represents the DAO for Runway 
 * 
 * @author Muthu
 *
 */
public interface RunwayDAO {
  
  /**
   * This method is used to retrieve and returns the top 10 most commonly used runways
   * It finds the top 10 runways based on the number of identifications used across the airport 
   * 
   * @return runwayList - Returns the Top Ten Runways
   */
  public List<Runway> findTopTenCommonRunways();
  
  /**
   * This method returns all Runways available in each country
   * Each Runway belong to particular Airport
   * 
   * @return airportList - Airports with Runways
   */
  public List<Runway> getAllRunways();


}
