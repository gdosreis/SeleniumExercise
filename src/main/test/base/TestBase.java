package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import readers.ConfigFileReader;

/**
 * This class have the preconditions and postconditions of all test cases..The driver session is created and closed
 */
public class TestBase 
{
	private WebDriver driver;
	protected  ConfigFileReader configReader;
	
	@BeforeMethod
	public void testInicialize() 
	{
		//Create a ConfigFileReader instance.
		configReader = new ConfigFileReader();
		//Create a Chrome driver. All test classes use this.
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void testCleanup() 
	{
		//Close all windows and quite the current driver
		driver.close();
		driver.quit();
	}
	
	protected WebDriver getDriver()
	{   
		//return the driver 
        return this.driver;
	}
}
