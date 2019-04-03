package pageObjects.gmail.gmailBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;
import pageObjects.gmail.loginPages.UserLoginPage;

/**
 * This class represent to inbox gmail page.Only required elements and functionality were defined.
 * This class could be a superclass and have others for Inbox, Calendar, etc. Only was created for required test case.
 */
public class GmailInboxPage extends BasePage
{
	@FindBy(how = How.CSS, css = ".gb_x.gb_Da.gb_f" )
    private WebElement profileButton;
	
	@FindBy(how = How.ID, id ="gb_71" )
    private WebElement logout;
	
	public GmailInboxPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method verify if user is logged, checking the profile button
	 * @param: -----
	 * @return: true if profile element is present and false if it is not present
	 */
	public boolean isUserLogged()
	{
        try 
        	{
        		wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        		return true;
        	}
        catch(Exception e)
        	{
        		return false;
        	}
    }
	
	/**  
	 * @description: This method do a click on the profile image
	 * @param: -----
	 * @return: -------
	 */
	public void clickProfileImage()
	{
		wait.until((ExpectedConditions.elementToBeClickable(profileButton)));
		profileButton.click();
    }
	
	/**  
	 * @description: This method do a click on the logout button
	 * @param: -----
	 * @return: UserLoginPage
	 */
	public UserLoginPage clickLogoutButton()
	{
		wait.until((ExpectedConditions.elementToBeClickable(logout)));
		logout.click();
		return new UserLoginPage(this.driver);
    }
	
	/**  
	 * @description: This method verify if email is present on profile
	 * @param: -----
	 * @return: true if email is present and false if it is not present
	 */
	public boolean isEmailPresent(String email)
	{
		try 
    	{
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='"+email+"']")));
    		return true;
    	}
		catch(Exception e)
    	{
    		return false;
    	} 
    }
}
