package gmail;
import javax.management.DescriptorKey;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.gmail.gmailBox.GmailInboxPage;
import pageObjects.gmail.loginPages.PasswordLoginPage;
import pageObjects.gmail.loginPages.UserLoginPage;

/**
 * This class have all the test cases to verify the login flows.
 */
public class LoginTestCases extends TestBase
{

		@BeforeMethod(description = "Navigate to gmail page")
		public void testSetup() 
		{	
			getDriver().get(configReader.getGmailBaseURL());
		}
	
		/**  
		 * @Id: TC-01
		 */
		@Test(description = "This test case verify if user is be able to do a correct login")
		public void loginTest()
		{
	        UserLoginPage userPage = new UserLoginPage(getDriver());
	        //Complete user name
	        userPage.setUser(configReader.getUser());
	        //Click on Next button
	        PasswordLoginPage passwordPage = userPage.clickNextUserButton();
	        //Complete password
	        passwordPage.setPassword(configReader.getPassword());
	        //Click on Next button
	        GmailInboxPage dashboard = passwordPage.clickNextPasswordButton();
	        //Verify if profile image is present
	        Assert.assertTrue(dashboard.isUserLogged());
	        //Click on Profile image
	        dashboard.clickProfileImage();
	        //Verify email account
	        Assert.assertTrue(dashboard.isEmailPresent(configReader.getUser()));
	        //Logout
	        dashboard.clickLogoutButton();
		}
		
		/**  
		 * @Id: TC-02
		 */
		@Test(description = "This test case verify if system is showing an error when user is not eneter in the login flow")
		public void VerifyEmptyUserError() 
		{
	        UserLoginPage userPage = new UserLoginPage(getDriver());
	        //Complete user with empty value
	        userPage.setUser(StringUtils.EMPTY);
	        //Click on Next button
	        userPage.clickNextUserButton();
	        //Verify if error element is present
	        Assert.assertTrue(userPage.isErrorPresent());
		}
		
		/**  
		 * @Id: TC-03
		 */
		@Test(description = "This test case verify if system is showing an error when password is not eneter in the login flow")
		public void VerifyEmptyPasswordError() 
		{
			UserLoginPage userPage = new UserLoginPage(getDriver());
			//Complete user name
	        userPage.setUser(configReader.getUser());
	        //Click on Next button
	        PasswordLoginPage passwordPage = userPage.clickNextUserButton();
	        //Complete password with empty value
	        passwordPage.setPassword(StringUtils.EMPTY);
	        //Click on Next button
	        passwordPage.clickNextPasswordButton();
	        //Verify if error element is present
	        Assert.assertTrue(passwordPage.isErrorPresent());
		}
		
		/**  
		 * @Id: TC-04
		 */
		@Test(description = "This test case verify if system is showing an error when password is wrong")
		public void VerifyWrongPasswordError() 
		{
			UserLoginPage userPage = new UserLoginPage(getDriver());
			//Complete user name
	        userPage.setUser(configReader.getUser());
	        //Click on Next button
	        PasswordLoginPage passwordPage = userPage.clickNextUserButton();
	        //Complete password with wrong value
	        passwordPage.setPassword("This Pass Does Not Exist");
	        //Click on Next button
	        passwordPage.clickNextPasswordButton();
	        //Verify if error element is present
	        Assert.assertTrue(passwordPage.isErrorPresent());
		}
}
