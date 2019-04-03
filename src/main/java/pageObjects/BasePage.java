package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class have the basic logic to manage the session
 */
public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) 
	{           
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(this.driver, this);
	}
	
	/**  
	 * @description: This method maximize the browser
	 * @param:----
	 * @return: -----
	 */
	public void maxiizeBrowser()
	{           
        this.driver.manage().window().fullscreen();
	}
	
	/**  
	 * @description: This method navigate to indicated url
	 * @param: url value
	 * @return: ----
	 */
	public void navigateTo(String url)
	{           
		driver.get(url);
	}
	
	/**  
	 * @description: This method return a WebDriver element 
	 * @param:----
	 * @return: WebDriver element
	 */
	public WebDriver getDriver()
	{           
        return this.driver;
	}
}
