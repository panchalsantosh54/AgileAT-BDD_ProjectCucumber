package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginPageTest extends BasePage {
	LoginPage   loginPage;
	LandingPage landingPage;
	
	@BeforeMethod
	public void setUp()
	{
		init();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDwon()
	{
		driver.quit();
	}
	
	@Test
	public void verifyLogin()
	{
		landingPage = loginPage.LoginToAppl("Admin", "admin123");
	    String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	    Assert.assertEquals(landingPage.getUrl(),expUrl,"landing page title is not matching with " + expUrl);   
	}
	
	@Test(dataProvider="getCredentials")
	public void verifyInvalidLogin(String un,String pwd)
	{
		loginPage.enterUserName(un);
		loginPage.enterPassword(pwd);
		loginPage.clickOnLoginBtn();
		
		if (un.isBlank() || pwd.isBlank())
			Assert.assertEquals("Required123", loginPage.getErrorMsg(), "Wrong ErrorMessage for Blank Username/psasword!!!");
		else 
			Assert.assertEquals("Invalid credentials", loginPage.getErrorMsgForInvalidCredentials(), "Wrong ErrorMessage for Invalid username and password !!!");
	}
	
	@DataProvider(name="getCredentials")
	public Object[][] getData()
	{
		Object[][] data = {
				{"abc","abc"},
				{"abc","   "},
				{"   ","abc"}
		};
		return data;
	}
}
