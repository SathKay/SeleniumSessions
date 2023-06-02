package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathy\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
	    String title = driver.getTitle();
	    System.out.println("Title of the page is "+title);
	    
	    //Verification
	    if(title.equals("Google")) {
	    	System.out.println("Correct Page");
	    }
	    else {
	    	System.out.println("Incorrect Page");
	    }
	    
	    System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getPageSource());
	    
	    if(driver.getPageSource().contains("Google Inc")) {
	    	System.out.println("is present");
	    }
	    else {
	    	System.out.println("Not Present");
	    }
	    
	    driver.quit();
	}

}
