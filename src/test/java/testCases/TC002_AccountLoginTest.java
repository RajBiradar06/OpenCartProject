package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountLoginPage;
import pageObject.HomePage;
import pageObject.MyAccountPage;

public class TC002_AccountLoginTest extends BaseClass{
	
	
	@Test(groups = {"Sanity","Regression","Master"})
	public void verify_Login() throws InterruptedException
	{
		try {
		logger.info("****** started exicution of TC002_AccountLoginTest ****");
		HomePage pg=new HomePage(driver);
		pg.clickMyAccounts();
		pg.ClickLogin();
		
		AccountLoginPage acctlp=new AccountLoginPage(driver);
		acctlp.setEmailAdress(p.getProperty("email"));
		acctlp.setPassword(p.getProperty("pwd"));
		acctlp.clicklogin();
		
		Thread.sleep(3000);
		MyAccountPage maccp=new MyAccountPage(driver);
		
		boolean targetPage = maccp.isMyAccountPageExist();
		
		Assert.assertTrue(targetPage);
		}catch(Exception e)
		{
			logger.info("****** Finished exiction of TC002_AccountLoginTest ***");
			Assert.fail();
		}
		
		
		logger.info("****** started exicution of TC002_AccountLoginTest ****");
		
	}

}
