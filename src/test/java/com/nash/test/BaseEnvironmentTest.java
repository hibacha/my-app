package com.nash.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

@ContextConfiguration(locations = { "/context-test.xml" })
public class BaseEnvironmentTest extends AbstractTestNGSpringContextTests {
	private final static String BASE_VERSION = "1.6.0";

	@BeforeSuite
	public void testJVMVersion() {
		String version = System.getProperty("java.version");
		Assert.assertTrue(version.startsWith(BASE_VERSION));
	}

	@BeforeSuite
	public void testDB() throws ClassNotFoundException, SQLException {
		Properties prop  = loadPropertiesFile();
		String url = prop.getProperty("url");
		String dbuser = prop.getProperty("dbuser");
		String dbpassword = prop.getProperty("dbpassword");
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection(
				url,dbuser,dbpassword);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select now()");
		Timestamp timestamp =null;
		while(rs.next()){
			 timestamp = rs.getTimestamp("now");
		}
		Assert.assertNotNull(timestamp);
	}

	private Properties loadPropertiesFile() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "dbConnection.properties";
			input = BaseEnvironmentTest.class.getClassLoader()
					.getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				throw new FileNotFoundException();
			}

			// load a properties file from class path, inside static method
			prop.load(input);
			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;

	}

}
