package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationStepDefinitions 
{
	private WebDriver driver;

	@Given("User is on the registration page")
	public void userIsOnRegistrationPage() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.gametwist.com/en/");

		driver.manage().window().maximize();
   
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//   driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();

		driver.findElement(By.xpath("(//button[text()='Register'])[1]")).click();
	}

	@When("User enters valid registration details")
	public void userEntersValidRegistrationDetails() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("anushreej3295@gmail.com");
        
        Random ran = new Random();
      
        driver.findElement(By.name("nickname")).sendKeys("Anu"+ ran.nextInt(100)+"shree");
        driver.findElement(By.name("password")).sendKeys("password123");
        
        WebElement dayDropdown = driver.findElement(By.name("day"));
        WebElement monthDropdown = driver.findElement(By.name("month"));
        WebElement yearDropdown = driver.findElement(By.name("year"));

        Select daySelect = new Select(dayDropdown);
        Select monthSelect = new Select(monthDropdown);
        Select yearSelect = new Select(yearDropdown);

        daySelect.selectByValue("3");
        monthSelect.selectByVisibleText("February");
        yearSelect.selectByValue("1995");
        
      /*  String selectedDay = daySelect.getFirstSelectedOption().getText();
        String selectedMonth = monthSelect.getFirstSelectedOption().getText();
        String selectedYear = yearSelect.getFirstSelectedOption().getText();
        */
        
        Thread.sleep(30000);
        //used it to handle Capctha manually
        
        driver.findElement(By.id("termsAccept")).click();
	}

	@When("User clicks on the submit button")
	public void userClicksOnSubmitButton() {
		driver.findElement(By.xpath("//button[text()='Begin adventure']")).click();
	}

	@Then("User should be registered successfully")
	public void userShouldBeRegisteredSuccessfully() {
		String expectTitle = "Registration | GameTwist Casino";		
		String actualTitle = driver.getTitle();
		Assert.assertEquals("User not Registered",expectTitle, actualTitle);
	}


}



