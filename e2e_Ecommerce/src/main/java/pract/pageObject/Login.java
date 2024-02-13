package pract.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="userEmail")
	WebElement emailFeild;
	
	@FindBy(id="userPassword")
	WebElement passwordFeild;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public Product_catalogue userLogin(String userid,String userpass)
	{
		emailFeild.sendKeys(userid);
		passwordFeild.sendKeys(userpass);
		loginButton.click();
		
		Product_catalogue PC_obj=new Product_catalogue(driver);
		return PC_obj;
		
	}
	

	
	public void gotoApplication()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
