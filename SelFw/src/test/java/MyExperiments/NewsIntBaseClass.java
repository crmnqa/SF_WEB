package MyExperiments;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class NewsIntBaseClass {
	 
		WebDriver driver;
		String baseUrl;
		static DateFormat dateFormat = new SimpleDateFormat("_MM_dd_HH_mm_ss");
		static Date date = new Date();
		static String email1 = "websel";
		static String email2 = "@zaqwsx.com" ;
		static String email = email1 + dateFormat.format(date)  + email2 ;
		
		public void setup( ) throws InterruptedException {
		 FirefoxProfile profile= new FirefoxProfile(); 
		 profile.setAcceptUntrustedCertificates(true);
		 profile.setAssumeUntrustedCertificateIssuer(false);
		driver = new FirefoxDriver(profile);
		baseUrl = "http://www.uat-thetimes.co.uk/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	public void webjourney(String email) throws InterruptedException {
		
		 driver.manage().deleteAllCookies(); 
 
 		driver.get("http://www.uat-thetimes.co.uk/tto/news/");  
 		Thread.sleep(5000);
 	    driver.findElement(By.xpath(".//*[@id='prenav']/ul[2]/li[2]/a")).click();
 		Thread.sleep(5000);
 		driver.findElement(By.xpath(".//*[@id='iam-not-subscriber']/a")).click(); 	
 		driver.findElement(By.xpath(".//*[@id='j_id0:j_id3:j_id11']/div[1]/div[1]/div[2]")).click();
		driver.findElement(By.xpath(".//*[@id='j_id0:j_id3:j_id11:j_id22:0:btnTopSubscribe']")).click();
	 	driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_email")).sendKeys(email);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_password")).sendKeys("Password123");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_confirm_password")).sendKeys("Password123");
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_title"))).selectByVisibleText("Mr");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_first_name")).sendKeys("WebSelFirst" + email);
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_last_name")).sendKeys("WebSelLast" + email);
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthDays"))).selectByVisibleText("01");
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthMonths"))).selectByVisibleText("Jan");
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:lstDateofBirthYears"))).selectByVisibleText("1990");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_postcode")).sendKeys("HA90AB");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_1")).sendKeys("Flat 1");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_2")).sendKeys("Forum House");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_address_line_3")).sendKeys("Empire Way");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_city")).sendKeys("Wembley");
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_accept_tAndCs")).click();
		driver.findElement(By.id("ni-reg-btn-register")).click();
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_name")).sendKeys("AccountHolderWebSel");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_bank_name")).sendKeys("BankNameWebSel");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_number")).sendKeys("12345678");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_1")).sendKeys("11");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_2")).sendKeys("11");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_account_sort_3")).sendKeys("11");
		driver.findElement(By.id("j_id0:j_id1:direct_debit_form:user_dd_authorised")).click();
		driver.findElement(By.id("ni-pay-btn-dd")).click();
		driver.findElement(By.id("ni-pay-btn-bottom")).click();
		//driver.findElement(By.id("ni-pay-btn-bottom")).click();
		
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
        

 