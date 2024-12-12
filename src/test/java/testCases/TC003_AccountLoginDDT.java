package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountLoginPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;
import utlities.DataProviders;

public class TC003_AccountLoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")
	public void verify_LoginDDT(String email,String pwd,String expValue)
	{
	try {
		HomePage pg=new HomePage(driver);
		pg.clickMyAccounts();
		pg.ClickLogin();
		
		AccountLoginPage acctlp=new AccountLoginPage(driver);
		acctlp.setEmailAdress(p.getProperty("email"));
		acctlp.setPassword(p.getProperty("pwd"));
		acctlp.clicklogin();
		
		MyAccountPage maccp=new MyAccountPage(driver);
		
		boolean targetPage = maccp.isMyAccountPageExist();
		
		if(expValue.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				maccp.clickLogOut();
				Assert.assertTrue(targetPage);
			}
			else
			{
				Assert.fail();
			}
		}
		
		if(expValue.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				maccp.clickLogOut();
				Assert.fail();
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e)
	 {
		Assert.fail();
	 }
		
		
	}

}
