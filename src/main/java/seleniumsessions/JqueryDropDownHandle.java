package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		driver.findElement(By.id("justAnInputBox")).click();
		
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		
//		List<WebElement> choicesList = driver.findElements(choices);
//		
//		for(WebElement e: choicesList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("choice 1")) {
//				e.click();
//				break;
//			}
//		}
		
		//selectChoice(choices, "choice 2");
//		selectChoice(choices, "choice 2");
		//selectChoice(choices, "choice 2 2");
		
		//selectChoice(choices, "choice 1", "choice 2 2", "choice 7");
		selectChoice(choices, "all");
		//selectChoice(choices, "c");

	}
	
//	public static void selectChoice(By locator , String... value ) {
//		List<WebElement> choicesList = driver.findElements(locator);
//		for(WebElement e: choicesList) {
//			String text = e.getText();
//			
//			for(int i=0;i<value.length;i++) {
//				if(text.equals(value[i])) {
//					e.click();
//					break;
//				}
//			}
//		}
//	}
	
	/**
	 * This method will do single choice selection, multiple choice selection and all choice selection
	 * (for all choice selection, pass 'all' as the input string)
	 * @param locator
	 * @param value
	 */
	public static void selectChoice(By locator , String... value) {
		
		List<WebElement> choiceList = driver.findElements(locator);
		
		boolean flag = false;
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement e : choiceList) {
				String text = e.getText();
				for(int i=0;i<value.length;i++) {
					if(text.equals(value[i])) {
						e.click();
						flag = true;
						break;
					}
					else {
						flag=false;
					}
				}
			}
		}
		else {
			try{for(WebElement e: choiceList) {
				e.click();
				flag = true;
			}
			}catch(ElementNotInteractableException e) {
				System.out.println("All the choices are over" );
			}
			
		}
		if(flag==false) {
			System.out.println("The choice is not available " );
		}
	}

}
