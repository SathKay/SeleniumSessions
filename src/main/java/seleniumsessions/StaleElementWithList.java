package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.freshworks.com/");
		driver.manage().window().maximize();
		
		List<WebElement> footerList = driver.findElements(By.xpath("(//ul[@class='sc-ace17a57-0 sc-37672556-0 kTjuIu PoUXa'])[2]//a"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		for(int i=0;i<footerList.size();i++) {
			js.executeScript("arguments[0].click();", footerList.get(i));
			driver.navigate().back();
			footerList = driver.findElements(By.xpath("(//ul[@class='sc-ace17a57-0 sc-37672556-0 kTjuIu PoUXa'])[2]//a"));
//			Thread.sleep(1000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
//			wait.ignoring(StaleElementReferenceException.class);
//			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//ul[@class='sc-ace17a57-0 sc-37672556-0 kTjuIu PoUXa'])[2]//a")));
		}
	}

}
