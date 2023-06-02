package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//									.withTimeout(Duration.ofSeconds(10))
//										.pollingEvery(Duration.ofSeconds(2))
//											.ignoring(NoSuchElementException.class)
//												.ignoring(StaleElementReferenceException.class);
//		WebElement emailId_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//emailId_ele.sendKeys("sk@gmail.com");
		//waitForElementVisibleWithFluentWait(emailId,10,2).sendKeys("sk@gmail.com");
		driver.findElement(password).sendKeys("test@123");
		
		waitForElementVisibleWithWait(emailId,10,2).sendKeys("sk@gmail.com");
		//driver.findElement(password).sendKeys("test@123");
										

	}
	
	public static WebElement waitForElementVisibleWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(timeOut))
										.pollingEvery(Duration.ofSeconds(pollingTime))
											.ignoring(NoSuchElementException.class)
												.ignoring(StaleElementReferenceException.class)
													.withMessage(locator +" is not found within given time......");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
									
	}
	
	public static WebElement waitForElementVisibleWithWait(By locator,int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime))
					.ignoring(NoSuchElementException.class)
						.ignoring(StaleElementReferenceException.class)
							.withMessage(locator+" is not found ");	
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

}
