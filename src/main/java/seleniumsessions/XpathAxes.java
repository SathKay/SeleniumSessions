package seleniumsessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2023-1345038/chennai-super-kings-vs-punjab-kings-41st-match-1359515/live-cricket-score");
		driver.manage().window().maximize();
		
		//WebElement wicketTaker = driver.findElement(By.xpath("//a[@title='Shivam Dube']/parent::td/following-sibling::td//span"));
		
		//System.out.println(wicketTaker.getText());
		
//		System.out.println(getWicketTaker("Devon Conway"));
//		System.out.println(getPlayerScoreCard("Devon Conway"));
//		
//		System.out.println(getWicketTaker("Ajinkya Rahane"));
//		System.out.println(getPlayerScoreCard("Ajinkya Rahane"));
//		
//		System.out.println(getWicketTaker("Ravindra Jadeja"));
//		System.out.println(getPlayerScoreCard("Ravindra Jadeja"));
		
//		System.out.println(getBowlingScoreCard("Ravindra Jadeja"));
//		System.out.println(getBowlingScoreCard("Wayne Parnell"));
		
		//System.out.println(getBattingScoreCard("Ravindra Jadeja"));
		//System.out.println(getBowlingScoreCard("Ajinkya Rahane"));
		//System.out.println(getPlayerScoreCard("Devon Conway"));
		
		//WebElement ele = driver.findElement(By.xpath("(//a//span[text()='Devon Conway']/ancestor::td/following-sibling::td)[1]"));
		By ele = By.xpath("(//a//span[text()='Shikhar Dhawan']/ancestor::td/following-sibling::td)[1]");
		
		for(int i =1; i<30;i++) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60), Duration.ofSeconds(10));
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(ele)).getText());
		//Thread.sleep(10000);
		}

	}
	
	public static List<String> getPlayerScoreCard(String playerName) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//a//span[text()='"+playerName+"']/ancestor::td/following-sibling::td"));
		System.out.println(scoreList.size());
		List<String> actScoreList = new ArrayList<String>();
		for(int i=1;i<scoreList.size();i++) {
			String text = scoreList.get(i).getText();
			actScoreList.add(text);
		}
		return actScoreList;
	}
	
	public static List<String> getBattingScoreCard(String playerName) {
		List<WebElement> battingStats = driver.findElements(By.xpath("//th[text()='BATTING']/ancestor::thead/following-sibling::tbody//a//span[text()='"+playerName+"']/ancestor::td/following-sibling::td"));
		System.out.println(battingStats.size());
		List<String> actBattingStats = new ArrayList<String>();
		for(WebElement e:battingStats) {
			String text = e.getText();
			actBattingStats.add(text);
		}
		return actBattingStats;
	}
	
	
	public static List<String> getBowlingScoreCard(String playerName) {
		List<WebElement> bowlingStats = driver.findElements(By.xpath("//th[text()='BOWLING']/ancestor::thead/following-sibling::tbody//a/span[text()='"+playerName+"']/ancestor::td/following-sibling::td"));
		System.out.println(bowlingStats.size());
		List<String> actBowlingStats = new ArrayList<String>();
		for(WebElement e: bowlingStats) {
			String text = e.getText();
			actBowlingStats.add(text);
		}
		return actBowlingStats;
	}
	
	public static String getWicketTaker(String playerName) {
		WebElement wicketTaker = driver.findElement(By.xpath("//a[@title='"+playerName+"']/parent::td/following-sibling::td/span//span"));
		return wicketTaker.getText();
	}

}
