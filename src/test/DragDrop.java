package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		Thread.sleep(2000);
		
		
		WebElement fromLocation = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		
		WebElement toLocation = driver.findElement(By.xpath("//*[@id='bank']/li"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(fromLocation, toLocation).build().perform();
		

	}

}
