package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaSignUpPage;
import utility.Excel;

public class SignUpPageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SignUp() {
		driver = ChromeBrowser.Openbrowser();
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ClickOnSignup();
	}
	@Test
	public void SignUpStart() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaSignUpPage zerodhaSignUpPage = new ZerodhaSignUpPage(driver);
		zerodhaSignUpPage.ClickOnSignUp1(driver);
		String Cell =Excel.getData("EmpDetails", 7, 0);
		zerodhaSignUpPage.EnterMobile(Cell);
		zerodhaSignUpPage.ClickOnContinue();
	
		

	}

}
