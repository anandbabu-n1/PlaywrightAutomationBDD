package apihooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import factory.RequestManager;
import utilities.WebActions;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ApiHooks {
    public DriverFactory driverFactory;
    public Page page;
    public RequestManager manager;
    
    
    @Before
    public void setupBase() {
    	final String baseUrl = WebActions.getProperty("apibaseurl");
        this.manager = new RequestManager();
        this.manager.createPlaywright();
        final Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("Accept", "application/json");
        this.manager.setApiRequestContext(baseUrl, headers);
    }

    //After runs in reverse order so order=1 will run first
    @After
    public void tearDown() {
        this.manager.disposeAPIRequestContext();
       // this.manager.disposeAPIResponse();
        this.manager.closePlaywright();
    }


}
