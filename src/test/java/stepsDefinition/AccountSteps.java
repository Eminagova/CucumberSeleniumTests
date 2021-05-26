package stepsDefinition;

import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountCreation;
import pages.AuthenticationPage;
import pages.RegistrationPage;

public class AccountSteps {
	WebDriver driver;
	RegistrationPage objRegistration;
	AuthenticationPage objAuthentication;
	AccountCreation objAccount;
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objAuthentication = PageFactory.initElements(driver, pages.AuthenticationPage.class);
		objAccount = PageFactory.initElements(driver, pages.AccountCreation.class);
		driver.get("http://automationpractice.com/");
	}
	
	public void tearDown(){
    	driver.close();
    	
    }
	
	private String getRandomEmail(){
		Random random = new Random();
		int intRandom = random.nextInt(900000000); 
		return "rgtest" + intRandom + "@local.com";
	}
	
	
	@Given("browser is open")
	public void browser_is_open() {
	   setUp();
	}

	@Given("user is on the authentication page")
	public void user_is_on_the_authentication_page() {
	    objAuthentication.clickSignIn1Button();
	}

	@When("user enters email")
	public void user_enters_email() {
		String email = getRandomEmail();
	    objAuthentication.setEmailAddress1TextField(email);
	}

	@When("click on the create an account button")
	public void click_on_the_create_an_account_button() {
	    objAuthentication.clickCreateAnAccountButton();
	}

	@Then("user is navigated to the create an account page")
	public void user_is_navigated_to_the_create_an_account_page() {
	    
	}

	@Then("fill all required fields")
	public void fill_all_required_fields() {
		objAccount.verifyPageLoaded();
	   objAccount.setFirstName1TextField("Cucumber");
	   objAccount.setLastName1TextField("Testovski");
	   objAccount.setPasswordPasswordField("11223344455");
	   objAccount.setAddressTextField("Woltstr");
	   objAccount.setCityTextField("Phoenix");
	   objAccount.setStateDropDownListField("Arizona");
	   objAccount.setZippostalCodeTextField("00000");
	   objAccount.setCountryDropDownListField("United States");
	   objAccount.setMobilePhoneTextField("1234567890");
	   objAccount.setAssignAnAddressAliasForFutureTextField("My address");
	   objAccount.clickRegisterButton();
	}

	@Then("user should be successfully created")
	public void user_should_be_successfully_created() {
		Boolean verifyTitleIsPresent=driver.getTitle().equalsIgnoreCase("My account - My Store");
		assertTrue(verifyTitleIsPresent);
		tearDown();
	}



}
