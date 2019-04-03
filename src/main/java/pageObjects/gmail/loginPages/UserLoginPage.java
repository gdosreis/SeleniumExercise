package pageObjects.gmail.loginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;
import pageObjects.gmail.registrationPages.AccounDataRegistrationtPage;

/**
 * This class represent to the page that ask enter the user and also it's possible go to create account page. In this object we have the basic elements and functionalities for required test cases
 */
public class UserLoginPage extends BasePage {

	@FindBy(how = How.ID, id = "identifierNext")
    private WebElement identifierNext;
	
	@FindBy(how = How.ID, id = "identifierId")
    private WebElement identifierId;
	
	@FindBy(how = How.CSS, css = "[jsname='lqvTlf']")
    private WebElement createAccount;
	
	@FindBy(how = How.CSS, css = "[jsname='j7LFlb']")
    private WebElement forMe;
	
	@FindBy(how = How.CSS, css = "[jsname='Cuz2Ue']")
    private WebElement forgotEmailAddress;
	
	@FindBy(how = How.CSS, css = "[jsname='B34EJ']")
    private WebElement errorElement;
	
	public UserLoginPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the indicated user on the userName field
	 * @param: user value
	 * @return: -----
	 */
	public void setUser(String userValue)
	{
        wait.until(ExpectedConditions.elementToBeClickable(identifierId));
        identifierId.clear();
        identifierId.sendKeys(userValue);
    }
	
	/**  
	 * @description: This method do a click on Next button
	 * @param: -----
	 * @return: PasswordLoginPage object
	 */
	public PasswordLoginPage clickNextUserButton()
	{
        wait.until(ExpectedConditions.elementToBeClickable(identifierNext));
        identifierNext.click();
        return new PasswordLoginPage(this.driver);
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
	
	/**  
	 * @description: This method do a click on Create account option
	 * @param: -----
	 * @return: ----
	 */
	public void clickCreateAccountOption()
	{
        wait.until(ExpectedConditions.elementToBeClickable(createAccount));
        createAccount.click();
    }
	
	/**  
	 * @description: This method do a click on For Me option
	 * @param: -----
	 * @return: AccounDataRegistrationtPage object
	 */
	public AccounDataRegistrationtPage clickForMeOption()
	{
        wait.until(ExpectedConditions.elementToBeClickable(forMe));
        forMe.click();
        return new AccounDataRegistrationtPage(this.driver);
    }
}
