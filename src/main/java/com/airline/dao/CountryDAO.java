package com.airline.dao;

import java.util.List;

import com.airline.vo.Country;


/**
 * This interface defines the methods to Create, Read, Update, Delete, View and list operations
 * on the Country table. It represents the DAO for Country 
 * 
 * @author Muthu
 *
 */
public interface CountryDAO {
  
  /**
   * This method returns all the countries stored in the country table
   * 
   * @return countryList - List of countries
   */
  public List <Country> findAll();
  
}
