package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pages.HomePage;
import utilities.ErrorCollector;

public class HomePageTests extends Base {

	@BeforeClass
	public void testSetUp() {
		baseUrl = "http://zero.webappsecurity.com/index.html";
		edriver.get(baseUrl);
		homePage = new HomePage();
		actions = new Actions(driver);
		softAssert = new SoftAssert();
	}

	@Test
	public void globalSearch() {
		homePage.searchField.sendKeys("withdraw" + Keys.ENTER);
		WebElement resultsPage = edriver.findElement(By.xpath("//h2[contains(text(),'Search Results:')]"));
	
		/**Using a method from ErrorCollector class that is making assert with a try catch 
		 * and will not break the test in case of fail (like soft Assertion)*/
		ErrorCollector.verifyEquals(resultsPage.getText(), "Search Results:");
		
		edriver.navigate().back();
		softAssert.assertTrue(homePage.SignInBtn.isDisplayed());
		softAssert.assertAll();
	}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
