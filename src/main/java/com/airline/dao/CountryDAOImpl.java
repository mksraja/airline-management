package com.airline.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.airline.vo.Country;

/**
 * This is an implementation class for the operations defines in CountryDAO interface
 * This class obtains the JdbcTemplate through Spring runtime dependency injection
 * and uses it to get the connection from the database and executes necessary db operations 
 * 
 * @author Muthu
 *
 */
@Repository
@Qualifier("countryDAO")
public class CountryDAOImpl implements CountryDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * This method returns all the countries stored in the country table
   * 
   * @return countryList - List of countries
   */
  @Override
  public List<Country> findAll() {
    return jdbcTemplate.query("select id, code, name, wikipedia_link, keywords from country",
        new BeanPropertyRowMapper(Country.class));
  }

}
