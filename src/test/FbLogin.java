package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FbLogin {

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FbLogin obj = new FbLogin();
		obj.setup();
		obj.login();
		//obj.signup();
	}
	
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
	}
	
	public void login() {
		
		
//		WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
//		WebElement password = driver.findElement(By.xpath("//input[@name='pass']"));
//		WebElement loginbutton = driver.findElement(By.xpath("//*[@name='login']"));
//		
	
		
		// Tag and ID CSS selector
		//Syntax :”css = tag#id”
		
		// Tag and Class
		// Syntax : “css = tag.class”

		//Tag and Attribute
		// Syntax : “css = tag[attribute=value]”

		
		
		WebElement username = driver.findElement(By.cssSelector("input#email"));
		WebElement password = driver.findElement(By.cssSelector("input#pass"));
		WebElement loginbutton = driver.findElement(By.cssSelector("button[name=login]"));
		
		
		username.sendKeys("abc@xyz.com");
		password.sendKeys("pwd");
		loginbutton.click();
		
		
	}
	
	public void signup() {
		
		// use of text() function in xpath
		
		WebElement signupbutton = driver.findElement(By.xpath("//*[text()='Create New Account']"));
		signupbutton.click();
		
		
		// use of select class for drop downs
		
		WebElement DayDropDown = driver.findElement(By.xpath("//*[@title='Day']"));
		Select day = new Select(DayDropDown);
		
		day.selectByVisibleText("1");
//		day.selectByIndex(0);
//		day.selectByValue("1");
		
		// radio button selection
		
		WebElement GenderMale = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		GenderMale.click();
		
		//input[@type='radio' and @value='1']//following::input[1]
		//input[@type='radio' and @value='2']//preceding::input[1]
		
		
		// use of Contains in Xpath
		
		//*[text()='Connect with friends and the world around you on Facebook.']
		//*[contains(text(),'friends')]
		//*[starts-with(text(),'Connect')]
		
	}

}
