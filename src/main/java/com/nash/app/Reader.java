package com.nash.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Reader {

	/**
	 * @param args
	 */
	private final static Map<String, String> map= new HashMap<String, String>();
	private final static String RELATIVEPATH = "/resource/";
	private final static String FILENAME="URLMap.properties";
	public Reader() {
	}
	
	
	public String getProperty(String key) throws IOException, RuntimeException{
		if(map.isEmpty()){
			readIntoMap();
		}
		if(map.get(key)==null){
			throw new RuntimeException("Key["+key+"] not exist in Property file!");
		}
		return map.get(key);
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
	public boolean isPropertiesFileExist(){
		File f=new File(getFileAbsolutePath());
		return f.exists();
	}
	
	public void readIntoMap() throws IOException{
	  if(!isPropertiesFileExist()){
		throw new RuntimeException("Please check your file in directory: "+ getFileAbsolutePath());  
	   }
	   BufferedReader br=new BufferedReader(new FileReader(new File(getFileAbsolutePath())));
	   String str = null;
	   while((str=br.readLine())!=null){
	   	 String[] arr = str.split("=",2);
	   	 String key = arr[0];
	   	 String value =arr[1];
	   	 if(!map.containsKey(key)){
	   		 map.put(key, value);
	   	 }
	   }
	}	
}
