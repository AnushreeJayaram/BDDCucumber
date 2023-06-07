package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions 

{
	private WebDriver driver;

	@Given("User is on the login page")
	public void userIsOnLoginPage() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		 driver.get("https://www.gametwist.com/en/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
	}

	@When("User enters valid login details")
	public void userEntersValidLoginDetails() {
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		 driver.findElement(By.id("username")).sendKeys("Anu3366");
	       driver.findElement(By.id("password")).sendKeys("GameTwist123");
	}

	@When("User clicks on the login button")
	public void userClicksOnLoginButton() {
	    driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}

	@Then("User should be logged in successfully")
	public void userShouldBeLoggedInSuccessfully() {
		String expectTitle = "Login | GameTwist Casino";		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals("User not Logged",expectTitle, actualTitle);
	}

}
