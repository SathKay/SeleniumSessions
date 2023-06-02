package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElements {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.freshworks.com/");
		
		driver.manage().window().maximize();
		
		By footer = By.cssSelector("ul.sc-ace17a57-0.sc-37672556-0.kTjuIu.PoUXa>li>a>span");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		List<WebElement> footerList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
//		
//		System.out.println(footerList.size());
//		List<WebElement> footerList = waitForElementsVisible(5, footer);
//		for(WebElement e:footerList ) {
//			System.out.println(e.getText());
//		}
		
		By product = By.xpath("//span[text()='Demo']");
		clickWhenReady(5,product).click();
		}
	
	/**
	 * This is a wait method for WebElements
	 * An expectation for checking that all elements present on the web page that match the locatorare visible. 
	 * Visibility means that the elements are not only displayed but also have a heightand width that is greater than 0.
	 * @param timeOut
	 * @param locator
	 * @return List<WebElement>
	 */
	public static List<WebElement> waitForElementsVisible(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * An expectation for checking that there is at least one element present on a web page.
	 * @param timeOut
	 * @param locator
	 * @return List<WebElement>
	 */
	public static List<WebElement> waitForElementsPresence(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static WebElement clickWhenReady(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
