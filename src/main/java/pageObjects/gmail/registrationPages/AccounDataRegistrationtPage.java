package pageObjects.gmail.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

/**
 * This class represent to the register page that ask the account data. In this object we have the basic elements and functionalities for required test cases
 */
public class AccounDataRegistrationtPage extends BasePage
{
	@FindBy(how = How.ID, id = "firstName")
    private WebElement firstName;
	
	@FindBy(how = How.ID, id = "lastName")
    private WebElement lastName;
	
	@FindBy(how = How.ID, id = "username")
    private WebElement username;
	
	@FindBy(how = How.NAME, name = "Passwd")
    private WebElement passwordField;
	
	@FindBy(how = How.NAME, name = "ConfirmPasswd")
    private WebElement confirmPasswordField;
	
	@FindBy(how = How.ID, id = "accountDetailsNext")
    private WebElement accountDetailsNext;

	
	public AccounDataRegistrationtPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the indicated first name on the firstName field
	 * @param: firstName value
	 * @return: -----
	 */
	public void setFirstName(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		firstName.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated last name on the lastName field
	 * @param: lastName value
	 * @return: -----
	 */
	public void setLastName(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.clear();
		lastName.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated user name on the usertName field
	 * @param: usertName value
	 * @return: -----
	 */
	public void setUsername(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.clear();
		username.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated password on the password field
	 * @param: password value
	 * @return: -----
	 */
	public void setPassword(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(passwordField));
		passwordField.clear();
		passwordField.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated confirmation password on the confirmationPassword field
	 * @param: confirmationPassword value
	 * @return: -----
	 */
	public void setConfirmationPassword(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
		confirmPasswordField.clear();
		confirmPasswordField.sendKeys(value);
    }
	
	/**  
	 * @description: This method do a click on Next button
	 * @param: ------
	 * @return: PersonalDataRegistracionPage object
	 */
	public PhoneNumberRegistrationPage clickOnNextButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(accountDetailsNext));
		accountDetailsNext.click();
		return new PhoneNumberRegistrationPage(this.driver);
    }
}
