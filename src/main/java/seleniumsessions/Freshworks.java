package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Freshworks {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		//driver.get("https://www.google.co.in/");
		
		driver.manage().window().maximize();
		
		driver.get("https://www.freshworks.com/");
		
		By footerLinks = By.xpath("//ul[@class='sc-ace17a57-0 sc-b9382cdc-0 kTjuIu zlIHF']//a");
		//clickOnText(footerLinks, "Freshworks Neo");
		
		By footerLinks2 = By.xpath("//ul[@class='sc-ace17a57-0 sc-b9382cdc-2 jurjFh iHWrdf']//a");
		ElementUtils eleUtil = new ElementUtils(driver);
		System.out.println(eleUtil.getElementCount(footerLinks2));
		eleUtil.printElementsText(footerLinks2);
		System.out.println();
		eleUtil.clickOnText(footerLinks2, "Security");
		
		
	}
	
	public static void clickOnText(By locator , String text) {
		List<WebElement> linksList = driver.findElements(locator);
		System.out.println(linksList.size());
		for(WebElement e: linksList) {
			String textVal = e.getText();
			System.out.println(textVal);
			if(textVal.contains(text)) {
				e.click();
				break;
			}
		}
	}

}
