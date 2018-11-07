package com.airline.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.airline.common.config.TestApplicationConfig;
import com.airline.dao.RunwayDAO;
import com.airline.vo.Runway;


/**
 * This is the test class to verify the functionalities in Runway Service
 * 
 * @author Muthu
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestApplicationConfig.class})
public class RunwayServiceTest {

  @InjectMocks
  RunwayServiceImpl runwayService;

  @Mock
  private RunwayDAO runwayDAO;

  /**
   * This is the test method to verify different types of runways
   */
  @Test
  public void testGetTypeOfRunways() {
    when(runwayDAO.getAllRunways()).thenReturn(getRunwayTypes());
    List<Runway> runwayTypes = runwayService.getTypeOfRunways();
    assertNotNull("Runway types should not be Null", runwayTypes);
    assertEquals("The list of runway types should be equal", 3, runwayTypes.size());
  }

  
  /**
   * This is the test method to verify top ten common runways
   */
  @Test
  public void testGetCommonRunways() {
    when(runwayDAO.findTopTenCommonRunways()).thenReturn(getCommonRunways());
    List<Runway> commonRunways = runwayService.getCommonRunways();
    assertNotNull("Runway types should not be Null", commonRunways);
    assertEquals("The list should contains Top 10 common runways", 10, commonRunways.size());
  }

  /**
   * This method returns the mocked list of runway types
   * 
   * @return list - Runway list
   */
  private List<Runway> getRunwayTypes() {
    List<Runway> runwayList = new ArrayList<Runway>();
    Runway runway1 = createMockRunway("00A", "H1");
    Runway runway2 = createMockRunway("00AK", "N");
    Runway runway3 = createMockRunway("00IS", "E");
    runwayList.add(runway1);
    runwayList.add(runway2);
    runwayList.add(runway3);
    return runwayList;
  }

  /**
   * This method returns the mocked list of common runways
   * 
   * @return list - Runway list
   */
  private List<Runway> getCommonRunways() {
    List<Runway> runwayList = new ArrayList<Runway>();
    Runway runway = null;
    for (int i = 1; i <= 10; i++) {
      runway = createMockRunway("00A" + i, "H1");
      runway.setId(i);
      runwayList.add(runway);
    }
    return runwayList;
  }

  /**
   * This method creates and returns mocked runway
   * 
   * @param ident - Airport Ident
   * @param surface - Surface
   * @return runway - Runway
   */
  private Runway createMockRunway(String ident, String surface) {
    Runway runway = new Runway();
    runway.setAirportIdent(ident);
    runway.setSurface(surface);
    return runway;
  }

}
