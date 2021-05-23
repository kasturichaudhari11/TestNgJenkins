package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestNgListenerExample.class)
public class LoginTest {
	
	WebDriver driver;
	XSSFWorkbook Workbook;
	XSSFSheet sheet1;

	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.get("https://www.simplilearn.com/");
		Thread.sleep(2000);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		Workbook = new XSSFWorkbook(fis);
		sheet1 = Workbook.getSheetAt(0);
	}
	
	@Test(enabled = false)
	@Parameters({"uname","pwd"})
	public void loginDefaults() {
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("abc@xyz.com");
		
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys("abc123");
		
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		chkBox.click();
		
		WebElement loginbutton = driver.findElement(By.name("btn_login"));
		loginbutton.click();
		
		WebElement errormsg = driver.findElement(By.id("msg_box"));
		
		String actError = errormsg.getText();
		String expError = "The email or password you have entered is invalid.";
		
		if (actError.equals(expError)) {
			System.out.println("pass");
		} else {
			
			System.out.println("fail");
		}
		
	}
	
	@Test(enabled = false)
	@Parameters({"uname","pwd"})
	public void loginParameters(@Optional("optional@xyz.com") String usernameVal, @Optional("optional123") String passwordVal) {
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys(usernameVal);
		
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		password.sendKeys(passwordVal);
		
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		chkBox.click();
		
		WebElement loginbutton = driver.findElement(By.name("btn_login"));
		loginbutton.click();
		
		WebElement errormsg = driver.findElement(By.id("msg_box"));
	
		String actError = errormsg.getText();
		String expError = "The email or password you have entered is invalid.";
		
		if (actError.equals(expError)) {
				System.out.println("pass");
		} else {
			
			System.out.println("fail");
		}
		
	}
	
	@Test
	public void loginExcel() {
		
		WebElement loginlink = driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		WebElement username = driver.findElement(By.name("user_login"));
		
		String user = sheet1.getRow(0).getCell(0).getStringCellValue();
		username.sendKeys(user);
		
		
		WebElement password = driver.findElement(By.name("user_pwd"));
		
		String pass = sheet1.getRow(0).getCell(1).getStringCellValue();
		password.sendKeys(pass);
		
		WebElement chkBox = driver.findElement(By.className("rememberMe"));
		chkBox.click();
		
		WebElement loginbutton = driver.findElement(By.name("btn_login"));
		loginbutton.click();
		
		WebElement errormsg = driver.findElement(By.id("msg_box"));
		
		String actError = errormsg.getText();
		String expError = "The email or password you have entered is invalid.";
		
//		if (actError.equals(expError)) {
//			System.out.println("pass");
//		} else {
//			
//			System.out.println("fail");
//		}
		
		Assert.assertEquals(actError, expError);
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}

}
