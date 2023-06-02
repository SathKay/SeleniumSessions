package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='kils']")).sendKeys("SK");
		
		//Browser-Page-ShadowDOM
		
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement username = (WebElement)js.executeScript("return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")");
		
		username.sendKeys("SK");

	}

}
