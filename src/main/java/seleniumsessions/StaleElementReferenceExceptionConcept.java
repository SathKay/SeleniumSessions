package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementReferenceExceptionConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		WebElement fn = driver.findElement(By.id("Form_getForm_Name"));
		fn.sendKeys("Sathya");
		
		driver.navigate().refresh();
		
		//fn = driver.findElement(By.id("Form_getForm_Name"));
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class);
		
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10))
												.pollingEvery(Duration.ofSeconds(1))
												.ignoring(StaleElementReferenceException.class);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Form_getForm_Name"))).sendKeys("K");
		
		//fn.sendKeys("K");

	}

}
