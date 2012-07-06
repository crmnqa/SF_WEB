package MyExperiments;

import javax.ws.rs.core.MultivaluedMap;
import org.json.JSONException;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

 
public class JerseyClientPost  {
 
  public static void main(String[] args) throws JSONException {
	  
     String formData = "{\"tenantId\":\"TNL\",\"username\":\"three2@three.com\"}";
      
      Client client = new Client();
      WebResource resource = client.resource("https://acs-uat.newsint.co.uk/profile/getUserProfile");
       
    		   ClientResponse response =
    		  resource.header("X-NI-signatureType", "2")
    		  .header("X-NI-apiVersion", "1")
    		  .header("X-NI-signatureHash", "dummy")
    		  .header("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060")
    		  .type("application/json")
    		  .accept("application/json")
    		  .post(ClientResponse.class,formData);
      		   
      		 
      		 String output = response.getEntity(String.class);
      		System.out.println(output);
      		   
     
      JSONObject jo = new JSONObject(output);
//           
      System.out.println(jo.get("tenantId"));
      
      
      System.out.println(response.getStatus());
      System.out.println( response.getClientResponseStatus());
     
    
 
      MultivaluedMap headers =  response.getHeaders();
	  
	  
	  
	  
	  
 
	  }
  
  
  
 
	}
 