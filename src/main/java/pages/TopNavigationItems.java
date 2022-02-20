package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import base.Base;

public class TopNavigationItems extends Base{
	/**top row elements 
	 * visible from all pages */
	@FindBy (xpath = "//input[@id='searchTerm']") public WebElement globalSearch;
	@FindBy (css = "li:nth-of-type(2) > .dropdown-toggle") public WebElement globalSettings ;
	@FindBy (css = "li:nth-of-type(3) > .dropdown-toggle") public WebElement globalUserName;
	@FindBy (css = ".brand") public WebElement ZeroBankLogoBtn;	
	/**Tabs*/
	@FindBy (css = "li#account_summary_tab > a") public WebElement AccountSummaryTab;
	@FindBy (css = "li#account_activity_tab > a") public WebElement AccountActivityTab;
	@FindBy (css = "li#transfer_funds_tab > a") public WebElement TransferFundsTab;
	@FindBy (css = "li#pay_bills_tab > a") public WebElement PayBillsTab;
	@FindBy (css = "li#money_map_tab > a") public WebElement MyMoneyMapTab;
	@FindBy (css = "li#online_statements_tab > a") public WebElement OnlineStatementsTab;
	
	
	public void doGlobalSearch (String searched) {
		actions = new Actions(driver);
		
		try {
			globalSearch.sendKeys(searched + Keys.ENTER);
			
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**@info 
	 * Method for Logoout from the top nav bar*/
	public void logOut () {
		try {
			globalUserName.click();
			WebElement LogOut = edriver.findElement(By.xpath(or.getProperty("Logout")));	
			js.executeScript("arguments[0].click();", LogOut);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}

	
	}
	
	
	
	/**constructor to initiliaze all page elements and 
	 * verify they are displayed */
	public TopNavigationItems() {
		softAssert = new SoftAssert();
		/**PageFacotry.initElements(driver,this) will initialize the elements on the page*/
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);	
 
		softAssert.assertEquals(globalSearch.isDisplayed(), true);
		softAssert.assertEquals(globalSettings.isDisplayed(), true);
		softAssert.assertEquals(globalUserName.isDisplayed(), true);
		softAssert.assertEquals(AccountSummaryTab.isDisplayed(), true);
		softAssert.assertEquals(AccountActivityTab.isDisplayed(), true);
		softAssert.assertEquals(TransferFundsTab.isDisplayed(), true);
		softAssert.assertEquals(PayBillsTab.isDisplayed(), true);
		softAssert.assertEquals(MyMoneyMapTab.isDisplayed(), true);
		softAssert.assertEquals(OnlineStatementsTab.isDisplayed(), true);
		softAssert.assertAll();
		
		Reporter.log("Top Navigiation Items are displayed");
		System.out.println("Top Navigiation Items are displayed");
		
	}

}
