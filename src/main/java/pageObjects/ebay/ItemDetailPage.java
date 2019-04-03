package pageObjects.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This class represent to the detail page. In this page we can see the price, title, description and also do an offer.
 */
public class ItemDetailPage extends EbayBasePage
{
	@FindBy(how = How.ID, id = "prcIsum_bidPrice")
	private WebElement price;
	
	@FindBy(how = How.ID, id = "MaxBidId")
	private WebElement offertField;
	
	@FindBy(how = How.ID, id = "itemTitle")
	private WebElement itemTitle;
	
	@FindBy(how = How.ID, id = "vi-itm-cond")
	private WebElement status;
	
	public ItemDetailPage(WebDriver driver) 
	{
        super(driver);
    }
	
	/**  
	 * @description: This method return the item price
	 * @param:----
	 * @return: Price as String
	 */
	public String getPrice()
	{
		wait.until(ExpectedConditions.elementToBeClickable(price));
        return price.getText();
    }
	
	/**  
	 * @description: This method return the item title
	 * @param:----
	 * @return: Title as String
	 */
	public String getTitle()
	{
		wait.until(ExpectedConditions.elementToBeClickable(itemTitle));
        return itemTitle.getText();
    }
	
	/**  
	 * @description: This method return the item status
	 * @param:----
	 * @return: Status as String
	 */
	public String getStatus()
	{
		wait.until(ExpectedConditions.elementToBeClickable(status));
        return status.getText();
    }
	

	/**  
	 * @description: This method check if price element is present 
	 * @param:----
	 * @return: Boolean value. True is price is present and false if it is not present
	 */
	public boolean isPricePresent()
	{
		try 
		{
			wait.until(ExpectedConditions.elementToBeClickable(price));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
    }
}
