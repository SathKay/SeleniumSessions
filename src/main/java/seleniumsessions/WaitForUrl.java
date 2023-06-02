package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrl {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.findElement(By.linkText("Register")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.urlContains("register"))) {
//			System.out.println(driver.getCurrentUrl());
//		}
		
//		String url = waitForUrlContains("account/register", 5);
//		System.out.println(url);
		
		String url = waitForUrlToBe("https://demo.opencart.com/index.php?route=account/register&language=en-gb", 5);
		System.out.println(url);
	
	}
	
	public static String waitForUrlContains(String urlfraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{if(wait.until(ExpectedConditions.urlContains(urlfraction))) {
			return driver.getCurrentUrl();
		}
		}catch(TimeoutException e) {
		return null;
		}
		return null;
	}
	
	public static String waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try{if(wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		}catch(TimeoutException e){
			return null;
		}
		return null;
	}
	

}
