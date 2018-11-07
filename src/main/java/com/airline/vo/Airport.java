package com.airline.vo;

import java.math.BigDecimal;
import java.util.Set;

/**
 * This class represents the value object for Airport
 * It holds the properties required for Airport object
 * Airport contains list of runways operated in the Airport
 * 
 * @author Muthu
 *
 */
public class Airport {

  Integer id;
  private String ident;
  private String type;
  private String name;
  private BigDecimal latitudeDeg;
  private BigDecimal longtitudeDeg;
  private Integer elevationFt;
  private String continent;
  private String isoCountry;
  private String isoRegion;
  private String municipality;
  private Integer scheduledService;
  private String gpsCode;
  private String iataCode;
  private String localCode;
  private String homeLink;
  private String wikipediaLink;
  private String keywords;
  private String countryName;
  private Set<Runway> runways;
  private Integer countryCnt;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIdent() {
    return ident;
  }

  public void setIdent(String ident) {
    this.ident = ident;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getLatitudeDeg() {
    return latitudeDeg;
  }

  public void setLatitudeDeg(BigDecimal latitudeDeg) {
    this.latitudeDeg = latitudeDeg;
  }

  public BigDecimal getLongtitudeDeg() {
    return longtitudeDeg;
  }

  public void setLongtitudeDeg(BigDecimal longtitudeDeg) {
    this.longtitudeDeg = longtitudeDeg;
  }

  public Integer getElevationFt() {
    return elevationFt;
  }

  public void setElevationFt(Integer elevationFt) {
    this.elevationFt = elevationFt;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getIsoCountry() {
    return isoCountry;
  }

  public void setIsoCountry(String isoCountry) {
    this.isoCountry = isoCountry;
  }

  public String getIsoRegion() {
    return isoRegion;
  }

  public void setIsoRegion(String isoRegion) {
    this.isoRegion = isoRegion;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

  public Integer getScheduledService() {
    return scheduledService;
  }

  public void setScheduledService(Integer scheduledService) {
    this.scheduledService = scheduledService;
  }

  public String getGpsCode() {
    return gpsCode;
  }

  public void setGpsCode(String gpsCode) {
    this.gpsCode = gpsCode;
  }

  public String getIataCode() {
    return iataCode;
  }

  public void setIataCode(String iataCode) {
    this.iataCode = iataCode;
  }

  public String getLocalCode() {
    return localCode;
  }

  public void setLocalCode(String localCode) {
    this.localCode = localCode;
  }

  public String getHomeLink() {
    return homeLink;
  }

  public void setHomeLink(String homeLink) {
    this.homeLink = homeLink;
  }

  public String getWikipediaLink() {
    return wikipediaLink;
  }

  public void setWikipediaLink(String wikipediaLink) {
    this.wikipediaLink = wikipediaLink;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public Set<Runway> getRunways() {
    return runways;
  }

  public void setRunways(Set<Runway> runways) {
    this.runways = runways;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Integer getCountryCnt() {
    return countryCnt;
  }

  public void setCountryCnt(Integer countryCnt) {
    this.countryCnt = countryCnt;
  }
  
}
