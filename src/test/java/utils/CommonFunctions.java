package utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//CommonFunctions as driverfactory
public class CommonFunctions {
	
public 	WebDriver driver;

public static ThreadLocal<WebDriver> th1= new ThreadLocal<WebDriver>();

	
	
	public void launch(String browser,String url)
	{
		String path =System.getProperty("user.dir");
		System.out.println(path);
		String remaining_path="\\Drivers\\chromedriver.exe";
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",path+remaining_path);
		th1.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Automation\\Selenium\\Drivers\\geckodriver.exe" );
			th1.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("msedge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Automation\\Selenium\\Drivers\\msedgedriver.exe"); 
			th1.set(new EdgeDriver());
		}
		else {
			System.out.println("this is not the correct browser parameter>> give valid input"+browser);
			System.exit(0);
	}
		if(url!="")
			th1.get().get(url);
		else
			th1.get().get("about:blank");
		
		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	public void tearDown()
	{
		th1.get().quit();
	}
	
	public static synchronized WebDriver getDriver(){
		return th1.get();
	}
		
}

