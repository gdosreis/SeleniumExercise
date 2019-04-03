package gmail;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.gmail.gmailBox.GmailInboxPage;
import pageObjects.gmail.loginPages.UserLoginPage;
import pageObjects.gmail.registrationPages.AccounDataRegistrationtPage;
import pageObjects.gmail.registrationPages.PersonalDataRegistracionPage;
import pageObjects.gmail.registrationPages.PhoneNumberRegistrationPage;
import pageObjects.gmail.registrationPages.TermsAndConditionsPage;
import pageObjects.gmail.registrationPages.VerificatonNumberPage;



/**
 * This class have the test cases to verify the gmail registration.
 */
public class CreateAccountTestCase extends TestBase
{
		private AccounDataRegistrationtPage accountDate;
	
		@BeforeMethod(description = "Navigate to gmail  page and clicks on Create account")
		public void testSetup() 
		{
			getDriver().get(configReader.getGmailBaseURL());
			UserLoginPage userPage = new UserLoginPage(getDriver());
		    userPage.clickCreateAccountOption();
		    accountDate = userPage.clickForMeOption();
		}
	
		/**  
		 * @Id: TC-05
		 */
		@Ignore("The system ask confirmation phone number code and it is complicated to automated now.")
		@Test(description = "This test case verify if user is be able to create a gmail account. It is only an example, because it will not work.")
		public void createAccounTestCases() 
		{
			int random = new Random().nextInt(99999);
			String name = "german" + random;
			String lastName = "dr" + random;
			String userName = "gdremail"+ random;
			String password = "@asd.123";
			System.out.println("El dnombre del usuario es: "+userName);
			//Complete all account data
	        accountDate.setFirstName(name);
	        accountDate.setLastName(lastName);
	        accountDate.setUsername(userName);
	        accountDate.setPassword(password);
	        accountDate.setConfirmationPassword(password);
	        //Click on Next button
	        PhoneNumberRegistrationPage phonePage = accountDate.clickOnNextButton();
	        //Complete phone number field
	        phonePage.setPhoneNumber("2494525636");
	        //Click on Next button
	        VerificatonNumberPage verificationPage = phonePage.clickNextButton();
	        //Complete phone number field
	        verificationPage.setCodeNumber("2494525");
	        //Click on Verify button
	        PersonalDataRegistracionPage personalData = verificationPage.clickVerifyButton();
	        //Complete birth date and gender
	        personalData.setDay("01");
	        personalData.setMonth("A");
	        personalData.setYear("1985");
	        personalData.setGender("M");
	        //Click on Next button
	        TermsAndConditionsPage conditionPage = personalData.clickNextButton();
	        //Click on scroll button until Accept button is displayed
	        conditionPage.clickScrollDownButton();
	        conditionPage.clickScrollDownButton();
	        conditionPage.clickScrollDownButton();
	        conditionPage.clickScrollDownButton();
	        //Click on Accept button
	        GmailInboxPage dashboard = conditionPage.clickAcceptButton();
	        //Verify if I am on inbox
	        Assert.assertTrue(dashboard.isUserLogged());
		}
}
