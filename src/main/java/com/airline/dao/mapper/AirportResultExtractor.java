package com.airline.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.airline.vo.Airport;
import com.airline.vo.Runway;

/**
 * This class is a result set extractor for Airport
 * It extracts the result set and map one to many of Airport and Runways
 * It uses the RowMapper for Airport and Runway to extract the data from result set
 * 
 * @author Muthu
 *
 */
@Component
public class AirportResultExtractor implements ResultSetExtractor<List<Airport>> {
  
  @Autowired
  AirportMapper airportMapper;
  
  @Autowired
  RunwayMapper runwayMapper;

  /**
   * This method returns the extracted list from result set
   * 
   * @param rs - Result set
   * @return airportList - List of Airports
   * @throws SQLException - SQLException 
   * @throws DataAccessException - DataAccessException
   */
  @Override
  public List<Airport> extractData(ResultSet rs)
      throws SQLException, DataAccessException {
    List<Airport> airportList = new ArrayList<Airport>();
    Map<Integer, Airport> airportMap = new HashMap<Integer, Airport>();
    Airport airport;
    Runway runway;
    int rowNum = 1;
    while (rs.next()) {
     Integer id = rs.getInt("id");
      if (airportMap.containsKey(id)) {
        airport = airportMap.get(id);
      } else {
        airport = airportMapper.mapRow(rs, rowNum++);
        Set<Runway> runways = new HashSet<Runway>();
        airport.setRunways(runways);
      }
      runway = runwayMapper.mapRow(rs, rowNum);
      airport.getRunways().add(runway);
      airportList.add(airport);
    }
    return airportList;
  }
  

}
