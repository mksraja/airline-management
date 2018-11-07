package com.airline.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.airline.common.config.TestApplicationConfig;
import com.airline.vo.Runway;

@ContextConfiguration(classes = TestApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RunwayDAOTest {
  
  @Autowired
  private RunwayDAO runwayDAO;
  
  /**
   * This is the test method to verify findTopTenCommonRunways
   */
  @Test
  public void testFindTopTenCommonRunways () {
    List<Runway> runways = runwayDAO.findTopTenCommonRunways();
    Assert.assertNotNull("Top Ten Common Runways should not be Empty", runways);
    Assert.assertEquals("Result set should contains 10 records", 10, runways.size());
    String firstRunwayName = runways.get(0).getLeIdent();
    String lastRunwayName = runways.get(runways.size() - 1).getLeIdent();
    Assert.assertEquals("Top first runway name must be equal", "H1", firstRunwayName);
    Assert.assertEquals("Top ten runway name must be equal", "13", lastRunwayName);
  }
  
  /**
   * This is the test method to verify getAllRunways
   */
  @Test
  public void testGetAllRunways() {
    List<Runway> runways = runwayDAO.getAllRunways();
    Assert.assertNotNull("Runways list should not be Empty", runways);
  }


}
