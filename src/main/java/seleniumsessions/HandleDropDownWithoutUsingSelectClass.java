package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithoutUsingSelectClass {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		driver.manage().window().maximize();
		
		By country = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		List<WebElement> countryList = driver.findElements(country);
		
		for(WebElement e : countryList) {
			String text = e.getText();
			if(text.equals("Japan")) {
				e.click();
				break;
			}
		}

	}

}
