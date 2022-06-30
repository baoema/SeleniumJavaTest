package prueba2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class practica1 {
	
	private WebDriver driver;

    @Before
    public void configure() {
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.demoblaze.com/");
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
