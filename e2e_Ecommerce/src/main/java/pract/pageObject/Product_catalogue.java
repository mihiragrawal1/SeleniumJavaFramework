package pract.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pract.reusable.explicitwait;

public class Product_catalogue extends explicitwait{
	
	WebDriver driver;
	public Product_catalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	    
	By productNameLocator=By.cssSelector("b");
	
	By addCartButtonLocator=By.cssSelector(".card-body button:last-of-type");
	
	By productAddedToaster=By.cssSelector("#toast-container");
	
	@FindBy(css="button[routerlink='/dashboard/cart']")             //[routerlink=\"/dashboard/cart\"]
	WebElement cartButton;
	
	
	By cartButtonByLoactor=By.cssSelector("button[routerlink='/dashboard/cart']");
	
	By waitforproducts=By.cssSelector(".card-body");

	public List<WebElement> getProductList()
	{
		waitForElementToVisible(waitforproducts);
		return  products;
	}
	
	public void addProductToCart(List<WebElement> products,String pro_name) throws InterruptedException
	{
		
		WebElement requiredProduct=products.stream().filter(product->product.findElement(productNameLocator).getText().equals(pro_name)).findFirst().orElse(null);
		
		requiredProduct.findElement(addCartButtonLocator).click();
		Thread.sleep(2000);
		waitForElementToVisible(productAddedToaster);
//		Thread.sleep(2000);
		
	}
	
	public Cart goToCart()
	{
//		
		cartButton.click();
		Cart cartobj=new Cart(driver);
		return cartobj;
		
	}
	
}
