package pageobjects;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FileDownloadPage {
	Page page;
	
    private final Locator DOWNLOAD_BUTTON;
    
	
    public FileDownloadPage(Page page) {
        this.page = page;
        
        
        
       
        this.DOWNLOAD_BUTTON=page.locator("#file");
        
        
    }
    

    public void verifyFileDownload() {
        //Path for Downloads folder from root of project
        String downloadsDirectory = System.getProperty("user.dir") + "/Downloads/";
        // Wait for the download to start and perform the action that initiates download Lambda expression
        Download download = page.waitForDownload(this.DOWNLOAD_BUTTON::click);
        // Wait for the download process to complete
        Path path = download.path();
        // Save downloaded file in Downloads directory
        download.saveAs(Paths.get(downloadsDirectory + download.suggestedFilename()));
    }
	
}
