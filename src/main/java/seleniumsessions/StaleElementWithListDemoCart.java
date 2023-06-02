package seleniumsessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementWithListDemoCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		List<WebElement> footerLinks = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]//a"));
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i=0;i<footerLinks.size();i++) {
			//footerLinks.get(i).click();
			js.executeScript("arguments[0].click();", footerLinks.get(i));
			driver.navigate().back();
			footerLinks = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]//a"));
			Thread.sleep(1000);
		}

	}

}
