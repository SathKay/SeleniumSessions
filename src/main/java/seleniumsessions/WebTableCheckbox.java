package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckbox {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		getEmp("Jasmine.Morgan");
		getEmp("Jordan.Mathews");
		
		System.out.println(getEmpInfo("Jasmine.Morgan"));
		System.out.println(getEmpInfo("Jordan.Mathews"));
	}
	
	public static void getEmp(String name) {
		WebElement checkbox = driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input"));
		checkbox.click();
	}
	
	public static List<String> getEmpInfo(String name) {
		List<WebElement> infoList = driver.findElements(By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td"));
		List<String> actInfoList = new ArrayList<String>();
		for(WebElement e: infoList) {
			String text = e.getText();
			actInfoList.add(text);
		}
		return actInfoList;
	}

}
