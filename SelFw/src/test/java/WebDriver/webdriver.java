package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class webdriver{
	
	public static void main(String args[]) throws InterruptedException{
	

		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new  ChromeDriver();
		 
		driver.get("http://www.amazon.co.uk");

	 
	//Deal with List Box or DropDown  EX: Amazon 
		 
/*	 Select select = new Select(driver.findElement(By.xpath(".//*[@id='searchDropdownBox']")));				
	 	
		 List<WebElement> options = select.getOptions(); 
		 
		 System.out.println(options.size());
		
		 for(int i = 0; i<=5;i++){
		 System.out.println(options.get(i).getText());
		 }
		driver.quit();  */
		
		
		
 	}
	
	
	
	
	
	
	
	
}