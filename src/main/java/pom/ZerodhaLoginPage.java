package pom;

import java.time.Duration;

import javax.swing.text.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {
	
	@FindBy (xpath = "//input[@id='userid']") private WebElement userId;
	@FindBy (xpath = "//input[@id='password']") private WebElement pass;
	@FindBy (xpath = "//button[@type='submit']") private WebElement login;
	@FindBy (xpath = "//a[text()='Forgot user ID or password?']") private WebElement forgot;
	@FindBy (xpath = "//a[@class='text-light']") private WebElement signup;
	
	@FindBy (xpath = "//input[@id='pin']") private WebElement pin;
	@FindBy (xpath = "//button[@type='submit']") private WebElement start;
	
	public ZerodhaLoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enteruserid(String user) {
		userId.sendKeys(user);
	}
	public void enterpass(String password) {
		pass.sendKeys(password);
	}
	public void clickOnLogin() {
		login.click();
	}
	public void ClickOnforgot(WebDriver driver) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofMillis(3000));
		wait.pollingEvery(Duration.ofMillis(100));
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOf(forgot));
		forgot.click();
	}
	public void ClickOnSignup() {
		signup.click();
	}
	public void enterpin(WebDriver driver ,String enterpin ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(enterpin);	
	}
	public void ClickOnStart () {
		start.click();
	}

	

}

