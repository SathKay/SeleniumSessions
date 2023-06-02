package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(option);
		
	    driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		//2.name attribute - can be duplicate
		//driver.findElement(By.name("email")).sendKeys("sk@gmail.com");
		
		//3.class name attribute - can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("sk@gmail.com");
		
		//4.Using xpath : xpath is not an attribute. It is address of the element in HTML DOM
		//relative xpath and absolute xpath
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("sk@gmail.com");
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test@123");
		//driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
		
//		By emailId = By.xpath("//*[@id=\"input-email\"]");
//		By password = By.xpath("//*[@id=\"input-password\"]");
//		By loginBtn = By.xpath("//*[@id=\"form-login\"]/button");
//		
//		doSendKeys(emailId, "sk@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginBtn);
		
		//5.Using cssSelector : It is not an attribute
		//CSS - Cascaded Style Sheet
		
		By emailId = By.cssSelector("#input-email");
		By password = By.cssSelector("#input-password");
		By loginBtn = By.cssSelector("#form-login > button");
		
//		doSendKeys(emailId, "sk@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginBtn);
		
		//6.linkText - only works for links. Element with <a> tag are links
		//driver.findElement(By.linkText("Register")).click();
		
		//7.partialLinkText - works only for links . 
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8.tagname - html tag
//		String header = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(header);
		
		By register = By.linkText("Register");
		By header = By.tagName("h2");
		
		System.out.println(doGetText(register));
		System.out.println(doGetText(header));

	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	

}
