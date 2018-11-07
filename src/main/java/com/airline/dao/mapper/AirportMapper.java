package com.airline.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.airline.vo.Airport;

/**
 * This is a custom mapper class to map the result set into Airport object
 * It retrieves the result set and map it to the right object structure  
 * 
 * @author Muthu
 *
 */
@Component
public class AirportMapper implements RowMapper<Airport> {

  /**
   * This method maps the result set into Airport objects
   * 
   * @param rs - ResultSet
   * @param rowNum - Row Number
   * @return object - Airport Object
   */
  public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
      Airport airport = new Airport();
      airport.setId(rs.getInt("id"));
      airport.setIsoCountry(rs.getString("iso_country"));
      airport.setCountryName(rs.getString("country_name"));
      airport.setIdent(rs.getString("ident"));
      airport.setType(rs.getString("type"));
      return airport;
  }

}
