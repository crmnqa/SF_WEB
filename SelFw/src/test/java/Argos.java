import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import SeleniumFW.OR.*;

public class Argos{//extends SeleneseTestCase{
public Selenium selenium;
public SeleniumServer seleniumserver;


@Test

public void testGoogle1() throws Exception {
selenium.open("http://www.argos.co.uk");
selenium.windowMaximize();
selenium.captureEntirePageScreenshot("C:\\SEL\\test.png", "");      //getXpathCount("//a[@id='firstnavlink']");
selenium.windowMaximize();
/*
//selenium.click("//a[@id='firstnavlink']");
 final boolean  result = selenium.isElementPresent("//a[@id='firstnavlink']") ;
 
 System.out.println(result);
	
 if (selenium.isElementPresent("//a[@id='firstnavlink']")) {
	 
	 selenium.mouseOver("//a[@id='firstnavlink']");
	 
	 System.out.println(result);
	 System.out.println("On Mouse Over");
 } */
 
 
 // String hsource = selenium.getHtmlSource();
	
  //System.out.println(hsource);

 //String
//String path = System.getProperty("user.dir");
   

 //System.out.println("Puku res*************************************************************************:" + hsource);


selenium.windowMaximize();

}



    @BeforeClass
    public void setUp() throws Exception {
        RemoteControlConfiguration rc = new RemoteControlConfiguration();
        seleniumserver = new SeleniumServer(rc);
        selenium = new DefaultSelenium("localhost", 4444, "*firefox","http://");
        seleniumserver.start();
        selenium.start();
    }


    @AfterClass
public void tearDown() throws Exception {
//selenium.stop();
seleniumserver.stop();
}

}