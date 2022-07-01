package prueba2;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;


public class Practica1 {
  
  private WebDriver driver;

    @Before
    public void configure() {
      System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
      driver=new ChromeDriver();
      driver.manage().window().maximize(); 
      //Thread.sleep(3000);
      driver.get("https://www.demoblaze.com/");
      
    }
    
  @Test
  
  public void loging() throws Exception {
    WebElement button = driver.findElement(By.id("signin2"));
    button.click();
    Thread.sleep(500);
    //carga textbox usuario
    driver.findElement(By.id("sign-username")).sendKeys("peperoni8");
    
    //carga textbox password
    driver.findElement(By.id("sign-password")).sendKeys("ciro2020");
    
    //enviar formulario
    
    WebElement Login = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
    Login.click();
    
           
    //buttonSingUp.submit();    
    
  }
  
  public void test() {
    fail("Not yet implemented");
  }

}