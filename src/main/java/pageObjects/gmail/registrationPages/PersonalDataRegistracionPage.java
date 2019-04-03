package pageObjects.gmail.registrationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

/**
 * This class represent to the register page that ask the personal data. In this object we have the basic elements and functionalities for required test cases
 */
public class PersonalDataRegistracionPage extends BasePage
{
	@FindBy(how = How.ID, id = "phoneNumberId")
    private WebElement phoneNumberId;
	
	@FindBy(how = How.ID, id = "day")
    private WebElement day;
	
	@FindBy(how = How.ID, id = "month")
    private WebElement month;
	
	@FindBy(how = How.ID, id = "year")
    private WebElement year;
	
	@FindBy(how = How.ID, id = "gender")
    private WebElement gender;
	
	@FindBy(how = How.ID, id = "personalDetailsNext")
    private WebElement personalDetailsNext;
	
	public PersonalDataRegistracionPage(WebDriver driver) 
	{
        super(driver);
    }
	
	
	/**  
	 * @description: This method set the indicated birth day on the day field
	 * @param: day value
	 * @return: -----
	 */
	public void setDay(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(day));
		day.clear();
		day.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated birth month on the month field
	 * @param: month value
	 * @return: -----
	 */
	public void setMonth(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(month));
		month.clear();
		month.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated birth year on the year field
	 * @param: year value
	 * @return: -----
	 */
	public void setYear(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(year));
		year.clear();
		year.sendKeys(value);
    }
	
	/**  
	 * @description: This method set the indicated gender on the gender field
	 * @param: gender value
	 * @return: -----
	 */
	public void setGender(String value)
	{
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.clear();
		gender.sendKeys(value);
    }
	
	/**  
	 * @description: This method do a click on Next button
	 * @param: ----
	 * @return: TermsAndConditionsPage object
	 */
	public TermsAndConditionsPage clickNextButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(personalDetailsNext));
		personalDetailsNext.click();
		return new TermsAndConditionsPage(this.driver);
    }
}
