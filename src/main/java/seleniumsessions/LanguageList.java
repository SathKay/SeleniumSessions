package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageList {

	static WebDriver driver;

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
//		List<WebElement> langList = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//		System.out.println(langList.size());
//		
//		for(WebElement e : langList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.contains("தமிழ்")) {
//				e.click();
//				break;
//			}
//			
//		}
		
//		By lang = By.xpath("//div[@id='SIvCob']/a");
//		clickOnText(lang,"தமிழ்"); 
		
		By footerLinks = By.xpath("//div[@class='KxwPGc SSwjIe']//a[@class='pHiOh']");
		ElementUtils eleUtil = new ElementUtils(driver);
		System.out.println(eleUtil.getElementCount(footerLinks));
		eleUtil.printElementsText(footerLinks);
		System.out.println();
		eleUtil.clickOnText(footerLinks, "Terms");
		

	}
	
	public static void clickOnText(By locator, String text) {
		List<WebElement> langList = driver.findElements(locator);
		System.out.println(langList.size());
		for(WebElement e: langList) {
			String textval = e.getText();
			System.out.println(textval);
			if(textval.contains(text)) {
				e.click();
				break;
			}
		}
	}

}
