package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	public static Properties pro;
	
	public ConfigDataProvider()
	{
		File file = new File("./PropertiesFile/Configuration.properties");
		
		try
		{
		FileInputStream fis = new FileInputStream(file);

		pro = new Properties();
		
		pro.load(fis);
		}
		catch(IOException e)
		{
			System.out.println("Requested configuration file is not found:" + e.getMessage());
		}
		
		
	}
	
	public static String getDataFromConfigFile(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	
	

}
