package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickSendKeys {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		//driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		driver.manage().window().maximize();
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		
		By continueEle = By.xpath("//button[@type='submit']");
		
		Actions act = new Actions(driver);
		
//		act.sendKeys(driver.findElement(firstName), "Sathya").perform();
//		act.sendKeys(driver.findElement(lastName), "K").perform();
//		
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].click();", driver.findElement(continueEle));
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		By loginBtn = By.xpath("//button[@type='submit']");
		
//		act.sendKeys(driver.findElement(email), "sk@gmail.com").perform();
//		act.sendKeys(driver.findElement(password), "text@123").perform();
//		act.click(driver.findElement(loginBtn)).perform();
		
		doSendKeys(email,"sk@gmail.com");
		doSendKeys(password,"test@123");
		doClick(loginBtn);        
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * This method uses sendKeys method from actions class to perform the function
	 * @param locator
	 * @param value
	 */
	public static void doSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}
	
	/**
	 * This method uses click method from Actions class to perform the function
	 * @param locator
	 */
	public static void doClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	

}
