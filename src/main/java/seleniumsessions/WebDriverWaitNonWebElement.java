package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNonWebElement {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.titleContains("Account"));
//		
//		System.out.println(driver.getTitle());
		
//		System.out.println(doGetPageTitle("Account", 10));
		
		System.out.println(doGetPageTitleIs("Account Login", 10));
	}
	
	public static boolean waitForPageTitle(String titleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleVal));
	}
	
	public static boolean waitForPageActTitle(String actTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}
	
	public static String doGetPageTitleContains(String titleVal, int timeOut) {
		if(waitForPageTitle(titleVal, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public static String doGetPageTitleIs(String actTitle, int timeOut) {
		if(waitForPageActTitle(actTitle,timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

}
