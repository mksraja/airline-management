package com.airline.vo;

import java.math.BigDecimal;

/**
 * This class represents the value object for Runway
 * It holds the properties required for Runway object
 * 
 * @author Muthu
 *
 */
public class Runway {

  private Integer id;
  private Integer airportRef;
  private String airportIdent;
  private Integer lengthFt;
  private Integer widthFt;
  private String surface;
  private Integer lighted;
  private Integer closed;
  private String leIdent;
  private BigDecimal leLatitudeDeg;
  private BigDecimal leLongtitudeDeg;
  private Integer leElevationFt;
  private BigDecimal leHeadingDegT;
  private Integer leDisplacedThresholdFt;
  private String heIdent;
  private BigDecimal heLatitudeDeg;
  private BigDecimal heLongtitudeDeg;
  private Integer heElevationFt;
  private BigDecimal heHeadingDegT;
  private Integer heDisplacedThresholdFt;
  private Integer commonIdentCnt;
  private Airport airport;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAirportRef() {
    return airportRef;
  }

  public void setAirportRef(Integer airportRef) {
    this.airportRef = airportRef;
  }

  public String getAirportIdent() {
    return airportIdent;
  }

  public void setAirportIdent(String airportIdent) {
    this.airportIdent = airportIdent;
  }

  public Integer getLengthFt() {
    return lengthFt;
  }

  public void setLengthFt(Integer lengthFt) {
    this.lengthFt = lengthFt;
  }

  public Integer getWidthFt() {
    return widthFt;
  }

  public void setWidthFt(Integer widthFt) {
    this.widthFt = widthFt;
  }

  public String getSurface() {
    return surface;
  }

  public void setSurface(String surface) {
    this.surface = surface;
  }

  public Integer getLighted() {
    return lighted;
  }

  public void setLighted(Integer lighted) {
    this.lighted = lighted;
  }

  public Integer getClosed() {
    return closed;
  }

  public void setClosed(Integer closed) {
    this.closed = closed;
  }

  public String getLeIdent() {
    return leIdent;
  }

  public void setLeIdent(String leIdent) {
    this.leIdent = leIdent;
  }

  public BigDecimal getLeLatitudeDeg() {
    return leLatitudeDeg;
  }

  public void setLeLatitudeDeg(BigDecimal leLatitudeDeg) {
    this.leLatitudeDeg = leLatitudeDeg;
  }

  public BigDecimal getLeLongtitudeDeg() {
    return leLongtitudeDeg;
  }

  public void setLeLongtitudeDeg(BigDecimal leLongtitudeDeg) {
    this.leLongtitudeDeg = leLongtitudeDeg;
  }

  public Integer getLeElevationFt() {
    return leElevationFt;
  }

  public void setLeElevationFt(Integer leElevationFt) {
    this.leElevationFt = leElevationFt;
  }

  public BigDecimal getLeHeadingDegT() {
    return leHeadingDegT;
  }

  public void setLeHeadingDegT(BigDecimal leHeadingDegT) {
    this.leHeadingDegT = leHeadingDegT;
  }

  public Integer getLeDisplacedThresholdFt() {
    return leDisplacedThresholdFt;
  }

  public void setLeDisplacedThresholdFt(Integer leDisplacedThresholdFt) {
    this.leDisplacedThresholdFt = leDisplacedThresholdFt;
  }

  public String getHeIdent() {
    return heIdent;
  }

  public void setHeIdent(String heIdent) {
    this.heIdent = heIdent;
  }

  public BigDecimal getHeLatitudeDeg() {
    return heLatitudeDeg;
  }

  public void setHeLatitudeDeg(BigDecimal heLatitudeDeg) {
    this.heLatitudeDeg = heLatitudeDeg;
  }

  public BigDecimal getHeLongtitudeDeg() {
    return heLongtitudeDeg;
  }

  public void setHeLongtitudeDeg(BigDecimal heLongtitudeDeg) {
    this.heLongtitudeDeg = heLongtitudeDeg;
  }

  public Integer getHeElevationFt() {
    return heElevationFt;
  }

  public void setHeElevationFt(Integer heElevationFt) {
    this.heElevationFt = heElevationFt;
  }

  public BigDecimal getHeHeadingDegT() {
    return heHeadingDegT;
  }

  public void setHeHeadingDegT(BigDecimal heHeadingDegT) {
    this.heHeadingDegT = heHeadingDegT;
  }

  public Integer getHeDisplacedThresholdFt() {
    return heDisplacedThresholdFt;
  }

  public void setHeDisplacedThresholdFt(Integer heDisplacedThresholdFt) {
    this.heDisplacedThresholdFt = heDisplacedThresholdFt;
  }

  public Integer getCommonIdentCnt() {
    return commonIdentCnt;
  }

  public void setCommonIdentCnt(Integer commonIdentCnt) {
    this.commonIdentCnt = commonIdentCnt;
  }

  public Airport getAirport() {
    return airport;
  }

  public void setAirport(Airport airport) {
    this.airport = airport;
  }
  
}
