package pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.Base;

/*
 *  The Format of 1 POM page is 
 *   - constructor
 *   - By Locators...
 *   - Page actions /methods/
 *   
 *   
 *   The sequence of POM 
 *    1. Base class
 *    2. Base Test
 *    3. Pages - Login,Account.... etc that extends the Base class
 *    4. Config Properties file
 *    5. Test class
 */


/** @FindBys - how it works ? 
 * First find the the first given element then WHITHIN that element block 
 * will look
 * for the 2nd element
 */

/**
 * @FindAll - how it works ? 
 * creates object of multiple @FindBy and if one them is valid and
 *          working selector will use that one if one of the locators is
 *          incorect then it search for the other one
 */
/*
 * https://stackoverflow.com/questions/25914156/difference-between-findall-and-
 * findbys-annotations-in-webdriver-page-factory/25915562
 * https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/
 * FindAll.html
 * http://makeseleniumeasy.com/2018/01/09/findall-annotation-in-page-factory-in-
 * selenium-webdriver/
 */
/**
 * List of all elements uisng @FindBy
 * https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
 */

public class AccountSummaryPage extends Base {
	/**
	 * initilize object of TopNavigationItems because this ribbon bar of
	 * TopNavigationItems exist on every page load
	 */
	public TopNavigationItems topNavigationItems;

	@FindBy(xpath = "//a[contains(text(),'Account Summary')]")
	public WebElement AccountSummaryTab;
	@FindBy(xpath = "//h2[contains(text(),'Cash Accounts')]")
	public WebElement CashAccountsTitle;
	@FindBy(css = "a[href='/bank/account-activity.html?accountId=1']")
	public WebElement savingsLink;
	@FindBy(css = "a[href='/bank/account-activity.html?accountId=3']")
	public WebElement savingsLink2;

	/** finr Transfer Funds Tab using @FindAll */
	@FindAll({ @FindBy(css = "li#transfer_funds_tab > aERROR"), // this is Wrong selector
			@FindBy(css = "li#transfer_funds_tab > a") // this is the correct selector
	})
	public WebElement transferFundsTab1;

	/** find All links on the page with @FindBy */
	@FindBy(tagName = "a")
	public List<WebElement> allLinks;

	/** find all tabs on page using @FindBys */
	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(css = "li#account_activity_tab > a") // Account Activity tab
	})
	public WebElement accountActivityTab;

	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(css = "li#transfer_funds_tab > a") // Transfer Funds
	})
	public WebElement transferFundsTab;

	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(css = "li#pay_bills_tab > a") // Pay Bills tab
	})
	public WebElement payBillsTab;

	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(css = "li#money_map_tab > a") // My Money Map tab
	})
	public WebElement myMoneyMapTab;

	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(css = "li#online_statements_tab > a") // Online Statements
	})
	public WebElement onlineStatementsTab;

	@FindBys({ @FindBy(css = ".nav.nav-tabs"), // this is the Navbar element
			@FindBy(xpath = "//div[@class='container']//ul[@class='nav nav-tabs']/li") // all tabs
	})
	public List<WebElement> allTabs;

	public void selectTab(String tab) {
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);

		for (WebElement webElement : allTabs) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(tab)) {
				try {
//					wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
					wait.until(ExpectedConditions.elementToBeClickable(webElement));
//					webElement.click();
					js.executeScript("arguments[0].click();", webElement);
				} catch (StaleElementReferenceException e) {
					System.out.println(e.toString());
				}

			}
		}

	}

	public void selectAnLink(String a) {
		js = (JavascriptExecutor) driver;
		actions = new Actions(driver);

		for (WebElement webElement : allLinks) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(a)) {
				try {
//					wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(webElement)));
					wait.until(ExpectedConditions.elementToBeClickable(webElement));
					webElement.click();
//					js.executeScript("arguments[0].click();", webElement);
				} catch (StaleElementReferenceException e) {
					System.out.println(e.toString());
				}

			}
		}
	}

	/** constructor to Initilize elements */
	public AccountSummaryPage() {
		softAssert = new SoftAssert();
		/**
		 * PageFacotry.initElements(driver,this) will initialize the elements on the
		 * page
		 */
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

		/** verify elements exist on the page */
		softAssert.assertEquals(AccountSummaryTab.isDisplayed(), true);
		softAssert.assertEquals(CashAccountsTitle.isDisplayed(), true);
		softAssert.assertEquals(savingsLink.isDisplayed(), true);
		softAssert.assertEquals(savingsLink2.isDisplayed(), true);
		softAssert.assertEquals(accountActivityTab.isDisplayed(), true);
		softAssert.assertEquals(transferFundsTab.isDisplayed(), true);
		softAssert.assertEquals(payBillsTab.isDisplayed(), true);
		softAssert.assertEquals(myMoneyMapTab.isDisplayed(), true);
		softAssert.assertEquals(onlineStatementsTab.isDisplayed(), true);
		softAssert.assertAll();

		/**
		 * create an object of TopNavigationItems inside the Accounts Summary page to
		 * verify that TopNavigationItems are visible from Accounts Summary page
		 */
		topNavigationItems = new TopNavigationItems();
		Reporter.log("All elements on Account Summary Page are displayed");
		System.out.println("All elements on Account Summary Page are displayed");
	}
}
