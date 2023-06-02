package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WAP
		//1.Total links in the page
		//2.Print the text of each link(ignore the blanks/empty text)
		//3.print the href value of the each link
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.amazon.in/ref=nav_logo");
		
		driver.manage().window().maximize();
		
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println(linksList.size());
//		int c= 0;
//		for(WebElement e : linksList) {
//			String text = e.getText();
//			if(!text.isEmpty()) {
//				System.out.println(c +":"+text);
//			}
//			String href = e.getAttribute("href");
//			System.out.println(href);
//			c++;
//			System.out.println();
//		}
		
//		for(int i=0;i<linksList.size();i++) {
//			String text = linksList.get(i).getText();
//			if(!text.isEmpty()) {
//				System.out.println(i+":"+text);
//			}
//			String href = linksList.get(i).getAttribute("href");
//			System.out.println(href);
//			System.out.println();
//		}
		
		By links = By.tagName("a");
		By images = By.tagName("img");
		
		System.out.println(getElementCount(links));
		System.out.println(getElementCount(images));
		
		//System.out.println(getElementsTextList(links).size());
		
//	    if(getElementsTextList(links).contains("Best Sellers")) {
//	    	System.out.println(" is present");
//	    }
//	    
//	    if(getElementsAttributeList(images, "alt").contains("Watches")) {
//	    	System.out.println("is present");
//	    }
	    
	    System.out.println(getElementsAttributeList(links, "href").size());
	    List<String> hrefList = getElementsAttributeList(links, "href");
	    for(String e:hrefList) {
	    	System.out.println(e);
	    }
	    
//	    System.out.println(getElementsAttributeList(images, "alt").size());
//	    System.out.println(getElementsAttributeList(images, "alt"));
	    
//	    System.out.println(getElementsAttributeList(images, "src").size());
//	    System.out.println(getElementsAttributeList(images, "src"));
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementCount(By locator) {
		return getElements(locator).size();
	}
	
	/*To print the text of links*/
	public static void printElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement e:eleList) {
			String text = e.getText();
			System.out.println(text);
			}
	}
	
	/*To get the elements text in a list*/
	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e:eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	
	/**
	 * To get the list of given attribute value of the elements
	 * @param locator
	 * @param attribute
	 * @return List<String>
	 */
	public static List<String> getElementsAttributeList(By locator, String attribute) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String attVal = e.getAttribute(attribute);
			eleAttList.add(attVal);
		}
		return eleAttList;
		}

}
