package pageobjects;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;

import utilities.WebActions;

public class IndexPage {
    private Page page;
    private String fileName;
    private static PDDocument pdDocument;
    
    private final Locator DYNAMIC_TABLE;
    private final Locator ACCOUNT_VERIFICATION;
    private final Locator TAGS_INPUT_BOX;
    private final Locator NEW_TAB;
    private final Locator POPUP;
    private final Locator UPLOAD_FILE;
    private final Locator DOWNLOAD_FILE;
    private final Locator DOWNLOAD_BUTTON;
    private final Locator UPLOAD_BUTTON;
    private final Locator MOUSE_HOVER;
    private final Locator Iframe;
    

    public IndexPage(Page page) {
        this.page = page;
        
        //delete locators above after imp
        this.DYNAMIC_TABLE=page.locator("(//div[@class='text-center'])[1]");
        this.ACCOUNT_VERIFICATION=page.locator("(//div[@class='text-center'])[2]");
        this.TAGS_INPUT_BOX=page.locator("(//div[@class='text-center'])[3]")	;		
        this.NEW_TAB=page.locator("(//div[@class='text-center'])[6]");
        this.POPUP=page.locator("//h3[text()='Pop-Up Window']");
        this.UPLOAD_FILE=page.locator("//h3[text()='Upload File']");
        this.DOWNLOAD_FILE=page.locator("//h3[text()='Download File']");
        this.MOUSE_HOVER=page.locator("//h3[text()='Mouse Hover']");
        this.Iframe=page.locator("//h3[text()='Nested Iframe']");
        this.DOWNLOAD_BUTTON=page.locator(null);
        this.UPLOAD_BUTTON=page.locator(null);
        
    }
    public void navigateToUrl(String url) {
        this.page.navigate(WebActions.getProperty(url));
    }
    
    public void navigateToPdfUrl(String filePath) throws IOException {
        //String fileName = System.getProperty("user.dir") + "\\src\\main\\java\\utils\\functional\\" + filePath + ".pdf";
        fileName="https://www.africau.edu/images/default/sample.pdf";
    	System.out.println(fileName);
    	this.page.navigate(fileName);
    	
    }
    
    public void getpdfTotalPages() throws IOException {
    	URL pdfUrl= new URL(fileName);
    	InputStream ip= pdfUrl.openStream();
    	BufferedInputStream bf= new BufferedInputStream(ip);
    	
    	pdDocument =PDDocument.load(bf);
    	System.out.println(pdDocument.getNumberOfPages());
    }
    
    public void getPdfText() throws IOException {
    	PDFTextStripper pdfStripper= new PDFTextStripper();
    	String pdfText =pdfStripper.getText(pdDocument);
    	System.out.println(pdfText);
    	
    }
    
    public void clickDynamicTable() {
    	DYNAMIC_TABLE.click();
    }
    
    public void clickVerifyYourAccount() {
    	ACCOUNT_VERIFICATION.click();
	}
    
    public void clickTagsInputBox() {
    	TAGS_INPUT_BOX.click();
    }
    
    public void clickNewTab() {
    	NEW_TAB.click();
    }
    
    public void clickPopUp() {
    	POPUP.click();
    	
    }
    
    public void clickUploadFile() {
		// TODO Auto-generated method stub
		UPLOAD_FILE.click();
	}
    public void clickDownloadFile() {
		DOWNLOAD_FILE.click();
		
	}

    public void clickMouseHover() {
		// TODO Auto-generated method stub
		MOUSE_HOVER.click();
	}
    
    public void clickIframe() {
		// TODO Auto-generated method stub
		Iframe.click();
	}

    public void clickOnIcon(String iconName) {
        this.page.getByText(iconName, new Page.GetByTextOptions().setExact(true)).click();  // Clicks on the Exact text
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
