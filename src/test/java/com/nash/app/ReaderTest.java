package com.nash.app;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class ReaderTest {

  private Reader reader=null;
  @BeforeSuite
  public void setUp(){
	  reader = new Reader();
  }
  @Test
  public void checkPropertyValue() throws IOException {
	  String value = reader.getProperty("MEGA_BUS_NY_TO_BOS_APR_27_2014");
	  assertEquals(value, "https://us.megabus.com/JourneyResults.aspx?originCode=123&destinationCode=94&outboundDepartureDate=4%2f27%2f2014&inboundDepartureDate=&passengerCount=1&transportType=0&concessionCount=0&nusCount=0&outboundWheelchairSeated=0&outboundOtherDisabilityCount=0&inboundWheelchairSeated=0&inboundOtherDisabilityCount=0&outboundPcaCount=0&inboundPcaCount=0&promotionCode=&withReturn=0");
	  
	  
  }

  @Test
  public void getFileAbsolutePath(){
	Assert.assertEquals(reader.getFileAbsolutePath(), "/Users/zhouyf/workspace/my-app/resource/URLMap.properties");
  }
  
  @Test
  public void getWorkingDir() {
    String workDir = reader.getWorkingDir();
    Assert.assertEquals(workDir, "/Users/zhouyf/workspace/my-app");
  }
}
