package com.airline.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.airline.dao.mapper.RunwayAirportMapper;
import com.airline.vo.Runway;

/**
 * This is an implementation class for the operations defines in RunwayDAO interface
 * This class obtains the JdbcTemplate through Spring runtime dependency injection
 * and uses it to get the connection from the database and executes necessary db operations 
 * 
 * @author Muthu
 *
 */
@Repository
@Qualifier("runwayDAO")
public class RunwayDAOImpl implements RunwayDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method is used to retrieve and returns the top 10 most commonly used runways
   * It finds the top 10 runways based on the number of identifications used across the airport 
   * 
   * @return runwayList - Returns the Top Ten Runways
   */
  @Override
  public List<Runway> findTopTenCommonRunways() {
    String query = "select r.le_ident, count(r.le_ident) commonIdentCnt from test_schema.runway r "
        + "group by r.le_ident order by commonIdentCnt desc limit 0, 10";
    return jdbcTemplate.query(query, new BeanPropertyRowMapper(Runway.class));
  }

  /**
   * This method returns all airports available in each country
   * Each Airport will contain list of runways available in the Airport
   * 
   * @return airportList - Airports with Runways
   */
  @Override
  public List<Runway> getAllRunways() {
    String query =
        "select distinct r.surface, a.iso_country, c.name as country from test_schema.runway r, "
            + "test_schema.airport a, test_schema.country c where r.airport_ref = a.id and a.iso_country = c.code"
            + " and r.surface is not null";
    return jdbcTemplate.query(query, new RunwayAirportMapper());
  }

}
