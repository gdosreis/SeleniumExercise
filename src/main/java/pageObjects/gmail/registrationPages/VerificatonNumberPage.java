package pageObjects.gmail.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

public class VerificatonNumberPage extends BasePage
{
	@FindBy(how = How.ID, id = "code")
    private WebElement codeField;
	
	@FindBy(how = How.ID, id = "gradsIdvPhoneNext")
    private WebElement verificationNextButton;
	
	public VerificatonNumberPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the code value on the verification field
	 * @param: phone value
	 * @return: -----
	 */
	public void setCodeNumber(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(codeField));
		codeField.clear();
		codeField.sendKeys(value);
    }
	
	/**  
	 * @description: This method do a click on Verify button
	 * @param: ----
	 * @return: TermsAndConditionsPage object
	 */
	public PersonalDataRegistracionPage clickVerifyButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(verificationNextButton));
		verificationNextButton.click();
		return new PersonalDataRegistracionPage(this.driver);
    }
}
