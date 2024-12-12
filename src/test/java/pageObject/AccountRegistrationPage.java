package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']") 
	 WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']") 
	 WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']") 
	 WebElement txtEmaillId;
	
	@FindBy(xpath = "//input[@id='input-telephone']") 
	 WebElement txtTelephoneNo;
	
	@FindBy(xpath = "//input[@id='input-password']") 
	 WebElement txtPwd;
	
	@FindBy(xpath = "//input[@id='input-confirm']") 
	 WebElement txtCnfPwd;
	
	@FindBy(xpath = "//input[@name='agree']") 
	 WebElement chkAgree;
	
	@FindBy(xpath = "//input[@value='Continue']") 
	 WebElement btnContinue;
	
	
	@FindBy(xpath = "(//h1[normalize-space()='Your Account Has Been Created!'])[1]")
	WebElement textCnfMsg;
	
	
	public void  setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void  setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void  setEmailId(String emailId)
	{
		txtEmaillId.sendKeys(emailId);
	}
	
	public void  setTelephoneNo(String telPhno)
	{
		txtTelephoneNo.sendKeys(telPhno);
	}
	
	public void  setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void  setCnfPassword(String cnfPwd)
	{
		txtCnfPwd.sendKeys(cnfPwd);
	}
	
	public void clickAgreeChkBox()
	{
		chkAgree.click();
	}
	
	public void clickOnContinue()
	{
		btnContinue.click();
	}
	
	public String getConfermationMsg()
	{
		try {
			return textCnfMsg.getText();
		}
		catch(Exception e)
		{
		 return e.getMessage();
		}
		
	}

	
}
