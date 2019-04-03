package pageObjects.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represent to the search result page. In this page we can see all the items that are matching with the entered search parameters.
 * Only was added the logic for required test case, but also we can do searches by price, country, check items by any criteria, etc
 */
public class ResultPage extends EbayBasePage
{
	@FindBy(how = How.ID, id = "srp-river-results")
	private WebElement resultGrid;
		
	@FindBy(how = How.CSS, css = "#srp-river-results-listing1 .s-item__link")
	private WebElement firstItemLink;
	
	
	public ResultPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method do a click on the first item
	 * @param:----
	 * @return: ItemDetailPage object
	 */
	public ItemDetailPage clickOnFirstResultItem()
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstItemLink));
		firstItemLink.click();
		return new ItemDetailPage(this.driver);
    }
	
}
