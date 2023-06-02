package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		driver.findElement(By.id("input-email1")).sendKeys("sk@gmail.com"); 
		//This gives  org.openqa.selenium.NoSuchElementException, since id is wrong

	}

}
