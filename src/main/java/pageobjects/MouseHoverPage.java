package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MouseHoverPage {
private Page page;


    
    private final Locator POSTER;
    private final Locator POSTER_PRICE;
  
    

    public MouseHoverPage(Page page) {
        this.page = page;
       
        this.POSTER=page.locator("//div[@class='poster-container']//img[1]");
        this.POSTER_PRICE=page.locator("(//div[@class='title-content']//p)[2]");
        
    }




	public void MouseHover() {
		POSTER.hover();
	}
	
	public void GetPosterPrice() {
		System.out.println(POSTER_PRICE.textContent());
	}
    
	
}
