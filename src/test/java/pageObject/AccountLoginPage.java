package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {

	public AccountLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmailAdress;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login']") WebElement btnLogin;
	
	public void setEmailAdress(String emailId)
	{
		txtEmailAdress.sendKeys(emailId);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btnLogin.click();	
	}
	

}
