package pageobjects;

import com.microsoft.playwright.Page;

public class DynamicTablePage {
	
	 private Page page;
	public DynamicTablePage(Page page) {
		this.page = page;
		//this.SPIDER_MAN=page.locator("//div[text()='Spider-Man']//ancestor::td//following-sibling::td[2]//span");

	}


	public String getName(String name) {
		String xpath ="//div[text()='"+name+"']//ancestor::td//following-sibling::td[2]//span";
		
		return this.page.locator(xpath).textContent();
	}
}
