package com.uiautomation.step_definitions;

import javax.sql.CommonDataSource;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.constants.Constants;
import com.uiautomation.page_objects.GoogleSample;
import com.uiautomation.utilities.CommonUtils;
import com.uiautomation.webdriver_manager.DriverManager;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static String scenarioname=null;
	
	public static String getScenarioName() {
		return scenarioname;
	}
			
			
	@Before
	public void beforeScenario(Scenario scenario)
	{
		
		try {
			scenarioname=scenario.getName();
			CommonUtils.getInstance().loadProperties();;
			
			if(DriverManager.getDriver()==null) {
			DriverManager.launchBrowser();
			CommonUtils.getInstance().initWebElements();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotTaken=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, "image/png", "failed screen");
			DriverManager.closeBrowser();
		}
	}
	
}
