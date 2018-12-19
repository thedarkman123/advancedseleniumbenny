package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.html.HtmlEscapers;
import com.relevantcodes.extentreports.LogStatus;

import utilities.TestUtils;

public class CustomListeners extends TestUtils implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = getReportInstance().startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getName().toString() + " success");
		test.log(LogStatus.PASS, result.getName() + " PASSED");
		
		getReportInstance().endTest(test);
		getReportInstance().flush();
	}

	public void onTestFailure(ITestResult result) {	
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String fileName    = result.getName() + TestUtils.getCurrentTime();
		String browserName = TestUtils.getWrapperInstance().getBrowserName();
		String pathToFile  = TestUtils.captureScreenshot(fileName,browserName);
		String errToPrint  = HtmlEscapers.htmlEscaper().escape(result.getThrowable().getMessage().toString());
		
		Reporter.log(result.getName() + " failed: " + errToPrint);
		Reporter.log("<a target=\"_blank\" href=" + pathToFile + ">Screenshot</a>");
	
		test.log(LogStatus.FAIL, result.getName() + " Failed,exception: " + errToPrint);
		test.log(LogStatus.FAIL,test.addScreenCapture(pathToFile));
		getReportInstance().endTest(test);
		getReportInstance().flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("From listener On finish: Tests done");
	}

}
