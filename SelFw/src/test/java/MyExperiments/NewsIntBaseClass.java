package MyExperiments;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewsIntBaseClass {


	 
		WebDriver driver;
		String baseUrl;
		DateFormat dateFormat = new SimpleDateFormat("_MM_dd_HH_mm_ss");
		Date date = new Date();
		String email1 = "webSel";
		String email2 = "@zaqwsx.com" ;
		String email = email1 + dateFormat.format(date)  + email2 ;
		
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
 
 		driver.get("http://www.staging-thetimes.co.uk/tto/news/");  
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






}
        

 