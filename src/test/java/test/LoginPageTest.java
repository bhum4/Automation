package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.BaseTest;
import pojo.ChromeBrowser;
import pom.ZerodhaLoginPage;
import utility.Excel;
import utility.Reports;

public class LoginPageTest extends BaseTest {
	
	ExtentReports extent ;
	ExtentTest test ;
	@BeforeTest
	public void configurationReport () {
		extent = Reports.GenerateReports();
	}	
	@BeforeTest
	public void launchBrowser () {
		driver = ChromeBrowser.Openbrowser();
	}	
	@Test
	public void LoginWithCredentials () throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		
		String title = driver.getTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
		
		String User = Excel.getData("EmpDetails", 1, 0);
		String Pass = Excel.getData("EmpDetails", 1, 1);
		zerodhaLoginPage.enteruserid(User);
		zerodhaLoginPage.enterpass(Pass);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		String Pin =Excel.getData("EmpDetails", 1, 2);
		zerodhaLoginPage.enterpin(driver,Pin);
		zerodhaLoginPage.ClickOnStart();
		soft.assertAll();		
	}
	@Test
	public void verifySignUpFeatures() {
		test = extent.createTest("verifySignUpFeatures");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ClickOnSignup();
	}
	@Test
	public void zerodhaForgotPasswordFeatureTest () {
		test = extent.createTest("zerodhaForgotPasswordFeatureTest");
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ClickOnforgot(driver);
	}
	
	public void postExecution (ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else 
		{
		test.log(Status.SKIP, result.getName());
		}
	}
	@AfterTest
	public void publishreport () {
		extent.flush();
	}
}
