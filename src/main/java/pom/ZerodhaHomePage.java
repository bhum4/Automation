package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {
	
	@FindBy (xpath = "//input[@icon='search']") private WebElement search;
	@FindBy (xpath = "//span[@class='tradingsymbol']") private List<WebElement> stock;
	@FindBy (xpath = "//button[@data-balloon='Buy']") private WebElement buy;
	@FindBy (xpath = "//button[@data-balloon='Sell']") private WebElement sell;
	@FindBy (xpath = "//button[@data-balloon='Chart']") private WebElement chart;
	@FindBy (xpath = "//button[@data-balloon='Market depth widget']") private WebElement market;
	@FindBy (xpath = "//button[@data-balloon='Added']") private WebElement added;

	public ZerodhaHomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void SearchStock (String StockName) {
		search.sendKeys(StockName);
	}
	public void findstock (WebDriver driver, String nameOfStock) {
	for (int i=0; i<stock.size();i++ ) {
		WebElement currentStock = stock.get(i);
		String name = currentStock.getText();
		if (name.equals(nameOfStock))
		{	
		Actions actions = new Actions(driver);
		actions.moveToElement(currentStock);
		actions.perform();
	       }	
    	}
	}
	public void ClickOnBuy () {
		buy.click();
	}
	public void ClickOnSell () {
		sell.click();
	}
	public void ClickOnChart (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(chart));
		chart.click();
	}
	public void ClickOnmarket () {
		market.click();
	}
	public void ClickOnAdded () {
		added.click();
	}
}

