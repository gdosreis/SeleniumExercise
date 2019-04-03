package pageObjects.gmail.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.gmail.gmailBox.GmailInboxPage;

/**
 * This class represent the page that ask accept the term and condition. In this object we have the basic elements and functionalities for required test cases
 */
public class TermsAndConditionsPage extends BasePage
{
	@FindBy(how = How.ID, id = "termsofserviceNext")
    private WebElement termsofserviceNext;
	
	@FindBy(how = How.CSS,  css= "[jsname='eSCclc']")
    private WebElement scrollDownButton;
	
	public TermsAndConditionsPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method do a click on Accept button
	 * @param: ----
	 * @return: TermsAndConditionsPage object
	 */
	public GmailInboxPage clickAcceptButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(termsofserviceNext));
		termsofserviceNext.click();
		return new GmailInboxPage(this.driver);
    }
	
	/**  
	 * @description: This method do a click on scroll down button in order to read all terms and condition
	 * @param: ----
	 * @return: TermsAndConditionsPage object
	 */
	public void clickScrollDownButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(scrollDownButton));
		scrollDownButton.click();
    }
}
