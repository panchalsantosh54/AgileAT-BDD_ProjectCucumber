package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class Utilities extends BasePage {
	public static void enterText(By by, String data) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		userName.sendKeys(data);
	}

	public static void clickOnElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicittimeout"))));
		WebElement loginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		loginBtn.click();
	}
}
