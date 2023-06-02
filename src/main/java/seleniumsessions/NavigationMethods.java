package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class NavigationMethods {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		ChromeDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		//driver.get("https://www.google.com");
		driver.navigate().to("https://www.google.com");
		System.out.println(driver.getTitle());
		
		//driver.navigate().to("https://www.amazon.com");
		//driver.get("https://www.amazon.com");
		driver.navigate().to(new URL("https://www.amazon.com"));
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
	}

}
