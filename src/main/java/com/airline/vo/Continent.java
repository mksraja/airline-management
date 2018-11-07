package com.airline.vo;

import java.util.Set;

/**
 * This class represents the value object for Continent
 * It holds the properties required for Continent object
 * Continent contains multiple countries inside
 * 
 * @author Muthu
 *
 */
public class Continent {

  private Integer id;
  private String code;
  private String name;
  private Set<Country> countries;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Country> getCountries() {
    return countries;
  }

  public void setCountries(Set<Country> countries) {
    this.countries = countries;
  }


}
