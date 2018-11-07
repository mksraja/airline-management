package com.airline.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.airline.common.config.TestApplicationConfig;
import com.airline.vo.Airport;

@ContextConfiguration(classes = TestApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AirportDAOTest {
  
  @Autowired
  private AirportDAO airportDAO;
  
 
  /**
   * This is the test method to verify getTopTenHighestAirports
   */
  @Test
  public void testGetTopTenHighestAirports() {
    List<Airport> topAirports = airportDAO.getTopTenHighestAirports();
    Assert.assertNotNull("Top Ten Highest Airports list should not be Empty", topAirports);
    Assert.assertEquals("Result set should contains 10 records", 10, topAirports.size());
  }
  
  /**
   * This is the test method to verify getTopTenLowestAirports
   */
  @Test
  public void testGetTopTenLowestAirports() {
    List<Airport> lowestAirports = airportDAO.getTopTenLowestAirports();
    Assert.assertNotNull("Top Ten Lowest Airports list should not be Empty", lowestAirports);
    Assert.assertEquals("Result set should contains 10 records", 10, lowestAirports.size());
  }

  /**
   * This is the test to list out airports and runways by country code or name
   */
  @Test
  public void testFindAllAirportsByCountry() {
    List<Airport> airports = airportDAO.findAllAirportsByCountry("BE", "zimb");
    Assert.assertNotNull("Airports list by country code and name should not be Empty", airports);
    airports = airportDAO.findAllAirportsByCountry("BE", "");
    Assert.assertNotNull("Airports list by country code should not be Empty", airports);
    airports = airportDAO.findAllAirportsByCountry("", "zimb");
    Assert.assertNotNull("Airports list by country name should not be Empty", airports);
  }

}
