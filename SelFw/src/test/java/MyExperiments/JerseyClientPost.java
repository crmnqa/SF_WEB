package MyExperiments;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
 
public class JerseyClientPost {
 
  public static void main(String[] args) {
	  
	   
	//  MultivaluedMap formData = new MultivaluedMapImpl();
//	  formData.add("X-NI-signatureType", "2");
//	  formData.add("X-NI-apiVersion", "1");
//	  formData.add("X-NI-signatureHash", "dummy");
//	  formData.add("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060");
//	  
//      formData.add("tenantId", "TNL");
//      formData.add("username", "three2@three.com");
      
      String formData = "{\"tenantId\":\"TNL\",\"username\":\"three2@three.com\"}";
      
      Client client = new Client();
      WebResource resource = client.resource("https://acs-uat.newsint.co.uk/profile/getUserProfile");
      
//      resource.header("X-NI-signatureType", 2);
//      resource.header("X-NI-apiVersion", 1);
//      resource.header("X-NI-signatureHash", "dummy");
//      resource.header("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060"); 
      
      		   ClientResponse response =
    		  
    		   resource.header("X-NI-signatureType", "2")
    		  .header("X-NI-apiVersion", "1")
    		  .header("X-NI-signatureHash", "dummy")
    		  .header("X-NI-apiKey", "a3a0a84318e06c048a8bdb56c966f060")
    		  
    		  .type("application/json")
    		  .accept("application/json")
    		  .post(ClientResponse.class,formData);
      
      
      //ClientResponse response = resource.post(ClientResponse.class, formData);
      
      		 
      
      System.out.println(response.getStatus());
      
      
      
 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
 
	  }
  
  
  
 
	}
 