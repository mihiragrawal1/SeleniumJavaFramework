package pract.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponent.BaseTest;
import pract.pageObject.Headerpage;

public class loginTest extends BaseTest {

	@Test(dataProvider = "getValidData",groups="login",description="Validate user login with valid crdentials")
	public void valid_login(HashMap<String, String> input) throws InterruptedException {
		loginobj.userLogin(input.get("email"), input.get("pass"));
		Headerpage headerObj = new Headerpage(driver);
		WebElement signout_btn = headerObj.checkVisibilityOfSignoutBtn();
		AssertJUnit.assertTrue(signout_btn.isDisplayed());
		String currenturl = driver.getCurrentUrl();
		AssertJUnit.assertTrue(currenturl.equalsIgnoreCase("https://rahulshettyacademy.com/client/dashboard/dash"));

	}

	
	@Test(dataProvider = "getInvalidData",groups="login",description="Validate user login with invalid crdentials")
	public void validate_InvalidLogin(HashMap<String, String> input) {
		loginobj.userLogin(input.get("email"), input.get("pass"));

		String currenturl = driver.getCurrentUrl();
		AssertJUnit.assertTrue(currenturl.contains("/auth/login"));
//		Assert.assertTrue(false);

	}

	@DataProvider
	public Object[][] getValidData() throws IOException {

		List<HashMap<String, String>> data = readFromJson(
				System.getProperty("user.dir") + "//src//test//java//Data//LoginData.json");
		return new Object[][] { { data.get(0) } }; // curly braces represent number of object(datasets)

	}

	@DataProvider
	public Object[][] getInvalidData() throws IOException {
		List<HashMap<String, String>> data = readFromJson(
				System.getProperty("user.dir") + "//src//test//java//Data//inValidData.json");
		return new Object[][] { { data.get(0) } };

	}

}
