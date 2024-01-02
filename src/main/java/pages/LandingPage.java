package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {
	AdminPage adminPage;

	By linkAdmin = By.xpath("(//div[@class='oxd-sidepanel-body']//span)[1]");

	public LandingPage() {
		super();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public AdminPage clickOnAdmin() {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(linkAdmin)).click();
		return new AdminPage();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

}
