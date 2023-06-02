package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementActions {
		static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("http://mrbool.com/");
		
		driver.manage().window().maximize();
		
		WebElement contentParent = driver.findElement(By.className("menulink"));
		
		Actions act = new Actions(driver);
		
		//act.moveToElement(contentParent).build().perform(); //correct
		act.moveToElement(contentParent).perform(); //correct
		//act.moveToElement(contentParent).build(); //not correct
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("COURSES")).click();
		
		

	}

}
