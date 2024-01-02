package StepDidination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginImplimentation {
    WebDriver driver;
    @Given("I launch the browser and navigat to the URL")
    public void iLaunchTheBrowserAndNavigatToTheURL() {
        System.out.println("launch browser");
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver(setChromeOptions());
         driver.get("https://demo.actitime.com");

    }

    @When("I pass username {string} and password {string}")
    public void iPassUsernameAndPassword(String username, String password) {
        System.out.println(username);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

        System.out.println(password);
driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys(password);

driver.findElement(By.xpath("//a[@id=\"loginButton\"]")).click();
    }

    @Then("I verify the logged in application")
    public void i_verify_the_logged_in_application() {
String tital=driver.getTitle();
System.out.println(tital);
if(tital.equals("actiTIME - Login")){
    System.out.println("Navigate to application successfully");
}else{
    System.out.println("Fail");
}
    }
    public ChromeOptions setChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("incognito");
        option.setHeadless(false);
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-clocking"));
        Map<String, String> prefs = new HashMap<>();
        prefs.put("download.default.directory", "C:/Users/shubham/Downloads/");
        option.setExperimentalOption("prefs", prefs);
        option.setAcceptInsecureCerts(true);
        return option;}


    @When("I pass userName {string} and password {string} and click on the login button")
    public void iPassUserNameAndPasswordAndClickOnTheLoginButton(String username, String password) {
        System.out.println(username);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);

        System.out.println(password);
        driver.findElement(By.xpath("//input[@name=\"pwd\"]")).sendKeys(password);

        driver.findElement(By.xpath("//a[@id=\"loginButton\"]")).click();

    }

    @Then("I verify the not logged in application")
    public void iVerifyTheNotLoggedInApplication() {
        System.out.println("verify the not logged in application" );
         WebElement element= driver.findElement(By.xpath("//span[contains(text(),'Username or Password is invalid. Please try again.')]"));
String nameOfErrmsg=element.getText();
System.out.println(nameOfErrmsg);
if(nameOfErrmsg.equals("Username or Password is invalid. Please try again.")){
    System.out.println("Err msg should be display test case pass");
}else{
    System.out.println("Test case fail");
}
    }
}
