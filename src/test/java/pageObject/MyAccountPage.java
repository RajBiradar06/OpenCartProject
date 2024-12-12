package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogOut;
	
	
	public boolean isMyAccountPageExist()
	{
		 return (msgHeading.isDisplayed());
		
	}
	
	public void clickLogOut()
	{
		lnkLogOut.click();
	}
	

}
