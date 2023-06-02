package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance-')]")));
		
		String svgXpath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']/*[name()='g']//*[name()='path']";
		
		List<WebElement> regionList = driver.findElements(By.xpath(svgXpath));
		
		Actions act = new Actions(driver);
		for(WebElement e: regionList) {
			//act.moveToElement(e).perform();
			String name = e.getAttribute("name");
//			System.out.println(name);
//			if(name.equals("Montana")) {
//				act.click(e).perform();
//				break;
//			}
		}
		
		//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']/*[name()='g' and @id='texas']//*[name()='g' and @class='subregion']/*[name()='path']

	}

}
