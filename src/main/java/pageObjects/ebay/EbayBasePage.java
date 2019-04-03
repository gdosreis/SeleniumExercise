package pageObjects.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

/**
 * This class have base elements and functionality. This elements and functionalities are available in all pages
 */
public class EbayBasePage extends BasePage
{
	@FindBy(how = How.ID, id = "gh-ac")
    protected WebElement searchField;
	
	@FindBy(how = How.ID, id = "gh-btn")
	protected WebElement searchButton;
	
	
	
	public EbayBasePage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method set the search field
	 * @param:The value that user want search
	 * @return: --
	 */
	public void setSearchField(String value)
	{
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(value);
    }
	
	/**  
	 * @description: This method do a click on serach button
	 * @param:---
	 * @return: ResultPage object, that represent to the search result page 
	 */
	public ResultPage clickSearchButton()
	{
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new ResultPage(this.driver);
    }
	
	
	/**  
	 * @description: This method do a search of an specific item
	 * @param: The value that user want search
	 * @return: ResultPage object, that represent to the search result page 
	 */
	public ResultPage searchAnItem(String value)
	{
		setSearchField(value);
        return clickSearchButton();
    }
}
