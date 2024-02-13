package pract.reusable;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitwait {
	
	WebDriver driver;
	public explicitwait(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void waitForElementToVisible(By waitfor)
	{
		WebDriverWait wait=new WebDriverWait(driver,java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waitfor));
		
	}
	
	public void waitForElementToClickable(By waitfor)
	{
		WebDriverWait wait=new WebDriverWait(driver,java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(waitfor));
		
	}
	
	public void waitForElementToVisible(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,java.time.Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	


}
