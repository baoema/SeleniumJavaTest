package prueba2;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import javax.swing.JOptionPane;

public class Practica1 {
	  
	  private WebDriver driver;
	  private boolean register = false;
	  private String userName = "";
	  private boolean login = false;
	  private boolean AddtoCartAlert = false;
	  private String productName;
	  @Before
	  public void configure() {
	      System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	      driver=new ChromeDriver();
	      driver.manage().window().maximize(); 
	      driver.get("https://www.demoblaze.com/");	      
	  }
  
	  @Test	  
	  public void singUp() throws Exception {
	    WebElement buttonSingUp = driver.findElement(By.id("signin2"));
	    buttonSingUp.click();
	    Thread.sleep(500);
	    //carga textbox usuario
	    driver.findElement(By.id("sign-username")).sendKeys(user_Alphanumeric());	    
	    
	    //carga textbox password
	    driver.findElement(By.id("sign-password")).sendKeys("ciro2020");
	    
	    //registro de usuario    
	    WebElement singUpButton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]"));
	    singUpButton.click();  
	    
	    Thread.sleep(800);  
	    singUpCheck(driver.switchTo().alert().getText());		    	 
	    driver.switchTo().alert().accept();	    
	    
	    if (this.register == true) {
	    	//click on login link	    	
		  	WebElement buttonLogIn = driver.findElement(By.id("login2"));
			buttonLogIn.click();
			Thread.sleep(500);
			this.login = true;
			login();
	    }  
	    
		if (this.login == true) {
			Thread.sleep(2000);	
			WebElement buttonLogOut = driver.findElement(By.xpath("//a[@id='logout2']"));
			buttonLogOut.click();			  
	    }
		
		
		WebElement laptops = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]"));
		laptops.click();		  
		Thread.sleep(1000);	
		addingToCart();
	    
    	
	  }  
	  public void addingToCart() {
		  //seleccionar una laptop - 1er elemento
		  WebElement firstElement = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a"));
		  this.productName = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a")).getText();
		  firstElement.click();
		  
		  //JOptionPane.showMessageDialog(null, "Producto: "+this.productName);
		  
		  waitingMethod();  
		  //agregar al carrito
		  WebElement buttonAddToCart = driver.findElement(By.linkText("Add to cart"));
		  buttonAddToCart.click();
		  
		  waitingMethod();
		  setBooleanToAddAlert(driver.switchTo().alert().getText());		  
		  driver.switchTo().alert().accept();
		  
		  //hacer click en cart		  
		  WebElement buttonCart = driver.findElement(By.xpath("//*[@id=\"cartur\"]"));
		  buttonCart.click();	
		  waitingMethod();
		  comparator(driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText());		  
		  	  
	  }
	  
	  public void comparator(String msg) {
		  if (this.productName.equals(msg)) {
			 // JOptionPane.showMessageDialog(null, "Son iguales");
		  }
	  }
	  
	  public void setBooleanToAddAlert(String msg) {
		  if (msg.equals("Product added")) {
			  this.AddtoCartAlert = true;
		  }			  
	  }
	  
	  public void waitingMethod() {
		  try {
				Thread.sleep(1000);
		  } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		  }		  
	  }
	  
	  public void login() {		  
		//carga textbox usuario
		driver.findElement(By.id("loginusername")).sendKeys(this.userName);		    
		    
		//carga textbox password		
		driver.findElement(By.id("loginpassword")).sendKeys("ciro2020");
		    
		//click on button login		
		WebElement loginButton = driver.findElement(By.xpath("//div[@id='logInModal']/div/div/div[@class='modal-footer']/button[@class='btn btn-primary']"));
		loginButton.click();
	  }
	  
	  public void singUpCheck(String msg) {		  
		    if (msg.equals("Sign up successful.")) {
		    	this.register = true;
		    }
		    if (msg.equals("This user already exist."))  {
		    	this.register = false;
		    }
	  }
	  
	  public String user_Alphanumeric() {		  
		  this.userName = "";
		  String possible[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		  		  
		  for (int i = 0; i < 10; i++) {	
			  int numero = (int)(Math.random()*62);	
		      this.userName += possible[numero];			      
		  }		 
		  return this.userName;
	  }	  
	}