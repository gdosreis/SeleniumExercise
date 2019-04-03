package pageObjects.gmail.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public class PhoneNumberRegistrationPage extends BasePage
{
	@FindBy(how = How.ID, id = "phoneNumberId")
    private WebElement phoneNumberId;
	
	@FindBy(how = How.ID, id = "gradsIdvPhoneNext")
    private WebElement phoneNextButton;
	
	public PhoneNumberRegistrationPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the indicated phone on the phone field
	 * @param: phone value
	 * @return: -----
	 */
	public void setPhoneNumber(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(phoneNumberId));
		phoneNumberId.clear();
		phoneNumberId.sendKeys(value);
    }
	
	/**  
	 * @description: This method do a click on Next button
	 * @param: ----
	 * @return: TermsAndConditionsPage object
	 */
	public VerificatonNumberPage clickNextButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(phoneNextButton));
		phoneNextButton.click();
		return new VerificatonNumberPage(this.driver);
    }
}
