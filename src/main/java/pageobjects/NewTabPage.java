package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.WebActions;

public class NewTabPage {
private Page page;
private Page popup;

    
    private final Locator OPEN_NEW_TAB;
    private final Locator NEW_TAB_TEXT;
  
    

    public NewTabPage(Page page) {
        this.page = page;
        this.popup = page;
        this.OPEN_NEW_TAB=page.locator("#open");
        this.NEW_TAB_TEXT=page.locator("//div[@id='wrapper']//h1[1]");
    }




	public void clickNewTabButton() {
		// TODO Auto-generated method stub
		  popup = this.page.waitForPopup(() -> {
			 OPEN_NEW_TAB.click();
			});
		  
	}




	public String getTextNewPage() {
		String message=this.popup.locator("//div[@id='wrapper']//h1[1]").textContent();
		this.popup.close();
		return message;
	}
	
    
    
	
}
