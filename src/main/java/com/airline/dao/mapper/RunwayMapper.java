package com.airline.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.airline.vo.Runway;

/**
 * This is a custom mapper class to map the result set into Runway object
 * It retrieves the result set by and map it to the right object structure  
 * 
 * @author Muthu
 *
 */
@Component
public class RunwayMapper implements RowMapper<Runway> {

  /**
   * This method maps the result set into Runway objects
   * 
   * @param rs - ResultSet
   * @param rowNum - Row Number
   * @return object - Runway Object
   */
  public Runway mapRow(ResultSet rs, int rowNum) throws SQLException {
    Runway runway = new Runway();
    runway.setAirportRef(rs.getInt("airport_ref"));
    runway.setAirportIdent(rs.getString("airport_ident"));
    runway.setSurface(rs.getString("surface"));
    return runway;
  }

}
