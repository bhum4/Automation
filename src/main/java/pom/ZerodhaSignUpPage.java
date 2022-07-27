package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaSignUpPage {
	
	@FindBy (xpath = "(//a[text()='Signup'])[1]") private WebElement signUp;
	@FindBy (xpath = "(//a[text()='About'])[1]") private WebElement about;
	@FindBy (xpath = "(//a[text()='Products'])[1]") private WebElement products;
	@FindBy (xpath = "(//a[text()='Pricing'])[1]") private WebElement pricing;
	@FindBy (xpath = "(//a[text()='Support'])[1]") private WebElement support;
	@FindBy (xpath = "//div[@title='Menu']") private WebElement menu;
	@FindBy (xpath = "//input[@name='mobile']") private WebElement mobile;
	@FindBy (xpath = "//button[@type='submit']") private WebElement start;
	
	public ZerodhaSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ClickOnSignUp() {
		signUp.click();
	}
	public void ClickOnSignUp1(WebDriver driver) {
		Set<String> Handles = driver.getWindowHandles();
		Iterator<String> i = Handles.iterator();
		
		String ParentPage = i.next();
		String ChildPage = i.next();
		driver.switchTo().window(ChildPage);
		
	}
	public void EnterMobile(String B) {
		mobile.sendKeys(B);
	}
	public void ClickOnContinue () {
		start.click();
	}

	

}
