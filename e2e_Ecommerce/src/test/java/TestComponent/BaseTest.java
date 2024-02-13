package TestComponent;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pract.pageObject.Login;

public class BaseTest {

	public WebDriver driver;
	public Login loginobj;

	@Test
	public WebDriver invokeBrowser() throws IOException {

		ChromeOptions options = new ChromeOptions();
		FirefoxOptions fOptions = new FirefoxOptions();
		EdgeOptions Eoptions=new EdgeOptions();

		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//pract//reusable//Browser.properties");

		props.load(fis);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: props.getProperty("browser");

		if (browsername.contains("chrome")) {

			if (browsername.contains("headless")) {
				options.addArguments("headless");

			}

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}

		else if (browsername.contains("firefox")) {
			if (browsername.contains("headless")) {
				fOptions.addArguments("--headless");

			}
//			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fOptions);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
														
		else if (browsername.contains("edge")) {
			if(browsername.contains("--headless"))
			driver = new EdgeDriver();
		}

//	WebDriverManager.chromedriver().setup();

//	WebDriver driver = new FirefoxDriver();
//	WebDriver driver = new ChromeDriver();

//	driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod(alwaysRun=true)
	public Login launchApplication() throws IOException {

		try {
			driver = invokeBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver=invokeBrowser();
//		driver.get(url);
		loginobj = new Login(driver);
		loginobj.gotoApplication();

		return loginobj;

	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}

	public List<HashMap<String, String>> readFromJson(String filepath) throws IOException {

//		json to string step 1
		String data = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);

//		now create objectmapper obj
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> dataa = mapper.readValue(data,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return dataa;

	}

}
