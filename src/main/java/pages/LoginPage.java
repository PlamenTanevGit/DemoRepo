package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import base.Base;

public class LoginPage extends Base {
	
	@FindBy (xpath = "//h3[contains(text(),'Log in to ZeroBank')]") public WebElement Title;
	@FindBy (css = "#user_login") public WebElement username;
	@FindBy (css = "#user_password") 	public WebElement password;
	@FindBy (css = "#user_remember_me") 	public WebElement keepMeSignInCheckbox;
	@FindBy (css = "input[type='submit'][name='submit']") 	public WebElement signInBtn;
	@FindBy (css = "a[href='/forgot-password.html']") 	public WebElement forgotYorPassword;
		
	
	public void doLogin (String user, String pass) {
		try {
			username.sendKeys(user);
			password.sendKeys(pass);
			clickOnSignIn();
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	/**this method 
	 * returns AccountSummaryPage after click on the SignIn btn 
	 * and automaticall verify the existance of all elements on 
	 * AccountSummaryPage (because of the constructor of AccountSummaryPage)*/
	public AccountSummaryPage clickOnSignIn () {
		signInBtn.click();
		return new AccountSummaryPage();
		
	}
	
	
	/**
	 * Constructor to verify all elements on the page and 
	 * also to initialize them*/
	
	public LoginPage () {
		softAssert = new SoftAssert();
		/**PageFacotry.initElements(driver,this) will initialize the elements on the page*/
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
		/**SignInPage validations*/
		String actualTitle = Title.getText();
		softAssert.assertEquals(actualTitle, "Log in to ZeroBank");
		softAssert.assertEquals(Title.isDisplayed(), true);
		softAssert.assertEquals(username.isDisplayed(), true);
		softAssert.assertEquals(password.isDisplayed(), true);
		softAssert.assertEquals(keepMeSignInCheckbox.isDisplayed(), true);
		softAssert.assertEquals(signInBtn.isDisplayed(), true);
		softAssert.assertEquals(forgotYorPassword.isDisplayed(), true);
		softAssert.assertAll();
		
		Reporter.log("All Elements from Login page exist on the page");
		System.out.println("All Elements from Login page exist on the page");
		
	}
	
	
	
}
