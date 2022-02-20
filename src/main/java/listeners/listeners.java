package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class listeners extends AbstractWebDriverEventListener {

	/*
	 * https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/
	 * events/WebDriverEventListener.html
	 * 
	 * What are listeners ?
	 * 
	 * 
	 * On any particular event some of my code should get executed ex: if i click on
	 * some or do something some of my code should be executed
	 * 
	 * https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/
	 * events/WebDriverEventListener.html
	 * 
	 * WebDriverEventListener provides methods that are triggering after some
	 * actions are done : for ex: afterNavigateBack​(WebDriver driver)
	 * afterNavigateForward​(WebDriver driver) afterClickOn​(WebElement element,
	 * WebDriver driver)
	 *
	 **/
	
	/** 
	 * this is a User listener used a lot for validations before/after firing event
	 * here we can add our code logic before/after event is fired.
	 * asked in interviews a lot
	 * */

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("clicked on WebElement");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("about to click on WebElement");
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated Back");
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated Forward");
	}
}
