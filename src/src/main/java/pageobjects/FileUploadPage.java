package pageobjects;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FileUploadPage {
	Page page;
	
    private final Locator DOWNLOAD_BUTTON;
    private final Locator UPLOAD_BUTTON;
	
    public FileUploadPage(Page page) {
        this.page = page;
        
        
        
       
        this.DOWNLOAD_BUTTON=page.locator(null);
        this.UPLOAD_BUTTON=page.locator("//input[@type='file']");
        
    }
    public void performFileUpload(String fileName) {
        String uploadFilePath = System.getProperty("user.dir") + "/src/main/java/utils/functional/" + fileName+".png";
        System.out.println(uploadFilePath);
        UPLOAD_BUTTON.setInputFiles(Paths.get(uploadFilePath));
    }

    public boolean verifyFileUpload(String fileName) {
        return this.page.getByText(fileName).isVisible();
    }
	
}
