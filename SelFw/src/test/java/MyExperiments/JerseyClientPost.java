package MyExperiments;

import org.json.JSONException;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import MyExperiments.NewsIntBaseClass;
 
public class JerseyClientPost  {
 
  public static void main(String[] args) throws JSONException {
	  
	  
  String email = "three2@three.com" ;
	  
	  String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}"   ;
	  
	   	 String endpoint = "https://acs-uat.newsint.co.uk/profile/getUserProfile";
	   	 
	   	custProfile(content,endpoint);
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
  
  
  

	
  public static void custProfile(String content, String endpoint) throws JSONException{
	   
	   	String output =   restful(content, endpoint);
	  
	   String[ ] profile = new String[10];
	    
	      JSONObject jo = new JSONObject(output);   
	  	    
	  	  profile[0] = jo.get( "tenantId").toString();
	  	  profile[1] = jo.get( "username").toString();
	  	  profile[2] = jo.get( "externalId").toString();
	  	   
	     	JSONObject jos = new JSONObject(jo.get( "profileData").toString()); 
	  	  
	  	  profile[3] = jos.get( "lastName").toString();
	  	  profile[4] = jos.get( "email").toString();
	  	  profile[5] = jos.get( "displayName").toString();
	  	  profile[6] = jos.get( "firstName").toString();
	  	  profile[7] = jos.get( "iamId").toString();
	  	  profile[8] = jos.get( "city").toString();
	  	  profile[9] = jos.get( "country").toString();
	  	  
	  	  
	  	  
	  	  
	  	  for ( int i = 0 ; i<=9; i ++)
//  		  
  	  {
  		
  		System.out.println(profile[i]);
  		  
  	  }
	   
	   
	   
  }       
 	
  
  
  
  
  
  
  
  
  
  
	}
 