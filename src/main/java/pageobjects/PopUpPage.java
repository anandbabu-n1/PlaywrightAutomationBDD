package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import utils.WebActions;

public class PopUpPage {
private Page page;
private Page popup;

    
    private final Locator OPEN_BUTTON;
    private final Locator FIRST_PAGE_MESSAGE;
    private final Locator SUBMIT_BUTTON;
  
    

    public PopUpPage(Page page) {
        this.page = page;
        this.popup = page;
        this.OPEN_BUTTON=page.locator("#login");
        this.SUBMIT_BUTTON=page.locator("//button[text()='Submit']");
        this.FIRST_PAGE_MESSAGE=page.locator("#info");
    }




	public void clickOpenButton() {
		// TODO Auto-generated method stub
		  popup = this.page.waitForPopup(() -> {
			  OPEN_BUTTON.click();
			});
		  
	}




	public void clickSubmitButtonOnPopup() {
		this.popup.locator("//button[text()='Submit']").click();
		this.popup.close();
		
	}
	
	public String getTextMessage() {
		return FIRST_PAGE_MESSAGE.textContent();
		
	}
    
	
}
