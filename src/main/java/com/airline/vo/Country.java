package com.airline.vo;

/**
 * This class represents the value object for Country
 * It contains the properties required for the country
 * 
 * @author Muthu
 *
 */
public class Country {

  private Integer id;
  private String code;
  private String name;
  private String wikipedialink;
  private String keywords;

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

  public String getWikipedialink() {
    return wikipedialink;
  }

  public void setWikipedialink(String wikipedialink) {
    this.wikipedialink = wikipedialink;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

}
