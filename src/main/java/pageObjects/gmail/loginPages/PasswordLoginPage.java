package pageObjects.gmail.loginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.gmail.gmailBox.GmailInboxPage;

/**
 * This class represent to the page that ask enter the password. In this object we have the basic elements and functionalities for required test cases
 */
public class PasswordLoginPage extends BasePage 
{

	@FindBy(how = How.NAME, name = "password")
    private WebElement password;
	
	@FindBy(how = How.ID, id = "passwordNext")
    private WebElement passwordNext;
    
    @FindBy(how = How.CSS, css = "[jsname='h9d3hd']")
    private WebElement errorElement;
	
	public PasswordLoginPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the indicated password on the password field
	 * @param: password value
	 * @return: -----
	 */
	public void setPassword(String userValue)
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(userValue);
    }
	
	/**  
	 * @description: This method do a click on Next button
	 * @param: -----
	 * @return: GmailInboxPage object
	 */
	public GmailInboxPage clickNextPasswordButton()
	{
		wait.until((ExpectedConditions.elementToBeClickable(password)));
        passwordNext.click();
        return new GmailInboxPage(this.driver);
    }
	
	/**  
	 * @description: This method verify if error element is present
	 * @param: -----
	 * @return: True is element is present and false if it is not present
	 */
	public boolean isErrorPresent()
	{
        try 
        	{
        		wait.until(ExpectedConditions.elementToBeClickable(errorElement));
        		return true;
        	}
        catch(Exception e)
        	{
        		return false;
        	}
    }
}
