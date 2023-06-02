package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		//driver.findElement(By.id("input-email")).sendKeys("sk@gmail.com");
		//driver.findElement(By.id("input-password")).sendKeys("test123");
		
		//method 2
		//WebElement emailId = driver.findElement(By.id("input-email"));
		//WebElement password = driver.findElement(By.id("input-password"));
		
		//emailId.sendKeys("sk@gmail.com");
		//password.sendKeys("test@123");
		
		//method 3 By locator
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement emailID = driver.findElement(emailId);
//		WebElement pass = driver.findElement(password);
//		
//		emailID.sendKeys("sk@gmail.com");
//		pass.sendKeys("test@123");
		
		//method 4 By locator with generic method
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(emailId).sendKeys("sk@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5.By locator with getElement and actions method
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(emailId, "sk@gmail.com");
//		doSendKeys(password,"test@123");
		
		// 6. By locator with getElement and actions method in Util class
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtils eleUtil = new ElementUtils(driver);
//		eleUtil.doSendKeys(emailId, "sk@gmail.com");
//		eleUtil.doSendKeys(password, "test@123");
//		
		//7. String with By, getElemnt and actions method in Util class
		
		String emailId = "input-email";
		String password = "input-password";
		
		ElementUtils eleUtil = new ElementUtils(driver);
		eleUtil.doSendKeys("id",emailId,"sk@gmail.com");
		eleUtil.doSendKeys("Id",password,"test@123");
	}
	
	public static By getBy(String locatorType, String locatorValue) {
		
		By locator=null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			break;
		}
		
		return locator;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}


}
