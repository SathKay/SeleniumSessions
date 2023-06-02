package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1.Search
		//2.Print the count of suggestions
		//3.Click on a suggestion
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(option);
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Naveen Automation labs");
		
		Thread.sleep(3000);
		
//		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']//span"));
//		
//		System.out.println(suggList.size());
//		
//		for(WebElement e : suggList) {
//			String text = e.getText();
//			if(text.contains("interview questions")) {
//				e.click();
//				break;
//			}
//		}
		
		//WebElement suggElement = driver.findElement(By.xpath("//div[@class='wM6W7d']//b[contains(text(),'github')]"));
//		WebElement suggElement = driver.findElement(By.xpath("//ul[@role='listbox']//b[contains(text(),'github')]"));
//		suggElement.click();
		
		selectSuggestion("youtube");
		

	}
	public static void selectSuggestion(By locator, String suggestion) {
		List<WebElement> suggList = driver.findElements(locator);
		System.out.println(suggList.size());
		for(WebElement e : suggList) {
			String text = e.getText();
			if(text.equals(suggestion)) {
				e.click();
			}
		}
		
	}
	
	public static void selectSuggestion(String suggestion) {
		WebElement suggElement = driver
				.findElement(By.xpath("//div[@class='wM6W7d']//b[contains(text(),'"+suggestion+"')]"));
		suggElement.click();
	}
	
	

}
