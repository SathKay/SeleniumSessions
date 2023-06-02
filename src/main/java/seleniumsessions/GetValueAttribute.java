package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValueAttribute {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		By emailId = By.id("input-email");
		doSendKeys(emailId,"sk@gmail.com");
		
		String text = driver.findElement(emailId).getAttribute("value");
		System.out.println(text);
		
//		String text = doGetText(emailId);
//		System.out.println(text);
		
		System.out.println(doGetAttribute(emailId,"value"));
//		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static String doGetAttribute(By locator,String attName) {
		return getElement(locator).getAttribute(attName);
	}

}
