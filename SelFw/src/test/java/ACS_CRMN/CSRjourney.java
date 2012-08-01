package ACS_CRMN;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  CSRjourney {
	
	 CSRBaseClass csr = new CSRBaseClass();
 
	AcsCalls acs=new AcsCalls();
    String email = csr.email;	 
     
       
   	@BeforeClass(groups = "a") 
 	public void setUp() throws Exception {
 	csr.setup();
 	 
 	}
	    
 	@Test (groups = "a") 
	public void A_custCreation() throws Exception {
 		System.out.println("Step 1:-- CSR journey started.......... " + "User ID is:---" + email);
 		csr.custCreation();
 	}
 	
 	@Test (groups = "a") 
	public void B_custBankDetails() throws Exception {
 		csr. BankDetails();
 		Thread.sleep(5000) ;
 	}

 	
	
		@Test (groups = "a") 
		public void C_CheckProfile() throws Exception {
	 		Thread.sleep(10000) ;
	 		System.out.println("Step 2:-- Call out ACS to compare values entered in web journey....." ); 	
	 		//Get external ID and IAM id from sales force
	 		String[] exp =  {"tnl",csr.email,"External_ID",csr.lastName,csr.email,csr.DispName,csr.firstName,"IAM_ID",csr.city,csr.country,csr.dob,csr.postcode} ;
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] profile  = acs.custProfile(content,acs.profile)  ;
	 		Assert.assertEquals( csr.ProfileMatch(exp, profile),true,"Profile before updation........");
	 		csr.Assert_CheckProfile(profile);
	 		}
		
		
		@Test (groups = "a") 
	
		public void D_CheckEntitlement() throws Exception {
			Thread.sleep(5000) ;
			String email = "websel_08_01_11_38_43@zaqwsx.com" ;
	 		System.out.println("Step 4:-- Call out ACS to check entitlements....." ); 		
	 		String content = "{\"tenantId\":\"TNL\",\"username\":\"" + email +"\"}" ;
	 		String[] entitlement = acs.custEntitlements(content,acs.Entitlement)  ;	
	 		
	 	   Assert.assertEquals( csr.EntitlementMatch(entitlement),true,"Entitlements  before updation...should be zero......."); 
	 	}

 	

 
 	// END
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	

 	
		
}

 
	
 
 
	 
 
