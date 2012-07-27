package MyExperiments;

import MyExperiments.NewsIntBaseClass;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class  WebJourney {
	
 	NewsIntBaseClass NI = new NewsIntBaseClass();
 
	@BeforeClass
	public void setUp() throws Exception {

		
		NI.setup();
		
	}
	
	   
 	@Test
	public void testWebDriverWebJourney() throws Exception {
 		 
		  
 		NI.webjourney(NI.email);
 		
 	}
 	
 	
		
}


	
 
 
	 
 
