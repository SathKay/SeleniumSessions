package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		//driver.get("https://www.google.com");
		//driver.get("https://www.freshworks.com/");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		driver.manage().window().maximize();
		//driver.get("https://www.amazon.in/ref=nav_logo");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title = js.executeScript("return document.title").toString();
//		System.out.println(title);
		
//		String title = getTitleByJS();
//		System.out.println(title);
//		
//		String pageText = getPageTextByJS();
//		if(pageText.contains("Start your 21-day free trial.")) {
//			System.out.println("pass");
//		}
//		else {
//			System.out.println("Fail");
//		}
		
		//generateAlert("Hi, this is selenium alert");
		
		//refreshBrowserByJS();
		
//		WebElement ele = driver.findElement(By.xpath("//h1[@class='sc-4555ca6a-0 hZEuqN']"));
//		drawBorderByJS(ele);
		
//		WebElement ele = driver.findElement(By.cssSelector("div#content form"));
//		drawBorderByJS(ele);
		
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		flash(emailId);
//		emailId.sendKeys("sk@gmail.com");
//		flash(password);
//		password.sendKeys("test@123");
		
//		scrollPageDown();
//		Thread.sleep(3000);
//		scrollPageUp();
		
		//scrollPageDown("700");
		
//		WebElement ele = driver.findElement(By.xpath("//h2[text()='Today’s Deals']"));
//		scrollIntoView(ele);
//		drawBorderByJS(ele);
		//driver.findElement(By.xpath("(//h2[text()='Today’s Deals']/parent::div/following-sibling::div//li)[1]")).click();
//		WebElement ele = driver.findElement(By.linkText("China"));
//		clickElementByJS(ele);
		sendKeysWithIdByJS("input-email", "sk@gmail.com");
		
	}
	
	public static String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title").toString();
	}
	
	public static String getPageTextByJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.documentElement.innerText").toString();
	}
	
	public static void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static void drawBorderByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void flash(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<20;i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor,element);
		}
	}
	
	private static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		}catch(InterruptedException e){
			
		}
	}
	
	public static void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public static void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,"+height+")");
	}
	
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	public static void sendKeysWithIdByJS(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
	}

}
