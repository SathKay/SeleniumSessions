package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WAP
		//1.Count of total images in the page
		//2.Print alt value of each image
		//3.Print src value of each image
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		driver.manage().window().maximize();
		
		/* Count of Images*/
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println(imgList.size());
		
		/* alt and src */
		for(WebElement e:imgList) {
			String altVal= e.getAttribute("alt");
			String srcVal = e.getAttribute("src");
			
			System.out.println(altVal+ " : " +srcVal);
			System.out.println();
		}

	}
	

}
