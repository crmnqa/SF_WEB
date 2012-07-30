package MyExperiments;

import MyExperiments.NewsIntBaseClass;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  WebJourney {
	
 	NewsIntBaseClass NI = new NewsIntBaseClass();
    String email = NI.email;	 
     
   
    
 	//  String content = "{\"tenantId\":\"TNL\",\"username\":\"" + NI.email +"\"}" ;
	  
   	 String endpoint = "https://acs-uat.newsint.co.uk/profile/getUserProfile";
   	 
 
   	 
 	@BeforeClass
 	public void setUp() throws Exception {
 	
 	NI.setup();
 		
 	}
	
    
 	@Test 
	public void testWebDriverWebJourney1() throws Exception {
 	 	System.out.println("testWebDriverWebJourney1  " + email); 	  	  
 	NI.webjourney1(email);

 	}
 	
 	@Test 
	public void zheckProfile() throws Exception {
 		  
 	 	System.out.println("Profiel check  " + email); 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] profile  = NewsIntBaseClass.custProfile(content,endpoint)  ;	
 	  	
 	  	 Assert.assertEquals( profile[0],"tnl","Tenant ID Verification");
 	  	 Assert.assertEquals( profile[1],NI.email,"User Name Verification");
 	  	 Assert.assertEquals( profile[2] != null,"External ID Verification");
 	  	Assert.assertEquals( profile[3],NI.lastName,"lastname Verification");
 	  	Assert.assertEquals( profile[4],NI.email,"email Verification");
 	  //	Assert.assertEquals( profile[5],,"DisplayName Verification");
 	  	Assert.assertEquals( profile[6], NI.firstName,"FirstName Verification");
 	  	Assert.assertEquals( profile[7] != null,"IAM ID Verification");
 	  	Assert.assertEquals( profile[8],NI.city,"email Verification");  	
 	  	//Assert.assertEquals( profile[9],NI.email,"Country Verification");
 	}
 	
 	
 	
 	@Test 
	public void testWebDriverWebJourney2() throws Exception {
 	 	
 	 
 	 	System.out.println("testWebDriverWebJourney2  " + email); 	
 		
 	NI.webjourney2(email);

 	}
		
}

 
	
 
 
	 
 
