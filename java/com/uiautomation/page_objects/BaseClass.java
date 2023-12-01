package com.uiautomation.page_objects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.uiautomation.webdriver_manager.DriverManager;


public class BaseClass {


	public void maximizePage() throws Exception {

		DriverManager.getDriver().manage().window().maximize();

	}

	public void back()throws Exception{
		DriverManager.getDriver().navigate().back();
	}

	public void refreshPage() throws InterruptedException {

		DriverManager.getDriver().navigate().refresh();
	}

	public void openSpecificURL(String url) throws InterruptedException {

		DriverManager.getDriver().get(url);
		
	}
	
	public void switchToNewWindow() {
	    for (String winHandle: DriverManager.getDriver().getWindowHandles()) {
	    	DriverManager.getDriver().switchTo().window(winHandle);
	    }
	  }

	  public String getParentWindow() {
	    return DriverManager.getDriver().getWindowHandle();
	  }

	  public void switchToParentWindow(String windowHandle) {
		  DriverManager.getDriver().switchTo().window(windowHandle);
	  }

	  public void switchToIFrame(WebElement element) {
		  DriverManager.getDriver().switchTo().frame(element);
	  }


	public void switchControlToNewTab() throws InterruptedException {

		for (String winHandle: DriverManager.getDriver().getWindowHandles()) {
			DriverManager.getDriver().switchTo().window(winHandle);
		}
	}

	public FluentWait < WebDriver > waitDriver(long millis) {

		FluentWait < WebDriver > waitDriver = new FluentWait < WebDriver > (DriverManager.getDriver());

		waitDriver.withTimeout(Duration.ofMillis(millis));
		waitDriver.pollingEvery(Duration.ofMillis(100));
		waitDriver.ignoring(Exception.class);

		return waitDriver;

	}

	public void fluentClick(WebElement elem) {

		WebElement mb = waitDriver(20000).until(ExpectedConditions.visibilityOf(elem));

		mb.click();

	}



	public  void click(WebElement element) throws Exception {

		element.click();

	}
	
	public void actionClick(WebElement element) throws Exception {

	    Actions action = new Actions(DriverManager.getDriver());
	    action.moveToElement(element).click().perform();
	  }

	public void javascriptClick(WebElement element) throws Exception {
	    
	      ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	      ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);
	    
	  }


	public String getPageTitle() throws Exception {

		return DriverManager.getDriver().getTitle();

	}

	public void clearField(WebElement element) throws Exception {
		//waitForVisibilityOfElement(element);

		element.clear();

	}


	public void switchWindow(String currentHandle)throws Exception{

		DriverManager.getDriver().switchTo().window(currentHandle);

	}

	public void closeCurrentWindow(String currentHandle)throws Exception{
		DriverManager.getDriver().close(); // Close WINDOW_TITLE page or do other things
		DriverManager.getDriver().switchTo().window(currentHandle);
	}

	public String switchToWindowByTitle(String windowTitle) throws Exception {
		Set<String> handles = DriverManager.getDriver().getWindowHandles();
		String currentHandle = DriverManager.getDriver().getWindowHandle();
		for (String handle : handles) {
			DriverManager.getDriver().switchTo().window(handle);
			if (windowTitle.equalsIgnoreCase(DriverManager.getDriver().getTitle())) {
				break;
			}
		}
		return currentHandle;
	}

	public boolean isElementPresent(WebElement we) throws Exception {

		return we.isDisplayed();

	}

	public Boolean isDisplayed(WebElement element) throws Exception {
	    
	      return element.isDisplayed();
	    
	  }


}
