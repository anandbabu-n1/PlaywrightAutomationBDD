package pageobjects;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.WebActions;

public class IframePage {
private Page page;


    
    private final FrameLocator IFRAME1;
    private final FrameLocator IFRAME2;
    private final Locator BUTTON;
    

    public IframePage(Page page) {
        this.page = page;
       
        this.IFRAME1=page.frameLocator("#frame1");
        this.IFRAME2=page.frameLocator("#frame2");
        this.BUTTON=page.locator("//a[contains(text(),'Click Me')]");
        
    }




	public void getInsideIframe() {
		   FrameLocator nestedSecondFrame= IFRAME1.frameLocator("#frame2");
		   Locator Button=nestedSecondFrame.locator("//a[contains(text(),'Click Me')]");
		   Button.click();
	}
	
	
    
	
}
