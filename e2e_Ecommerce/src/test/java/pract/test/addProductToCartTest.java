package pract.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponent.BaseTest;
import pract.pageObject.Cart;
import pract.pageObject.Checkoutpage;
import pract.pageObject.Headerpage;
import pract.pageObject.OrderConfirmationpage;
import pract.pageObject.Orderspage;
import pract.pageObject.Product_catalogue;

public class addProductToCartTest extends BaseTest  {

	
	String Product = "ZARA COAT 3"; // IPHONE 13 PRO   ADIDAS ORIGINAL
	String Country = "India";
	
	
	@Test(dataProvider="getData")
	public void addToCartTest(HashMap<String,String> input) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().deleteAllCookies();
		Product_catalogue PC_obj = loginobj.userLogin(input.get("email"),input.get("pass"));        //"mihir@gmail.com", "Mihir@123"

		List<WebElement> products = PC_obj.getProductList();

		PC_obj.addProductToCart(products, Product);
		Cart cartobj = PC_obj.goToCart();

		cartobj.validateProductInCart(Product);
		Checkoutpage checkoutpageobj = cartobj.checkout();

		checkoutpageobj.selectCountry(Country);
		OrderConfirmationpage orderConfirm = checkoutpageobj.placeOrder();

		orderConfirm.validateOrderConfirmation();

	}
//	
	
	@Test                                   //(dependsOnMethods={"addToCartTest"})
	public void validateproductinorders()
	{
		loginobj.userLogin("mihir@gmail.com", "Mihir@123");
		
		Headerpage headerobj=new Headerpage(driver);
		Orderspage orderpage_obj=headerobj.gotoOrders();
		Boolean value=orderpage_obj.verifyProduct(Product);
		Assert.assertTrue(value);
		
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data=readFromJson(System.getProperty("user.dir")+"//src//test//java//Data//LoginData.json");
		return new Object[][] {{data.get(0)}};   //curly braces represent number of object(datasets)
		
	}
	
	
	
	
	
	
}
