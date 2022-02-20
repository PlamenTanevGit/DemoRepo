package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountSummaryPage;
import pages.LoginPage;
import pages.TopNavigationItems;

public class LoginPageTests extends Base {

	@BeforeClass
	public void testSetUp() {
		baseUrl = "http://zero.webappsecurity.com/login.html";					
		actions = new Actions(driver);
	}

	@Test(priority = 0)
	public void validLoginAndTitleVerify () {
		/**after click on the signIn button there is an 
		 * automatic check for all Account summary page details*/
		
		edriver.get(baseUrl);
		loginPage = new LoginPage();	
		loginPage.doLogin(or.getProperty("username"), or.getProperty("password"));	
		
		/**create AccountSummaryPage() object
		 * to verify the page title */
		accountSummary = new AccountSummaryPage();
		Assert.assertEquals(accountSummary.CashAccountsTitle.getText(), "Cash Accounts");
		
		/**Logout steps - click on the profile and click logout*/
		topNavigationItems = new TopNavigationItems();
		topNavigationItems.logOut();
		
		
	}
	
	@Test(priority = 1)
	public void globalSearch() {
		edriver.get(baseUrl);
		loginPage = new LoginPage();
		
		loginPage.doLogin(or.getProperty("username"), or.getProperty("password"));	
		topNavigationItems = new TopNavigationItems();
		topNavigationItems.doGlobalSearch(or.getProperty("loan"));
		
		/**Assertion for valid result 
		 * is displayed */
		
		WebElement searchResultValid = driver.findElement(By.xpath(or.getProperty("searchResultValid")));
		Assert.assertEquals(searchResultValid.getText(),or.getProperty("searchResultsValidText"));
	
		
		/**Assertion for 
		 *  Title on the Results page*/
		Assert.assertEquals(driver.findElement(By.xpath(or.getProperty("searchResultsTitle"))).getText(),
				"Search Results:");
	
		
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
