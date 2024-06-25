package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
			
	@Test(groups={"Regression","Master"})
	public void verifyAccountRegistration()
	{
		logger.info("*****Starting*****");
		try
		{
		HomePage hp = new HomePage(driver);
		logger.info("***Clicked on My Account link***");
		hp.clickMyAccount();
		logger.info("***Clicked on Register link***");
		hp.clickRegister();
		
		AccountRegistration regpage = new AccountRegistration(driver);
		logger.info("***Providing customer details***");
		regpage.setFirstname(randomString().toUpperCase()); //will generate random name
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPhoneNo(randomNumber()); //will pass random numbers
		
		String password = randomAlphaNumeric(); //will generate alphanumeric value
		regpage.setPassword(password); 
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickOnContinue();
		
		logger.info("***Validating expected confirmation message***");
		String cnfrmMessage = regpage.getConfirmationMessage();
		if(cnfrmMessage.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}

}
