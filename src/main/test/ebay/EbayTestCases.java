package ebay;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ebay.EbayPrincipalPage;
import pageObjects.ebay.ItemDetailPage;
import readers.ConfigFileReader;

/**
 * This class have all test cases to verify ebay search flows
 */
public class EbayTestCases extends TestBase
{
	
	@BeforeMethod(description = "Navigate to Ebay page")
	public void testSetup() 
	{
		getDriver().get(configReader.getEbayBaseURL());
	}
	
	/**  
	 * @Id: TC-06
	 */
	@Test(description = "This test case verify if the price for the first seleted item is displayed on the detail page")
	public void searchTestCase()
	{
		EbayPrincipalPage principalPage = new EbayPrincipalPage(getDriver());
		//Complete search field with the corresponding value
		principalPage.setSearchField(configReader.getSearchValue());
		//Click on Search button and then select the first item
		ItemDetailPage detailPage = principalPage.clickSearchButton().clickOnFirstResultItem();
		//Verify if price element is present
		Assert.assertTrue(detailPage.isPricePresent());
		//Print price value 
		System.out.println("The price is: "+detailPage.getPrice());
	}
}
