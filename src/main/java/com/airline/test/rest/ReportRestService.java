package com.airline.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airline.service.AirportService;
import com.airline.service.RunwayService;
import com.airline.vo.Airport;
import com.airline.vo.Runway;

/**
 * This Rest Service is used perform Reports related operations
 * 
 * @author Muthu
 *
 */
@Controller
@RequestMapping(value = "/reports")
public class ReportRestService {

  @Autowired
  private RunwayService runwayService;
  
  @Autowired
  private AirportService airportService;
  
  
  /**
   * This method is used to return Top 10 Highest Number of Airports
   * 
   * @return list - The Airport list
   */
  @RequestMapping(value = "/airports/highest", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Airport>> viewTopTenHighestAirports() {

    List<Airport> airportList = airportService.getHighestNoOfAirports();
    if (airportList == null || airportList.isEmpty()) {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
    }
  }
  
  /**
   * This method is used to return Top 10 Lowest Number of Airports
   * 
   * @return list - The Airport list
   */
  @RequestMapping(value = "/airports/lowest", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Airport>> viewTopTenLowestAirports() {

    List<Airport> airportList = airportService.getLowestNoOfAirports();
    if (airportList == null || airportList.isEmpty()) {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
    }
  }

  
  /**
   * This method is used to return Top 10 Common Runways
   * 
   * @return list - The Runway list
   */
  @RequestMapping(value = "/commonRunways", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Runway>> viewTopTenCommonRunways() {

    List<Runway> runways = runwayService.getCommonRunways();
    if (runways == null || runways.isEmpty()) {
      return new ResponseEntity<List<Runway>>(runways, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Runway>>(runways, HttpStatus.OK);
    }
  }


  
  /**
   * This method is used to return all types of runways by each country 
   * 
   * @return list - The Runway list
   */
  @RequestMapping(value = "/runwayTypes", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Runway>> viewAllRunwaysByCountry() {
    List<Runway> runwayList = runwayService.getTypeOfRunways();
    if (runwayList == null || runwayList.isEmpty()) {
      return new ResponseEntity<List<Runway>>(runwayList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Runway>>(runwayList, HttpStatus.OK);
    }
  }

}
