package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;

public class CustomListeners extends Base implements ITestListener, ISuiteListener {

	public String messageBody;

	public void onFinish(ITestContext arg0) {
		/* end the Test */
		rep.endTest(test);

	}

	public void onStart(ITestContext arg0) {

		test = rep.startTest(arg0.getName(), arg0.getName());
		test.log(LogStatus.INFO, arg0.getName() + " Starts");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {

//		System.setProperty("org.uncommons.reportng.escape-output","false");
//		try {
//			Utilities.captureScreenshot();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
//		test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));
//		
//		
//		
//		Reporter.log("Click to see Screenshot");
//		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");

		/** flushing the Report in matter to include the Faield cases in the Report */
		rep.endTest(test);
		rep.flush();

	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run mode is NO");

		/** flushing the Report in matter to include the Skipped cases in the Report */
		rep.endTest(test);
		rep.flush();

	}

	public void onTestStart(ITestResult arg0) {

		test = rep.startTest(arg0.getName().toUpperCase());

	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");

		/** flushing the Report in matter to include the Passed cases in the Report */
		rep.endTest(test);
		rep.flush();

	}

	/* Sute Methods */
	public void onFinish(ISuite arg0) {

//		MonitoringMail mail = new MonitoringMail();
//		 
//		try {
//			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
//					+ ":8080/job/LiveProject-PageObjectWithFactories/Extent_Report/";
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

}
