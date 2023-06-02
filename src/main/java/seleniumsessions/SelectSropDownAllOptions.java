package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectSropDownAllOptions {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//To get all the select drop down options and perform actions on it
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(option);
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(4000);
		
		By country = By.id("Form_getForm_Country");
		
//		Select select = new Select(driver.findElement(country));
//		
//		List<WebElement>optionsList = select.getOptions();
//		
//		System.out.println(optionsList.size());
//		
//		int count = 0;
//		for(WebElement e : optionsList) {
//			System.out.println(count+ " : "+e.getText());
//			count++;
//		}
		
		//doPrintDropDownOptionsList(country);
		
		System.out.println(getDropDownOptionsList(country));
		
		if(getDropDownOptionsList(country).contains("India")) {
			System.out.println("India is present in the Dropdown");
		}
		
		selectValueFromDropDown(country, "Croatia");
		
		By country_options = By.xpath("//select[@id='Form_getForm_Country']/option");
		clickValueFromDropDown(country_options, "Namibia");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * This method prints the drop down options text
	 * @param locator
	 */
	public static void doPrintDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());
		
		int i=0;
		for(WebElement e : optionsList) {
			System.out.println(i+" : "+e.getText());
			i++;
		}
	}
	
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}
	
	
	/**
	 * This method returns the drop down options as a list
	 * @param locator
	 * @return List<String> 
	 */
	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		
		for(WebElement e: optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
		
	}
	
	/**
	 * This method selects the drop down option using its text
	 * @param locator
	 * @param value
	 */
	public static void selectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
			}
		}
	}
	
	/**
	 * This method click on the drop down option . It doesn't uses Select class
	 * @param locator
	 * @param value
	 */
	public static void clickValueFromDropDown(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		for(WebElement e: optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
