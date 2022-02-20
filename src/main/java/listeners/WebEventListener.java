package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import base.Base;
/**extending Base class to use the Extenet Test object. */

public class WebEventListener extends Base  implements WebDriverEventListener{
	
	public void beforeAlertAccept(WebDriver driver) {
		
	 
		System.out.println("Before accept alert");
		
	}

	public void afterAlertAccept(WebDriver driver) {	
	 
		System.out.println("After accept alert");
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
//		test.log(LogStatus.INFO, "Before Navigated to : " + super.baseUrl);
//		System.out.println("Before Navigated to : " + super.baseUrl);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
 
		System.out.println("Navigated to : " + url );
		
	}

	public void beforeNavigateBack(WebDriver driver) {
//		System.out.println("Before Navigated back ");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		 
		System.out.println("Navigated back ");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
	 
		System.out.println("Navigated Forward ");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
 
		System.out.println("Refresh ");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		 
		System.out.println("Found Element " + element.getText());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Clicked on Element "+ element.getText());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
	 
		System.out.println("Switching to Window " + windowName );
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
	 
		System.out.println("Got the text from element:  " + element.getText());
		
	}
	


}
