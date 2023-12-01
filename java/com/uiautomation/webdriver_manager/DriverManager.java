package com.uiautomation.webdriver_manager;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.uiautomation.constants.Constants;
import com.uiautomation.page_objects.GoogleSample;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static Logger log = LogManager.getLogger(DriverManager.class);
	private static WebDriver driver=null;
	
	private static DriverManager DriverManagerinstance;
	

	private DriverManager() {
		
	}
	
	public static DriverManager getInstance() {
		if(DriverManagerinstance==null) {
			DriverManagerinstance = new DriverManager();
		}
		return DriverManagerinstance;
	}
	
	public static void launchBrowser() {
		try {
			switch(Constants.browsername) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				log.info("Chrome browser is launched successfully");
				driver = new ChromeDriver();
				break;
			
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				log.info("Firefox browser is launched successfully");
				driver = new FirefoxDriver();
				break;
				
			case "ie":
				WebDriverManager.iedriver().setup();
				log.info("Internet explorer browser is launched successfully");
				driver = new InternetExplorerDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				log.info("Edge browser is launched successfully");
				driver = new EdgeDriver();
				break;
			
			default:
				WebDriverManager.chromedriver().setup();
				log.info("Chrome browser is launched successfully");
				driver = new ChromeDriver();
			}
		}
		catch(Exception e){
			log.info("Error launching the browser");
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void closeBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public static void openApp() {
		DriverManager.getDriver().get(Constants.appurl);
		
	}

}
