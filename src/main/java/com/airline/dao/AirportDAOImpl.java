package com.airline.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.airline.dao.mapper.AirportResultExtractor;
import com.airline.vo.Airport;

/**
 * This is an implementation class for the operations defines in AirportDAO interface
 * This class obtains the JdbcTemplate through Spring runtime dependency injection
 * and uses it to get the connection from the database and executes necessary db operations 
 * 
 * @author Muthu
 *
 */
@Repository
@Qualifier("airportDAO")
public class AirportDAOImpl implements AirportDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Autowired
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
  @Autowired
  private AirportResultExtractor airportResultExtractor;


  /**
   * This method returns the top ten highest airports and its country name
   * 
   * @return airportList - Airports List
   */
  @Override
  public List<Airport> getTopTenHighestAirports() {
    String query =
        "select a.id, a.ident, a.iso_country, c.name as country_name, count(a.iso_country) country_cnt from test_schema.airport a, "
            + "test_schema.country c where a.iso_country = c.code group by iso_country order by country_cnt desc limit 0, 10";
    return jdbcTemplate.query(query, new BeanPropertyRowMapper(Airport.class));
  }



  /**
   * This method returns the top ten lowest airports and its country name
   * 
   * @return airportList - Airports List
   */
  @Override
  public List<Airport> getTopTenLowestAirports() {
    String query =
        "select a.id, a.ident, a.iso_country, c.name as country_name, count(a.iso_country) country_cnt from test_schema.airport a, "
            + "test_schema.country c where a.iso_country = c.code group by iso_country order by country_cnt asc limit 0, 10";
    return jdbcTemplate.query(query, new BeanPropertyRowMapper(Airport.class));
  }


  /**
   * This method returns all the airports and runways present in the matching countries
   * It searches the list of countries by country code or country name
   * 
   * 
   * @param counrtyCode - Country Code
   * @param countryName - Country Name
   * @return airportList - List of Airports
   */
  public List<Airport> findAllAirportsByCountry(String countryCode, String countryName) {
    StringBuilder query =
        new StringBuilder("select a.iso_country, c.name as country_name, a.id, a.ident, a.type, ")
            .append("r.airport_ref, r.airport_ident, r.surface from test_schema.country c, test_schema.airport a, test_schema.runway r ")
            .append("where c.code = a.iso_country and r.airport_ref = a.id");
    Map<String, Object> params = new HashMap<String, Object>();
    if (!countryCode.isEmpty() || !countryName.isEmpty()) {
      query.append(" and (");
    }
    if (!countryCode.isEmpty()) {
      query.append(" a.iso_country like :countryCode");
      params.put("countryCode", countryCode);
    }
    if (!countryCode.isEmpty() && !countryName.isEmpty()) {
      query.append(" or ");
    }
    if (!countryName.isEmpty()) {
      query.append(" c.name like :countryName");
      params.put("countryName", "%" + countryName + "%");
    }
    if (!countryCode.isEmpty() || !countryName.isEmpty()) {
      query.append(" )");
    }
    query.append(" order by a.iso_country");
    List<Airport> airportList = namedParameterJdbcTemplate.query(query.toString(), params, airportResultExtractor); 
    return airportList;
  }


}
