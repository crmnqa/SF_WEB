
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TemplatewebDriver {

	FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\JVendi\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\jsvs7sxr.default")); 
 
  
	
	
	@Test
      public void myTest() throws InterruptedException{
		

System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver(profile);
		
		profile.setAcceptUntrustedCertificates(true);
		
		driver.get("http://www.uat-thetimes.co.uk/tto/news/");
		 
	//	WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(driver,"http://www.uat-thetimes.co.uk/tto/news/");  
		
		
		
		
		
		
		Thread.sleep(5000);
		
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='modules']/section[1]/article[1]/header/a")).click();
		
		/*selenium.open("/");
		Thread.sleep(5000);
		selenium.mouseOver("xpath=.//*[@id='news']/a/img");
		Thread.sleep(5000);
		System.out.println(selenium.isElementPresent("xpath=.//*[@id='p-nav']/div[2]/div[1]/div[1]/div/ul[1]/li[1]/h4/a"));
		selenium.click("xpath=.//*[@id='p-nav']/div[2]/div[1]/div[1]/div/ul[1]/li[1]/h4/a");    */
		
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='iam-new-barrier']/a[2]/img")).click();
		Thread.sleep(5000);
 	    driver.findElement(By.xpath(".//*[@id='j_id0:j_id3:j_id11:j_id22:0:btnTopSubscribe']")).click();
 		Thread.sleep(5000);
 	   driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_email")).sendKeys("one52@zaqwsx.com");
     
 	   
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_password")).sendKeys("Password123");
		 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_confirm_password")).sendKeys("Password123");
		new Select(driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_title"))).selectByVisibleText("Mr");
		 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_first_name")).sendKeys("one25@zaqwsx.com");
		 
		driver.findElement(By.id("j_id0:j_id1:personal_details_form:user_last_name")).sendKeys("one25@zaqwsx.com");
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

       
        
        }  
     }
        
 
 