package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import base.Base;

public class HomePage extends Base{

	@FindBy (css = "#signin_button") public WebElement SignInBtn;
	@FindBy (css = "input#searchTerm") public WebElement searchField;
	@FindBy (css = "li#homeMenu  strong") 	public WebElement HomeTab;
	@FindBy (css = "li#onlineBankingMenu  strong") 	public WebElement OnlineBankingTab;
	@FindBy (css = "li#feedback  strong") 	public WebElement FeedbackTab;	
	@FindBy (css = "a#online-banking") 	public WebElement MoreServicesBtn;
	/*text elements*/
	@FindBy (css = "#account_activity_link") 	public WebElement CheckingAccountActivityLink;
	@FindBy (css = "#transfer_funds_link") 	public WebElement TransferFundsLink;
	@FindBy (css = "#money_map_link") 	public WebElement myMoneyMapLink;
	@FindBy (css = "#online_banking_features .span3:nth-of-type(1) h4") 	public WebElement onlineBankingLink;
	
	public void clickOnSignIn () {
		SignInBtn.click();
	}
	public void clickOnMoreServices() {
		MoreServicesBtn.click();
	}
	
	public void globalSearch (String value) {
		try {
			searchField.sendKeys(value);
		} catch (ElementNotFoundException e) {
			// TODO: handle exception
		}
		
	}
	
	public HomePage () {
		softAssert = new SoftAssert();
		// the AjaxElementLocatorFactory explained : 
		//https://stackoverflow.com/questions/54914570/how-to-implement-ajaxelementlocatorfactory-through-selenium-and-page-factory#:~:text=AjaxElementLocatorFactory%20is%20the%20lazyloading%20concept,PageFactory.
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		softAssert.assertEquals(SignInBtn.isDisplayed(), true);
		softAssert.assertEquals(searchField.isDisplayed(), true);
		softAssert.assertEquals(HomeTab.isDisplayed(), true);
		softAssert.assertEquals(OnlineBankingTab.isDisplayed(), true);
		softAssert.assertEquals(FeedbackTab.isDisplayed(), true);
		softAssert.assertAll();
		
		Reporter.log("All elements on Home page are displayed");
		System.out.println("All elements on Home page are displayed");
	}
}
