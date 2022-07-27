package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.ChromeBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class HomePageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void LoginWithCredentials () throws EncryptedDocumentException, IOException, InterruptedException {
		driver = ChromeBrowser.Openbrowser();
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
		String User = Excel.getData("EmpDetails", 1, 0);
		String Pass = Excel.getData("EmpDetails", 1, 1);
		zerodhaLoginPage.enteruserid(User);
		zerodhaLoginPage.enterpass(Pass);
		zerodhaLoginPage.clickOnLogin();
		Thread.sleep(2000);
		String Pin =Excel.getData("EmpDetails", 1, 2);
		zerodhaLoginPage.enterpin(driver,Pin);
		zerodhaLoginPage.ClickOnStart();
	}
	@Test
	public void SearchStockAndBuy () throws InterruptedException {
		ZerodhaHomePage zerodhaHomePage = new ZerodhaHomePage(driver);
		Thread.sleep(2000);
		zerodhaHomePage.SearchStock("Tata");
		zerodhaHomePage.findstock(driver,"TATAMOTORS");
		zerodhaHomePage.ClickOnChart(driver);
		
	}
	

}
