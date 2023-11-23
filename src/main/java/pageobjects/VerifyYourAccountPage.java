package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VerifyYourAccountPage {
	private Page page;
	private static String confirmationcode="";
	private final Locator CONFIRMATION_CODE;
	private final Locator SUCCESS_MESSAGE;
	
	public VerifyYourAccountPage(Page page) {
		this.page = page;
		this.CONFIRMATION_CODE=page.locator("//div[@class='container']//small[1]");
		this.SUCCESS_MESSAGE=page.locator("small.info.success");
	}

	public void getConfirmationCode() {
		
		confirmationcode =CONFIRMATION_CODE.textContent();
		confirmationcode= confirmationcode.replaceAll("-", "");
		confirmationcode= confirmationcode.replaceAll("\\D", "");
		System.out.println(confirmationcode);
	}
	
	public void enterConfirmationCode() {
		for(int i=0 ;i <confirmationcode.length(); i++)
		{
			
			String xpath="(//input[@class='code'])["+(i+1)+"]";
			String s=Character.toString(confirmationcode.charAt(i));
			this.page.locator(xpath).click();
			this.page.locator(xpath).clear();
			this.page.keyboard().press(s);
			
		}
	}
	
	public String getMessage() {
		
		
		return SUCCESS_MESSAGE.textContent();
		
	}
}
