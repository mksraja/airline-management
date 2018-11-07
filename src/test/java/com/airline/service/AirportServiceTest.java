package com.airline.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.airline.common.config.TestApplicationConfig;
import com.airline.dao.AirportDAO;
import com.airline.vo.Airport;

/**
 * This is the test class to verify the functionalities in Airport Service
 * 
 * @author Muthu
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
public class AirportServiceTest {
  
  @InjectMocks
  private AirportServiceImpl airportService;
  
  @Mock
  private AirportDAO airportDAO; 

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  
  /**
   * This is the test method to test Top 10 Highest number of airports
   */
  @Test
  public void testGetHighestNoOfAirports() {
    when(airportDAO.getTopTenHighestAirports()).thenReturn(getAirportList());
    List<Airport> highAirports = airportService.getHighestNoOfAirports();
    assertEquals("The list should contain Top 10 Highest airports", 10, highAirports.size());
  }
  
  /**
   * This is the test method to test Top 10 Lowest number of airports
   */
  @Test
  public void testGetLowestNoOfAirports() {
    when(airportDAO.getTopTenLowestAirports()).thenReturn(getAirportList());
    List<Airport> highAirports = airportService.getLowestNoOfAirports();
    assertEquals("The list should contain Top 10 Lowest airports", 10, highAirports.size());
  }
  
  /**
   * This method is used to test search service by country code or name
   */
  @Test
  public void testSearchAirports() {
    String countryCode = "NL";
    String countryName = "United States";
    when(airportDAO.findAllAirportsByCountry(countryCode, "")).thenReturn(getAirports(countryCode, ""));
    List<Airport> searchList = airportService.searchAirports(countryCode, "");
    Airport searchCountry = searchList.get(0);
    assertEquals("Search By Country Code results should match expected count", 1, searchList.size());
    assertEquals("Country code should match in the search results", countryCode, searchCountry.getIsoCountry());
    when(airportDAO.findAllAirportsByCountry("", countryName)).thenReturn(getAirports("", countryName));
    searchList = airportService.searchAirports("", countryName);
    searchCountry = searchList.get(0);
    assertEquals("Search By Country Name results should match expected count", 1, searchList.size());
    assertEquals("Country code should match in the search results", countryName, searchCountry.getCountryName());
  }

  
  /**
   * This method populates the list of mocked airports
   * 
   * @return list - Airport list
   */
  private List<Airport> getAirportList() {
    List<Airport> airportList = new ArrayList<Airport>();
    Airport airport = null;
    for (int i=1; i<=10; i++) {
      airport = new Airport();
      airport.setId(i);
      airport.setIsoCountry("ISO-" + i);
      airport.setCountryName("Country-" + i);
      airport.setIdent("Ident-" + i);
      airportList.add(airport);
    }
    return airportList;
  }
  
  
  /**
   * This method returns the mocked airport list to test search functionality
   * 
   * @param countryCode - Country code
   * @param countryName - Country name
   * @return list - Airport list
   */
  private List<Airport> getAirports(String countryCode, String countryName) {
    List<Airport> airportList = new ArrayList<Airport>();
    Airport airport1 = createMockAirport(countryCode, countryName);
    airportList.add(airport1);
    return airportList;
  }
  
  /**
   * 
   * @param countryCode - Country code
   * @param countryName - Country name
   * @return airport - Airport
   */
  private Airport createMockAirport (String code, String country) {
    Airport airport = new Airport();
    airport.setIdent("Ident");
    airport.setIsoCountry(code);
    airport.setCountryName(country);
    return airport;
  }

}
