package pract.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pract.reusable.explicitwait;

public class Headerpage extends explicitwait{

	WebDriver driver;
	public Headerpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[routerlink='/dashboard/myorders']")             //[routerlink=\"/dashboard/myorders\"]
	WebElement ordersButton;      
	
	
	@FindBy(css="i[class='fa fa-sign-out']")
	WebElement Signout_btn;
	
	
	
	By ordersButtonByLocator=By.cssSelector("[routerlink='/dashboard/myorders']");
	
	public Orderspage gotoOrders()
	{
		waitForElementToVisible(ordersButtonByLocator);
		ordersButton.click();
		Orderspage orderpage_obj=new Orderspage(driver);
		return orderpage_obj;
		
	}
	
	public WebElement checkVisibilityOfSignoutBtn()
	{
		waitForElementToVisible(Signout_btn);
		return Signout_btn;
	}
	
	

}


