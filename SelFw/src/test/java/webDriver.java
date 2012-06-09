import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class webDriver {

	WebDriver driver = new InternetExplorerDriver();     
      
	@Test
      public void myTest(){
    
      

     driver.get("http://www.google.com");
       
                
      WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        
     WebElement GsClick = driver.findElement(By.xpath(".//*[@id='gbqfq']")) ;
     
     GsClick.click();
     
     System.out.println(driver.getCurrentUrl());
    		 
    		 
        /*
        
          long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
        WebElement resultsDiv = driver.findElement(By.className("gac_m"));

         
            if (resultsDiv.isEnabled()) {
              break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gac_c']"));
        
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        } */
     }
        
}
 