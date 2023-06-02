package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		driver.manage().window().maximize();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(2));
		
		//waitForFrameByIndex(5,2);
		
//		By frameLocator = By.name("main");
//		waitForFrameByLocator(5,frameLocator);
		
		//waitForFrameByString(5,"main");
		
		WebElement frameElement = driver.findElement(By.name("main"));
		waitForFrameByWebElement(5,frameElement);
		
		System.out.println(driver.findElement(By.xpath("/html/body/h2")).getText());

	}
	
	public static WebDriver waitForFrameByIndex(int timeOut, int index) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	public static WebDriver waitForFrameByLocator(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static WebDriver waitForFrameByString(int timeOut, String nameOrId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	}
	
	public static WebDriver waitForFrameByWebElement(int timeOut, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}

}
