package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import listeners.WebEventListener;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TopNavigationItems;
import utilities.ExcelReader;

public class Base {
	/** pages */
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountSummaryPage accountSummary;
	public TopNavigationItems topNavigationItems;
	
	
	public static Actions actions;

	//Properties Initialize
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	
	// FileInputStream init
	public static java.io.FileInputStream fis;
	public static java.io.FileInputStream fis2;
	
	public String baseUrl;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public static WebDriverWait wait;
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static ExtentTest test;
	public ExtentReports rep = ExtentManager.getInstance();
	public static String browser;
	public static EventFiringWebDriver edriver;
	/**JS Executor*/
	public static JavascriptExecutor js;
	/**Soft Assertions */
	public SoftAssert softAssert;
	
	
	public static void initConfiguration() {
		
		if (driver == null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			}
			try {
				config.load(fis);

			} catch (IOException e) {
				e.printStackTrace();
				log.debug("Config file loaded");
			}

			try {
				fis2 = new FileInputStream(System.getProperty("user.dir") + "\\properties\\or.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				or.load(fis2);
				log.debug("OR file loaded");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		

		if (Constants.browser.equals("firefox")) {

			driver = new FirefoxDriver();
			log.debug("Launching Firefox");
		}

		else if (Constants.browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver3.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
		}

		else if (Constants.browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver3.exe");

			driver = new InternetExplorerDriver();
			log.debug("Launching IE");
		}

		/*
		 * create an EventFiringWebDriver object that will accepts driver but follows
		 * when are triggered
		 */
		edriver = new EventFiringWebDriver(driver);

		/*
		 * create an object of Listeners class (that has extended
		 * 'WebDriverEventListener' and holds different listener methods)
		 */
		WebEventListener listeners = new WebEventListener();

		/**
		 * Register the listeners
		 */
		edriver.register(listeners);

//		driver.get(Constants.testsiteurl);   // use the URL from COnstant in case we need to always open it
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		wait = new WebDriverWait(edriver, 5);		
		/**initialize JavascriptExecutor */
		js = (JavascriptExecutor) edriver;
	}

	public static void type(WebElement element, String value) {

		element.sendKeys(value);

		log.debug("Typing in an Element : " + element + " entered value as : " + value);

		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	public static void quitBrowser() {
		driver.quit();
	}

	
	
	@BeforeClass
	public void setUpClass() {
		initConfiguration();
	}

	@AfterSuite
	public void tearDownSuite() {
//		rep.flush();
		quitBrowser();
	}

}
