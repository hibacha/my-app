package com.nash.app;


public class Reader {

	/**
	 * @param args
	 */
	private final static String RELATIVEPATH = "/resource/";
	private final static String FILENAME="URLMap.properties";
	public Reader() {
		// TODO Auto-generated constructor stub
	}

	public String getWorkingDir(){
		String workingDir = System.getProperty("user.dir");
		return workingDir;
		
	}
	public String getFileAbsolutePath(){
		StringBuilder sb=new StringBuilder();
		sb.append(getWorkingDir()).append(RELATIVEPATH).append(FILENAME);
		return sb.toString();
	}
	public boolean checkPropertiesFile(){
		
		//File f=new File()
		return false;
	}
}
