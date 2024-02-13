package pract.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import dev.failsafe.internal.util.Assert;
import pract.reusable.explicitwait;
import org.testng.Assert;

public class Cart extends explicitwait {

	WebDriver driver;

	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> productsInCart;

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	By productsInCartByLocator = By.cssSelector(".cartSection h3");

	public void validateProductInCart(String pro_name) throws InterruptedException {

		waitForElementToVisible(productsInCartByLocator);

		Boolean value = productsInCart.stream().anyMatch(product -> product.getText().equalsIgnoreCase(pro_name));
		Assert.assertTrue(value);

	}

	public Checkoutpage checkout() {
		checkoutButton.click();
		
		Checkoutpage checkoutpageobj=new Checkoutpage(driver);
		return checkoutpageobj;
	}

}
