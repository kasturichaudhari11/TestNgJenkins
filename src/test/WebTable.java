package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(2000);
		
				
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
		System.out.println("Total num of rows are " + rows.size());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		
		System.out.println("Total num of columns are " + cols.size());
		
		WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]"));
		
		System.out.println("Cell Value " + cell.getText());
		
		// Scroll Example
		
		
		WebElement location = driver.findElement(By.xpath("//h2[text()='HTML Table - Add a Border']"));
		
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		
		obj.executeScript("arguments[0].scrollIntoView();", location);
		

	}
	
	
	
	

}
