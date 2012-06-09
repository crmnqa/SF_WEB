import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.server.RemoteControlConfiguration;
import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArgosWebTest {
public Selenium selenium;
public SeleniumServer seleniumserver;

@BeforeClass
public void setUp() throws Exception {
	RemoteControlConfiguration rc = new RemoteControlConfiguration();
	seleniumserver = new SeleniumServer(rc);
selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.argos.co.uk");
seleniumserver.start();
selenium.start();
}

@Test
public void testUntitled() throws Exception {
selenium.open("/");
selenium.windowMaximize();
selenium.click("Clothing");
//assertTrue(selenium.isTextPresent("Selenium"));
}

@AfterClass
public void tearDown() throws Exception {
//selenium.stop();
}
}