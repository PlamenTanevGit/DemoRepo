package rough;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base;

public class rough1 extends Base {

	@Test
	public void t2 () throws InterruptedException{
		String baseUrl ="http://zero.webappsecurity.com/";
//		System.setProperty("webdriver.chrome.driver",
//				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver3.exe");
//		driver = new ChromeDriver();
//		edriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		edriver.manage().window().maximize();
		
		System.out.println(or.getProperty("Name"));
		
		
//		initConfiguration();
//		edriver.get(baseUrl);
//		/*initialize the elements on the SignIn Page*/
//		HomePage p = PageFactory.initElements(driver, HomePage.class);
//		
//		// work with the elemnts
//		p.clickOnSignIn();
//		
//		
//		Thread.sleep(3000);
//		driver.quit();
//		Assert.assertEquals(1,2);

	}
	
	@Test
	public void t3 () throws InterruptedException{
		Assert.assertTrue(true);
		Assert.assertEquals(1,2);

	}

	@Test
	public void t4 () throws InterruptedException{
		Assert.assertEquals(1,2);

	}
	
	@Test
	public void t5 () throws InterruptedException{
		Assert.assertTrue(true);
		Assert.assertEquals(1,2);

	}
	
	@Test
	public void t6 () throws InterruptedException{
		Assert.assertEquals(1,2);

	}
}
