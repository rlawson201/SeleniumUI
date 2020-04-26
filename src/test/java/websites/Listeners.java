package websites;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import factories.WebDriverFactory;

public class Listeners implements ITestListener {
	
	WebDriverFactory wdf = new WebDriverFactory();

	@Override
	public void onFinish(ITestContext arg0) {
		
		System.out.println("Test Suite has completed");

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("Test started");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult results) {
		
		//System.out.println("Test case(s) have failed, please debug " + results.getName());
		try {
			wdf.getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		System.out.println("Test case(s) have been skipped, please debug");

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
