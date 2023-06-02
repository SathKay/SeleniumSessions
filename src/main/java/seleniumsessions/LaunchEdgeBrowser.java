package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdgeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.msedge.driver", "C:\\Users\\sathy\\Downloads\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://google.com");
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
		
		driver.quit();

	}

}
