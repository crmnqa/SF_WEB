package ACS_CRMN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UtilitiesBaseClass {

	public String emailid()
	
	{
				
		String email1 = "websel";
		String email2 = "@zaqwsx.com" ;
		return email1 + date() + email2 ;
		
	}
	
	public String date()
	
	{
		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);
		
	}
	
	
	
	  
	  public static String restful(String content, String endpoint) {
			  
			  Client client = new Client();
			   WebResource resource = client.resource(endpoint);
			    
			 		   ClientResponse response =
			 		   resource.header("X-NI-signatureType", "2")
			 		  .header("X-NI-apiVersion", "1")
			 		  .header("X-NI-signatureHash", "dummy") 
			 		  .header("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060")
			 		  .type("application/json")
			 		  .accept("application/json")
			 		  .post(ClientResponse.class,content);
					return response.getEntity(String.class);
				 
			   		   
			  }
			  

 
	
	
}
