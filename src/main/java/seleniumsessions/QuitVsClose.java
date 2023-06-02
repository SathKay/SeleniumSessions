package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuitVsClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.google.com");
		System.out.println("The title is "+ driver.getTitle());
		
		if(driver.getTitle().equalsIgnoreCase("Google")) {
			System.out.println("Correct Page");
		}
		else {
			System.out.println("Incorrect Page");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		//driver.quit();
		
		driver.close();
		
		//re launch the browser to continue using it
		
		//driver = new ChromeDriver(option);
		System.out.println(driver.getTitle());

	}

}
