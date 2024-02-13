package pract.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pract.reusable.explicitwait;

public class Orderspage extends explicitwait  {
	
	public WebDriver driver;
	
	public Orderspage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(css=".ng-star-inserted td:nth-child(3)")
	List<WebElement> productsOnOrderpage;
	
	By productsOnOrderpageByLoactor=By.cssSelector(".ng-star-inserted td:nth-child(3)");
	
	
	public Boolean verifyProduct(String pro_name)
	{
		waitForElementToVisible(productsOnOrderpageByLoactor);
		
		Boolean val=productsOnOrderpage.stream().anyMatch(product->product.getText().equalsIgnoreCase(pro_name));
		return val;
		
	}

//
//	public Boolean verifyProduct(String product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
	
	

}
