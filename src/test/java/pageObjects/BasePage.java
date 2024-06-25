package pageObjects;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		//using this base class, so in every class we don't need to repeat below lines in every class
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
