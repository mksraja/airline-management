package com.airline.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airline.service.AirportService;
import com.airline.vo.Airport;

/**
 * This Rest Service is used to perform Query related operations
 * 
 * @author Muthu
 *
 */
@Controller
@RequestMapping(value = "/query")
public class QueryRestService {


  @Autowired
  AirportService airportService;

  /**
   * This method is used to return all airports and runways by country code or name
   * 
   * @return list - The Airports list
   */
  @RequestMapping(value = "/search",
      method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<List<Airport>> searchAirportsByCodeOrName(
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "country", required = false) String country) {
    String countryCode = "";
    String countryName = "";
    if (code != null) {
      countryCode = code;
    }
    if (country != null) {
      countryName = country;
    }
    List<Airport> airportList = airportService.searchAirports(countryCode, countryName);
    if (airportList == null || airportList.isEmpty()) {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<List<Airport>>(airportList, HttpStatus.OK);
    }
  }

}
