package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	private WebDriver driver; //the default value for a non-primitive datatype is null
	
	/**
	 * This method is to start the driver for the given browser
	 * @param browser
	 * @return this return the WebDriver
	 */
	public WebDriver launchBrowser(String browser) {
		System.out.println("The given browser is "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathy\\Downloads\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sathy\\Downloads\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Given browser is not available");
			//null value will be returned for this case
		}
		
		return driver;
		
	}
	
	public WebDriver launchBrowser_SwitchCase(String browser) {
		System.out.println("The given browser is "+ browser);
		
		switch(browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathy\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sathy\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("The given browser is not available");
			break;
		}
		
		return driver;
			
		}
	
	/**
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		System.out.println("The given url is "+ url);
		
		//Conditional statement for input without http or https in the url
		if(url.contains("http") || url.contains("https")) {
			driver.get(url);
		}
		else {
			System.out.println("Incorrect Url. Please Correct");
		}
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrower() {
		driver.close();
	}
	}


