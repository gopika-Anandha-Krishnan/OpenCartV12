package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDTLoginTest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")//getting data provider from different class
	public void verify_LoginDDT(String email, String pswd,String exp)
	{
		try {
			
		logger.info("***Starting TC003_DDTLoginTest***");
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		//login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pswd);
		lp.clickLoginButton();
		
		//myaccount
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage=map.ifMyAccountPageExist();
				
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
			
		logger.info("***Finished TC003_DDTLoginTest***");
		
	}

}
