package rough;

import org.testng.annotations.Test;

import base.Base;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
 

public class rough2  extends Base{

	@Test
	public void t1  () {

		super.edriver.get("http://zero.webappsecurity.com/bank/account-summary.html");
//		homePage = new HomePage();
//		homePage.clickOnSignIn();
		
		loginPage = new LoginPage();
		loginPage.doLogin("username", "password");
		
		accountSummary = new AccountSummaryPage();
//		accountSummary.selectTab("Pay Bills");
		accountSummary.payBillsTab.click();
		accountSummary.accountActivityTab.click();
		accountSummary.transferFundsTab.click();
		accountSummary.myMoneyMapTab.click();
		accountSummary.onlineStatementsTab.click();
		
		accountSummary.transferFundsTab1.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
