package pageobjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import lombok.Builder;
import utilities.WebActions;

public class QrCodePage {
	
	private Page page;
	
	private final Locator INPUT_FIELD;
	private final Locator BUTTON;
	private final Locator QR_IMAGE;
	private static String urls="";
    

    public QrCodePage(Page page) {
        this.page = page;
        this.INPUT_FIELD=page.locator("//input[@placeholder='Enter text or URL']");
        this.BUTTON=page.locator("//button[text()='Generate QR Code']");
        this.QR_IMAGE=page.locator("//img[@alt='qr-code']");
    }
    
    public void enterText(String text) throws Exception {
    	INPUT_FIELD.fill(text);
    	//this.page.keyboard().insertText(text);
    	Thread.sleep(2000);
    	BUTTON.click();
    	System.out.println(QR_IMAGE.getAttribute("src"));
    	urls=QR_IMAGE.getAttribute("src");
    	
    	
    	
    }

	public void downloadQR(String filename) throws Exception, IOException {
		// TODO Auto-generated method stub
		
		File dir = new File("target/qrsnaps");
    	dir.mkdir();
    	
    	Path output= Paths.get("target/qrsnaps/"+filename+".png");
    	try (InputStream inputStream = new URL(urls).openStream()){
    		
			Files.copy(inputStream, output, StandardCopyOption.REPLACE_EXISTING);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
	}

	public String validateQR(String filename) throws IOException, Exception {
		return WebActions.validateQRFromFile(filename);
		
	
	}
	
	
}
