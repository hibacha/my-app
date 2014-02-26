package com.nash.app;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ReaderTest {

  private Reader reader=null;
  @BeforeSuite
  public void setUp(){
	  reader = new Reader();
  }
  @Test
  public void checkPropertiesFile() {
    throw new RuntimeException("Test not implemented");
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
