package pageObjects.ebay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class represent to principal ebay page.Have defined some elemnts as example
 */
public class EbayPrincipalPage extends EbayBasePage
{
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1381.l6435']")
	private WebElement healthAndBeautyOption;
	
	@FindBy(how = How.CSS, css = ".saved")
	private WebElement savedOption;
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1379.l6435']")
	private WebElement technologyOption;
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1381.l6435']")
	private WebElement fashionOption;
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1382.l6435']")
	private WebElement vehiclesOption;
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1385.l6435']")
	private WebElement sportOption;
	
	@FindBy(how = How.CSS, css = "[data-hover-track='p2481888.m1387.l6435']")
	private WebElement offertsOption;
	
	
	public EbayPrincipalPage(WebDriver driver) 
	{
        super(driver);
    }
}
