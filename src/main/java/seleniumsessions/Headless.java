package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headless {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--headless");
		//headless - browser is launched but its visibility is blocked from the machine
		//Adavantages - comparitively faster
		//Limitations - 1.may not work when popup is present - we need browser for that, 2.may not work for mouse movements
		//Uses - 1.can do quick sanity check, 2.if there is a requirement to run in headless mode then can be used
		
		//FirefoxOptions op = new FirefoxOptions();
		//op.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://google.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
	}

}
