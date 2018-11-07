package com.airline.service;

import java.util.List;

import com.airline.vo.Airport;

/**
 * This Service is used to provide business operations for Airport related functionalities
 * 
 * @author Muthu
 *
 */
public interface AirportService {
  
  /**
   * This method is used to return highest number of airports and countries 
   *  
   * @return airportList - List of Airports
   */
  public List<Airport> getHighestNoOfAirports();
  
  /**
   * This method is used to return lowest number of airports and countries
   * 
   * @return airportList - List of Airports
   */
  public List<Airport> getLowestNoOfAirports();
  
  /**
   * This method returns the list of airports met by the search criteria
   * 
   * @param code - Country Code
   * @param country - Country Name
   * @return list - Airport list
   */
  public List<Airport> searchAirports(String code, String country);

}
