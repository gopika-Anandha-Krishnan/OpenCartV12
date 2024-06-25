package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver); //driver initiated	
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnk_myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnk_register;
	
	@FindBy(linkText="Login") WebElement loginLink;
	
	public void clickMyAccount()
	{
		lnk_myaccount.click();
	}
	public void clickRegister()
	{
		lnk_register.click();
	}
	public void clickLoginLink()
	{
		loginLink.click();
	}

}
