package com.airline.dao;

import java.util.List;

import com.airline.vo.Airport;

/**
 * This interface defines the methods to Create, Read, Update, Delete, View and list operations
 * on the Airport and its associated tables. It represents the DAO for Airport 
 * 
 * @author Muthu
 *
 */
public interface AirportDAO {
  
  /**
   * This method returns the top ten highest airports and its country name
   * 
   * @return airportList - Airports List
   */
  public List<Airport> getTopTenHighestAirports();
  
  /**
   * This method returns the top ten lowest airports and its country name
   * 
   * @return airportList - Airports List
   */
  public List<Airport> getTopTenLowestAirports();
  
  
  /**
   * This method returns all the airports and runways present in the matching countries
   * It searches the list of countries by country code or country name
   * 
   * 
   * @param counrtyCode - Country Code
   * @param countryName - Country Name
   * @return airportList - List of Airports
   */
  public List<Airport> findAllAirportsByCountry(String counrtyCode, String countryName);

}
