package pract.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pract.reusable.explicitwait;

public class Checkoutpage extends explicitwait{

	WebDriver driver;
	
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".form-group input")
	WebElement countryInputboxLocator;
	
	By countryInputboxByLocator=By.cssSelector(".form-group input");
	
	@FindBy(css=".ta-results.list-group.ng-star-inserted button")
	List<WebElement> countrydropdownOptions;
	
	By countrydropdownOptionsByLocator=By.cssSelector(".ta-results.list-group.ng-star-inserted button");
	
	//@FindBy(css=".actions a")    //.actions a  //a[text()='Place Order ']
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrderButton;
	
	By placeOrderButtonByLocator=By.cssSelector(".actions a");
	
	public void selectCountry(String countryname)
	{
		waitForElementToVisible(countryInputboxByLocator);
		countryInputboxLocator.sendKeys(countryname);
		waitForElementToVisible(countrydropdownOptionsByLocator);
		WebElement countryToSelect=countrydropdownOptions.stream().filter(country->country.getText().equalsIgnoreCase(countryname)).findFirst().orElse(null);
		countryToSelect.click();
	}
	
	public OrderConfirmationpage placeOrder() throws InterruptedException
	{
		waitForElementToClickable(placeOrderButtonByLocator);
//		Thread.sleep(2000);

		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		placeOrderButton.click();
		OrderConfirmationpage orderConfirm=new OrderConfirmationpage(driver);
		return orderConfirm;
		
	}
	
	
}
