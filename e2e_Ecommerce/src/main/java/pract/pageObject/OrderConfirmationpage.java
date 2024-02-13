package pract.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pract.reusable.explicitwait;

public class OrderConfirmationpage extends explicitwait{

	WebDriver driver;
	
	public OrderConfirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".hero-primary")
	WebElement orderConfirmMessageLocator;
	
	By orderConfirmMessageByLocator=By.cssSelector(".hero-primary");
	
	
	public void validateOrderConfirmation()
	{
		waitForElementToVisible(orderConfirmMessageByLocator);
		String Message=orderConfirmMessageLocator.getText();
		Assert.assertTrue(Message.equalsIgnoreCase("Thankyou for the order."));
		
	}
	
	
	
	
	
}
