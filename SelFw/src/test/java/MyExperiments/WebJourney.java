package MyExperiments;

import MyExperiments.NewsIntBaseClass;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  WebJourney {
	
 	NewsIntBaseClass NI = new NewsIntBaseClass();
    String email = NI.email;	 
      
    String endpoint = "https://acs-uat.newsint.co.uk/profile/getUserProfile";
    
   
    
 	@BeforeClass
 	public void setUp() throws Exception {
 	NI.setup();
 	 
 	}
	    
 	@Test 
	public void A_testWebDriverWebJourney1() throws Exception {
 	System.out.println("Step 1" + email); 	  	  
 	NI.webjourney1(email);
 	
 	}
 	
 	@Test 
	public void B_CheckProfile() throws Exception {
 		  
 		System.out.println("Step 2" ); 	 	
 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		
 	    
 		 
 		String[] profile  = NewsIntBaseClass.custProfile(content,endpoint)  ;
 	  	Assert.assertEquals( profile[0],"tnl","Tenant ID Verification");
 	    Assert.assertEquals( profile[1],NI.email,"User Name Verification");
 	  	Assert.assertEquals( profile[3],NI.lastName,"lastname Verification");
 	  	Assert.assertEquals( profile[4],NI.email,"email Verification");
 	  //Assert.assertEquals( profile[5],,"DisplayName Verification");
 	  	Assert.assertEquals( profile[6], NI.firstName,"FirstName Verification");
 	  	Assert.assertEquals( profile[7] != null,"IAM ID Verification");
 	  	Assert.assertEquals( profile[8],NI.city,"email Verification");  	
 	  //Assert.assertEquals( profile[9],NI.email,"Country Verification");
 	  	Assert.assertEquals( profile[2] != null,true,"External ID Verification"); 
 	}
 	 	 	
 	@Test 
	public void C_testWebDriverWebJourney2() throws Exception {
 	 	 	 
 		System.out.println("Step 3" ); 	 
 		NI.webjourney2(email);

 	}
 	
 	
 	@Test 
	public void D_testWebDriverWebJourneyEdit() throws Exception {
 	 	 	 
 		System.out.println("Step 4" ); 	 
 		NI.webjourneyEdit();
 		 
 	}
 	
 	
 	@Test 
	public void E_checkProfile() throws Exception {
 		  
 		System.out.println("Step 5" ); 	 	
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] profile2  = NewsIntBaseClass.custProfile(content,endpoint)  ;	
 		Assert.assertEquals( profile2[0],"tnl","Tenant ID Verification");
 	    Assert.assertEquals( profile2[1],NI.email,"User Name Verification");
 	  	Assert.assertEquals( profile2[3],NI.u_lastName,"lastname Verification");
 	  	Assert.assertEquals( profile2[4],NI.email,"email Verification");
 	  //Assert.assertEquals( profile2[5],,"DisplayName Verification");
 	  	Assert.assertEquals( profile2[6], NI.u_firstName,"FirstName Verification");
 	  	Assert.assertEquals( profile2[7] != null,"IAM ID Verification");
 	  	Assert.assertEquals( profile2[8],NI.u_city,"email Verification");  
 	  	Assert.assertEquals( profile2[9],NI.email,"Country Verification");
 	    Assert.assertEquals( profile2[2] != null,true,"External ID Verification");
 	  	
 	  	
 	}
 	
 	
 	
		
}

 
	
 
 
	 
 
