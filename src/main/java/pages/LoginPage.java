package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class LoginPage extends BasePage {
	By txtUserName = By.name("username");
	By txtpassword = By.name("password");
	By btnLogin    = By.cssSelector("button[type='submit']");
	By txtError    = By.xpath("(//div[@class='oxd-form-row']//span)[1]");
	By txtInvalidError = By.xpath("(//div[@class='orangehrm-login-form']//p)[1]");
	
	public LoginPage()
	{
		super();
	}
	
	public  void enterUserName(String un)
	{
	 	Utilities.enterText(txtUserName, un);
		 
	}
	public void enterPassword(String pwd)
	{
	 	Utilities.enterText(txtpassword, pwd);
	}
	public  void clickOnLoginBtn()
	{
	 	Utilities.clickOnElement(btnLogin);
		 
	}
	public LandingPage LoginToAppl(String un, String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage();
	}
	
	public String getErrorMsg()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(txtError)).getText();
	}
	
	public String getErrorMsgForInvalidCredentials()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		return wait.until(ExpectedConditions.presenceOfElementLocated(txtInvalidError)).getText();
	}

}
