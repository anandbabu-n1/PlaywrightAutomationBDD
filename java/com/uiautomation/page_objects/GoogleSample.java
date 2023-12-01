package com.uiautomation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.uiautomation.step_definitions.GoogleSampleStepDefinition;
import com.uiautomation.utilities.CommonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.junit.Assert;

public class GoogleSample extends BaseClass {
	private static GoogleSample Googleinstance;
	private static Logger log = LogManager.getLogger(GoogleSample.class);

	private GoogleSample() {
		
	}
	
	public static GoogleSample getInstance() {
		if(Googleinstance==null) {
			Googleinstance = new GoogleSample();
		}
		return Googleinstance;
	}
	
	@FindBy(xpath = "//*[@id=\"APjFqb\"]")
	public  WebElement searchbar;
	

	@FindBy(xpath = "//*[@id=\"Alh6id\"]/div[1]/div/ul/li[1]")
	public  WebElement firsttrendingsearch;

	
	
	public void clickSearchBar() {
		try {
			click(searchbar);
			//searchbar.click();
			log.info("Search bar clicked");
		}
		catch(Exception e){
			log.error("Search bar not clicked");
			Assert.fail(e.getMessage());
		}
	}

	public void getFirsttrendingsearch() {
		// TODO Auto-generated method stub
		try {
			
			log.info(firsttrendingsearch.getText());
		}
		catch(Exception e){
			log.error("Search bar not clicked");
			//CommonUtils.getInstance().takeScreenshot();
			Assert.fail(e.getMessage());
		}
	
	}
	
	
	
	
}
