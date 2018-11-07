package com.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.dao.AirportDAO;
import com.airline.vo.Airport;

/**
 * This Service class is used to provide implementation details for interface AirportService
 * 
 * @author Muthu
 *
 */
@Service
public class AirportServiceImpl implements AirportService {
  
  @Autowired
  private AirportDAO airportDAO;

  /**
   * This method is used to return highest number of airports and countries 
   *  
   * @return airportList - List of Airports
   */
  public List<Airport> getHighestNoOfAirports() {
    return airportDAO.getTopTenHighestAirports();
  }
  
  /**
   * This method is used to return lowest number of airports and countries
   * 
   * @return airportList - List of Airports
   */
  public List<Airport> getLowestNoOfAirports() {
    return airportDAO.getTopTenLowestAirports();
  }
  
  /**
   * This method returns the list of airports met by the search criteria
   * 
   * @param code - Country Code
   * @param country - Country Name
   * @return list - Airport list
   */
  public List<Airport> searchAirports(String code, String country) {
    String countryCode = code != null ? code.trim() : "";
    String countryName = country != null ? country.trim() : "";
    return airportDAO.findAllAirportsByCountry(countryCode, countryName);
  }


}
