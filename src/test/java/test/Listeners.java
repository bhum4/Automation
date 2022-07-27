package test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import pojo.BaseTest;
import utility.Screenshot;

public class Listeners extends BaseTest implements ITestListener {

	public void onTestStart (ITestResult result) {
		System.out.println("Test has started "+ result.getName());
	}
	
	public void onTestSuccess (ITestResult result) {
		System.out.println("Testpassed "+ result.getName());
	}
	public void onTestFailure (ITestResult result) {
		try {
			Screenshot.TakeScreenshot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onTestSkipped (ITestResult result) {
		System.out.println("Test Skipped "+ result.getName());
	}
	
}
