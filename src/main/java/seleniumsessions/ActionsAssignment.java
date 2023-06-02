package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAssignment {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		
		driver.manage().window().maximize();
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");	
		By email = By.id("input-email");
		By password = By.id("input-password");
		By newsletter = By.id("input-newsletter-yes");
		By privacyPolicy = By.xpath("//input[@type='checkbox']");
		By continueEle = By.xpath("//button[@type='submit']");
		
		doActionsSendKeys(firstName, "Sathya");
		doActionsSendKeys(lastName, "K");
		doActionsSendKeys(email, "sk@gamil.com");
		
//		WebElement myelement = driver.findElement(password);
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		
//		WebElement ele = driver.findElement(password);
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", ele);
		
		doActionsSendKeys(password, "test@123");
		doActionsClick(newsletter);
		doActionsClick(privacyPolicy);
		doActionsClick(continueEle);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		
		WebElement myelement = driver.findElement(locator);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		
		act.sendKeys(getElement(locator), value).perform();
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
}
