package test;

import utils.CommonFunctions;
import utils.ReadPropertyFile;

import org.testng.annotations.BeforeSuite;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class Baseclass {

	private CommonFunctions BCcommon;
	private ReadPropertyFile BCreadprop;
	private Properties BCprop;
	static WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {

		BCcommon = new CommonFunctions();
		BCreadprop = new ReadPropertyFile();
		BCprop = BCreadprop.readpropFile();
		String browser = BCprop.getProperty("browser");
		String url = BCprop.getProperty("url");
		BCcommon.launch(browser, url);
		driver = CommonFunctions.getDriver();

	}

	@AfterSuite
	public void afterSuite() {
		BCcommon.tearDown();
	}

}
