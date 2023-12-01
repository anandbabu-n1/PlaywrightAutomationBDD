package com.uiautomation.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.constants.Constants;
import com.uiautomation.page_objects.GoogleSample;
import com.uiautomation.step_definitions.Hooks;
import com.uiautomation.webdriver_manager.DriverManager;

public class CommonUtils {
	private static CommonUtils CommonUtilsinstance;

	private CommonUtils() {
		
	}
	
	public static CommonUtils getInstance() {
		if(CommonUtilsinstance==null) {
			CommonUtilsinstance = new CommonUtils();
		}
		return CommonUtilsinstance;
	}
	
	public  void loadProperties() {
		FileReader reader=null;
		
		
		Properties properties= new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Constants.appurl=properties.getProperty("app_url");
		Constants.browsername=properties.getProperty("browsername");
	}

	public void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), GoogleSample.getInstance());
	}
	
	public void takeScreenshot() {
		File screenshot =((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File(Hooks.getScenarioName() + ".png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}

