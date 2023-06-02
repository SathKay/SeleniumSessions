package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.aqi.in/dashboard/canada");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.linkText("Wood Buffalo, Canada"));
		
		JavaScriptUtil js = new JavaScriptUtil(driver);
		
		js.scrollIntoView(ele);
		
		System.out.println(driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText());
		
		System.out.println(driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText());

		System.out.println(driver.findElement(with(By.tagName("p")).near(ele)).getText());
		
		System.out.println(driver.findElement(with(By.tagName("a")).above(ele)).getText());
		
		System.out.println(driver.findElement(with(By.tagName("p")).below(ele)).getText());
		
		System.out.println();
		
		List<WebElement> belowList = driver.findElements(with(By.tagName("p")).above(ele));
		for(WebElement e: belowList) {
			System.out.println(e.getText());
		}
	}

}
