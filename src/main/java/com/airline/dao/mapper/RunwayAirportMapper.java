package com.airline.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.airline.vo.Airport;
import com.airline.vo.Runway;

/**
 * This is a custom mapper class to map the result set into Runway object
 * It retrieves the result set by joining multiple tables and map it to the right object structure  
 * 
 * @author Muthu
 *
 */
public class RunwayAirportMapper implements RowMapper<Runway> {

  /**
   * This method maps the result set into Runway and associated Airport objects
   * 
   * @param rs - ResultSet
   * @param rowNum - Row Number
   * @return object - Runway Object
   */
  public Runway mapRow(ResultSet rs, int rowNum) throws SQLException {
      Runway runway = new Runway();
      Airport airport = new Airport();
      runway.setSurface(rs.getString("surface"));
      airport.setIsoCountry(rs.getString("iso_country"));
      airport.setCountryName(rs.getString("country"));
      runway.setAirport(airport);
      return runway;
  }

}
