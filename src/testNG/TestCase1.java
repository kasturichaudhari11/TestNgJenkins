package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void beforeTest() {
		
		System.out.println("Insdire Before Test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Inside Before Method");
	}
	
	@Test
	public void test1() {
		
		System.out.println("Inside test1");
	}
	
	@Test(enabled = false)
	public void test2() {
		
		System.out.println("Inside test2");
	}
	
	@Test(enabled = true)
	public void test3() {
		
		System.out.println("Inside test3");
	}
	
	@Test(groups = {"Regression"})
	public void CreditTest1() {
		
		System.out.println("Inside CreditTest1");
	}
	
	@Test(groups = {"Regression"})
	public void CreditTest2() {
		
		System.out.println("Inside CreditTest2");
	}
	
	@Test(groups = {"Smoke"})
	public void CreditTest3() {
		
		System.out.println("Inside CreditTest3");
	}
	
	
	@Test(groups = {"Smoke"})
	public void LoanTest1() {
		
		System.out.println("Inside Loan Test");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("Inside After Method");
	}
	
	@AfterTest
	public void afterTest() {
		
		System.out.println("Insdire After Test");
	}

}
