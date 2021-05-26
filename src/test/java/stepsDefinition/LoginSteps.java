package stepsDefinition;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.RegistrationPage;

public class LoginSteps {
	WebDriver driver;
	RegistrationPage objRegistration;
	AuthenticationPage objAuthentication;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objAuthentication = PageFactory.initElements(driver, pages.AuthenticationPage.class);
		driver.get("http://automationpractice.com/");
	}
	
	public void tearDown(){
    	driver.close();
    }
	
	@Given("browser is opened")
	public void browser_is_opened() {
	   setUp();
	}
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    objAuthentication.clickSignIn1Button();
	}
	
	@When("user enters email address and password")
	public void user_enters_email_address_and_password() {
	    objAuthentication.setEmailAddress2TextField("marija@nekoj.com");
	    objAuthentication.setPasswordPasswordField("1234567890");
	}

	@When("click on the sign in button")
	public void click_on_the_sign_in_button() {
	    objAuthentication.clickSignIn2Button();
	}

	@Then("user is navigated to the my account page")
	public void user_is_navigated_to_the_my_account_page() {
		Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("My account - My Store");
		assertTrue(verifyTitleIsPresent);
		tearDown();
	}

}
