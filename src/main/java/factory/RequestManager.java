package factory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class RequestManager {

    private static  RequestManager RequestManager;
	private Playwright playwright;
    private static APIRequestContext apiRequestContext;
    private static APIResponse apiresponse;
    
    public RequestManager() {
    	
    }
    public static RequestManager getInstance() {
		if(RequestManager==null) {
			RequestManager = new RequestManager();
		}
		return RequestManager;
	}
    
    public void createPlaywright() {
        this.playwright = Playwright.create();

    }

    public void setApiRequestContext(final String baseUrl, final Map<String, String> headers) {
        apiRequestContext = this.playwright.request()
                .newContext(new APIRequest.NewContextOptions().setBaseURL(baseUrl)
                        .setExtraHTTPHeaders(headers));
       // System.out.println(apiRequestContext.get("/public/v2/users").status());

    }

    public APIResponse getRequest(final String endpoint) {
    	apiresponse=apiRequestContext.get(endpoint);
    	return apiresponse;
    }

    public APIResponse getRequest(final String endpoint, final RequestOptions options) {
        return apiRequestContext.get(endpoint, options);
    }

    public APIResponse postRequest(final String endpoint) {
        return apiRequestContext.post(endpoint);
    }

    public APIResponse postRequest(final String endpoint, final RequestOptions options) {
        apiresponse= apiRequestContext.post(endpoint, options);
         return apiresponse;
    }

    public APIResponse putRequest(final String endpoint) {
        return apiRequestContext.put(endpoint);
    }

    public APIResponse putRequest(final String endpoint, final RequestOptions options) {
         apiresponse=apiRequestContext.put(endpoint, options);
         return apiresponse;
    }

    public APIResponse patchRequest(final String endpoint) {
        return apiRequestContext.patch(endpoint);
    }

    public APIResponse patchRequest(final String endpoint, final RequestOptions options) {
         apiresponse=apiRequestContext.patch(endpoint, options);
         return apiresponse;

    }

    public APIResponse deleteRequest(final String endpoint) {
        return apiRequestContext.delete(endpoint);
    }

    public APIResponse deleteRequest(final String endpoint, final RequestOptions options) {
         apiresponse=apiRequestContext.delete(endpoint, options);
         return apiresponse;
    }

    public void disposeAPIRequestContext() {
        apiRequestContext.dispose();
    }
    
    public void disposeAPIResponse() {
		apiresponse.dispose();
		
	}
    
    public String getResponseBody() throws IOException {
    	ObjectMapper objectmapper= new ObjectMapper();
    	JsonNode  jsonResponse= objectmapper.readTree(apiresponse.body());
		String jsonPrettyResponse = jsonResponse.toPrettyString();
    	
    	return jsonPrettyResponse;
    	
    }
    
    public Map<String, Object> userData(String name, String job){
    	Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", name );
		data.put("job", job );
		return data;
    }

    public void closePlaywright() {
        this.playwright.close();
    }
	

}
