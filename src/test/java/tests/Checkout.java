package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AuthenticationPage;
import pages.CheckPayment;
import pages.ItemPage;
import pages.MyAccount;
import pages.OrderPage;
import pages.PaymentMethod;
import pages.ShippingOption;
import pages.ShippingPage;
import pages.WomenPage;

public class Checkout {
	public static WebDriver driver;
	AuthenticationPage  objAuthentication;
	MyAccount objMyAccount;
	WomenPage objWomen;
	ItemPage objItem;
	ItemPage objItemPage2;
	OrderPage objOrder;
	ShippingPage objShipping;
	ShippingOption objShippingOption;
	PaymentMethod objPaymentMethod;
	CheckPayment objCheckPayment;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objAuthentication = PageFactory.initElements(driver,AuthenticationPage.class);
		driver.get("http://automationpractice.com/");
		objMyAccount= PageFactory.initElements(driver,MyAccount.class);
		objWomen= PageFactory.initElements(driver,WomenPage.class);
		objItem = PageFactory.initElements(driver,ItemPage.class);
		objItemPage2 = PageFactory.initElements(driver,ItemPage.class);
		objOrder = PageFactory.initElements(driver,OrderPage.class);
		objShipping= PageFactory.initElements(driver,ShippingPage.class);
		objShippingOption= PageFactory.initElements(driver,ShippingOption.class);
		objPaymentMethod= PageFactory.initElements(driver,PaymentMethod.class);
		objCheckPayment= PageFactory.initElements(driver,CheckPayment.class);


	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void checkoutByCheck() throws InterruptedException {
		addItemToCart();
		objItem.clickWomen1Link();
		objWomen.verifyPageLoaded();
		objWomen.clickBlouseLink();
		objItemPage2.verifyPageLoaded();
		objItemPage2.clickAddToCartButton();
		objItemPage2.clickProceedToCheckoutLink();
		objOrder.verifyPageLoaded();
		objOrder.clickProceedToCheckout2Link();
		objShipping.verifyPageLoaded();
		objShipping.clickProceedToCheckout2Button();
		objShippingOption.setIAgreeToTheTermsOfCheckboxField();
		objShippingOption.clickProceedToCheckout2Button();
		objPaymentMethod.clickPayByCheckOrderProcessingLink();
		objCheckPayment.clickIConfirmMyOrderButton();
		
		}

	@Test
	public void checkoutByBank() throws InterruptedException {
	addItemToCart();
	objItemPage2.clickProceedToCheckoutLink();
	objOrder.verifyPageLoaded();
	objOrder.clickProceedToCheckout2Link();
	objShipping.verifyPageLoaded();
	objShipping.clickProceedToCheckout2Button();
	objShippingOption.setIAgreeToTheTermsOfCheckboxField();
	objShippingOption.clickProceedToCheckout2Button();
	objPaymentMethod.clickPayByBankWireOrderLink();
	objCheckPayment.clickIConfirmMyOrderButton();
	}
	
	private void addItemToCart() {
		objAuthentication.clickSignIn1Button();
		objAuthentication.verifyPageLoaded();
		objAuthentication.setEmailAddress2TextField("marija@nekoj.com");
		objAuthentication.setPasswordPasswordField("1234567890");
		objAuthentication.clickSignIn2Button();
		objMyAccount.verifyPageLoaded();
		objMyAccount.clickWomen1Link();
		objWomen.verifyPageLoaded();
		objWomen.clickFadedShortSleeveTshirtsLink();
		objItem.verifyPageLoaded();
		objItem.clickAddToCartButton();
	
	}
	
	
	}
