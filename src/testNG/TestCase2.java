package testNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test(groups = {"Regression"})
	public void test3() {
		
		System.out.println("Inside Test3");
	}
	
	
	@BeforeSuite
	public void beforeSuiteName() {
		
		System.out.println("Inside Before Suite");
	}
	
	
	@AfterSuite
	public void AfterSuiteName() {
		
		System.out.println("Inside Before Suite");
	}

}
