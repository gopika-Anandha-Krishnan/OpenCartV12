package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtYourPswrd;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtCnfrmPswrd;
	@FindBy(xpath="//input[@name='agree']") WebElement checkPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPhoneNo(String phone)
	{
		txtPhone.sendKeys(phone);
	}
	public void setPassword(String pswd)
	{
		txtYourPswrd.sendKeys(pswd);
	}
	public void setConfirmPassword(String pswd)
	{
		txtCnfrmPswrd.sendKeys(pswd);
	}
	public void setPrivacyPolicy()
	{
		checkPolicy.click();
	}
	public void clickOnContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMessage()
	{
		try
		{
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
