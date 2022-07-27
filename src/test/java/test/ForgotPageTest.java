package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ZerodhaForgotPage;
import pom.ZerodhaLoginPage;

public class ForgotPageTest {
	
	WebDriver driver ;
	
	@BeforeMethod
	public void Zerodha() {
		driver = ChromeBrowser.Openbrowser();	
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		zerodhaLoginPage.ClickOnforgot(driver);
	}
	
	@Test
	public void ClickOnForgot () throws InterruptedException {
		ZerodhaForgotPage zerodhaForgotPage = new ZerodhaForgotPage(driver);
		zerodhaForgotPage.ClickOnforgot();
		Thread.sleep(1000);
		zerodhaForgotPage.EnterPan("QWERTY");
		zerodhaForgotPage.EnterEmail("Bhumesh");	
		zerodhaForgotPage.ClickOnReset();
		
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
