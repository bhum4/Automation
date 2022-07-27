package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZerodhaForgotPage {
	
	@FindBy (xpath = "(//label[@class='su-radio-label'])[1]") private WebElement remenberUser;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[2]") private WebElement forgotUser;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[3]") private WebElement receiveOnEmail;
	@FindBy (xpath = "(//label[@class='su-radio-label'])[4]") private WebElement receiveOnSMS;
	
	@FindBy (xpath = "//input[@placeholder='User ID']") private WebElement userId;
	@FindBy (xpath = "//input[@placeholder='PAN']") private WebElement pan;
	@FindBy (xpath = "//input[@placeholder='E-mail (as on account)']") private WebElement email;
	@FindBy (xpath = "//button[@type='submit']") private WebElement reset;

	public ZerodhaForgotPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void ClickOnforgot() {
		forgotUser.click();
	}
	public void EnterPan(String panId) {
		pan.sendKeys(panId);
	}
	public void EnterEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void ClickOnReset () {
		reset.click();
	}

}
