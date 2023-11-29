package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TagsInputBoxPage {
private Page page;
    private static int num=0;
    private final Locator TOTAL_NUMBER;
    private final Locator TAG_FIELD;
  
    

    public TagsInputBoxPage(Page page) {
        this.page = page;
        this.TOTAL_NUMBER=page.locator("//div[@class='details']//span[1]");
        this.TAG_FIELD=page.locator("//div[@class='content']//input[1]");
    }
	
    public void getTotalNumber() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String s=TOTAL_NUMBER.textContent();
    	num=Integer.parseInt(s);
    	System.out.println(num);
    }
    
    public void enterTags() {
    	String lang[]= {"Java","C#",".Net","Python","Nodejs","Ruby","COBOL","C++","C","Unix"};
    	TAG_FIELD.click();
    	for (int i=num; i>=0;i--) {
    		this.page.keyboard().insertText(lang[i]);
    		this.page.keyboard().press("Enter");
    		
    	}
    }
    
    public String getTotalNumberAfterTag() {
    	
    	
    	return TOTAL_NUMBER.textContent();
    	
    }
    
	
}
