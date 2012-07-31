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
    String EntitlementEndpoint = "http://acs-uat.newsint.co.uk/authZ/getUserEntitlements";
        
   	@BeforeClass
 	public void setUp() throws Exception {
 	NI.setup();
 	 
 	}
	    
 	@Test 
	public void A_testWebDriverWebJourney1() throws Exception {
 	System.out.println("Step 1:-- Web journey - PART-1 started...stops beofre filling payment details....... " + "User ID is:---" + email); 	  	  
 	NI.webjourney1(email);
 	}
 	
 	@Test 
	public void B_CheckProfile() throws Exception {
 		Thread.sleep(5000) ;
 		System.out.println("Step 2:-- Call out ACS to compare values entered in web journey....." ); 	
 		//Get external ID and IAM id from sales force
 		String[] exp =  {"tnl",NI.email,"External_ID",NI.lastName,NI.email,NI.DispName,NI.firstName,"IAM_ID",NI.city,NI.country,NI.dob,NI.postcode} ;
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] profile  = NewsIntBaseClass.custProfile(content,endpoint)  ;
 		Assert.assertEquals( ProfileMatch(exp, profile),true,"Profile before updation........");
 		B_Assert_CheckProfile(profile);
 		}
 	 	 	
 	@Test 
	public void C_testWebDriverWebJourney2() throws Exception {
 	 	System.out.println("Step 3 :-- Web journey PART-2 fill payment details and save......." ); 	 
 		NI.webjourney2(email);

 	}
 	
	@Test 
	public void D_CheckEntitlement() throws Exception {
 		  
 		System.out.println("Step 4:-- Call out ACS to check entitlements....." ); 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] entitlement = NewsIntBaseClass.custEntitlements(content,EntitlementEndpoint)  ;	
 	 
 	   Assert.assertEquals( EntitlementMatch(entitlement),false,"Entitlements  before updation...should be zero......."); 
 	}
 	
 	
 	@Test 
	public void E_testWebDriverWebJourneyEdit() throws Exception {
 	 	System.out.println("Step 5:--- Editing user detals in middle of journey........." ); 	 
 		NI.webjourneyEdit();
 	}
 	 	
 	@Test 
	public void F_checkProfile() throws Exception {
 		  
 		System.out.println("Step 6:-- Call out ACS to compare updated values in web journey....." ); 		
 		String[] exp =  {"tnl",NI.email,"External_ID",NI.u_lastName,NI.email,NI.u_DispName,NI.u_firstName,"IAM_ID",NI.u_city,NI.country,NI.u_dob,NI.postcode} ;
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] profile2  = NewsIntBaseClass.custProfile(content,endpoint)  ;	
 	    Assert.assertEquals( ProfileMatch(exp, profile2),true,"Profile after updation........");
 		E_Assert_checkProfile(profile2) ; 
 	}
 	 	
 	@Test 
	public void G_CheckEntitlement() throws Exception {
 		  
 		System.out.println("Step 7:-- Call out ACS to check entitlements..Should exist now..." ); 		
 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
 		String[] entitlement = NewsIntBaseClass.custEntitlements(content,EntitlementEndpoint)  ;	
 	    Assert.assertEquals( EntitlementMatch(entitlement),true,"Entitlements  before updation...should be zero......."); 
 	}
 	
  
 	
 
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	// WILL BE MOVED TO UTILITIES LATER
 	
 	
 	public boolean ProfileMatch(String[] exp, String[] prof){
 		boolean flag = true;

	   	  for ( int i = 0 ; i<=11; i ++)
		  {//System.out.println("ALL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:"+prof[i]  );
	   	  if  (exp[i].equals(prof[i])  )  {
	   	  System.out.println("Matched    :"+prof[i]+ "  :------------:   " +exp[i]); }	
	   	  else if ((exp[i].equals("External_ID")) || (exp[i].equals( "IAM_ID")))   {
	  	    	if (prof[i] != null){
	   		    System.out.println("Not Null    :"+prof[i]+"  :------------:   "+exp[i]);}
	   			else {
	   			System.out.println("Null    :    "+prof[i]+"  :------------:   "+exp[i]);}
	   		}
	   		  
	   	    else{
	  		System.out.println("MisMatched    :  "+prof[i]+"  :------------:   "+exp[i]);
	  		flag = false;  	}
	   		  
	  }
		
	if (flag == false) {
		
		System.out.println("Please check logs");
	}
	   	  
	   	  return flag;	
		
	
 	}
 	
 	public boolean EntitlementMatch(String[] enti) {
 		
 		boolean flag = true;
 		
 		System.out.println(enti.length);
 		
 		if ( enti[0].length() <= 12 ) {
 			
 			flag = false;
 		
 		}
 		
 		return flag;
 	}
 	
 	
 	
 	public void E_Assert_checkProfile(String[] profile2) throws Exception {
 		
		Assert.assertEquals( profile2[0],"tnl","Tenant ID Verification");
	    Assert.assertEquals( profile2[1],NI.email,"User Name Verification");
	  	Assert.assertEquals( profile2[3],NI.u_lastName,"lastname Verification");
	  	Assert.assertEquals( profile2[4],NI.email,"email Verification");
	    Assert.assertEquals( profile2[5],NI.u_DispName,"DisplayName Verification");
	   	Assert.assertEquals( profile2[6], NI.u_firstName,"FirstName Verification");
	  	Assert.assertEquals( profile2[7] != null,"IAM ID Verification");
	  	Assert.assertEquals( profile2[8],NI.u_city,"email Verification");  
	  	Assert.assertEquals( profile2[9],NI.email,"Country Verification");
	    Assert.assertEquals( profile2[2] != null,true,"External ID Verification");
	    Assert.assertEquals( profile2[10],NI.u_dob,"dob verification");
	    Assert.assertEquals( profile2[10],NI.u_postcode,"Postcode verification");
	  	
 	}
 	
 	
	public void B_Assert_CheckProfile(String[] profile) throws Exception {
		Assert.assertEquals( profile[0],"tnl","Tenant ID Verification");
	    Assert.assertEquals( profile[1],NI.email,"User Name Verification");
	   	Assert.assertEquals( profile[2] != null,true,"External ID Verification"); 
	  	Assert.assertEquals( profile[3],NI.lastName,"lastname Verification");
	  	Assert.assertEquals( profile[4],NI.email,"email Verification");
	    Assert.assertEquals( profile[5],NI.DispName,"DisplayName Verification");
	  	Assert.assertEquals( profile[6], NI.firstName,"FirstName Verification");
	  	Assert.assertEquals( profile[7] != null,true,"IAM ID Verification");
	  	Assert.assertEquals( profile[8],NI.city,"email Verification");  	
	    Assert.assertEquals( profile[9],NI.country,"Country verification");
	   Assert.assertEquals( profile[10],NI.dob,"dob verification");
	  Assert.assertEquals( profile[11],NI.postcode,"PostCode verification");
}    
 	
		
}

 
	
 
 
	 
 
