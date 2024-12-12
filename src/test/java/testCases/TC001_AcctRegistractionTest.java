package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC001_AcctRegistractionTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void testAcctRegistartion() throws InterruptedException
	{
	try 
	{
		
		logger.info("**** Test exicutionn started ****");
		HomePage hp=new HomePage(driver);
		logger.info("*** clicked on my accounts link");
		hp.clickMyAccounts();
		logger.info("*** clicked on register link ***");
		hp.ClickRegister();
		
		AccountRegistrationPage regPg = new AccountRegistrationPage(driver);
		logger.info("*** sent customer details ***");
		regPg.setFirstName("Raj");
		regPg.setLastName("Lucky");
		regPg.setEmailId(randomString()+"@gmail.com");
		regPg.setTelephoneNo("9876565454");
		regPg.setPassword("raj@454");
		regPg.setCnfPassword("raj@454");
		regPg.clickAgreeChkBox();
		regPg.clickOnContinue();
		
		Thread.sleep(3000);
		logger.info("*** verified confirmation message ***");
		String cnfMessage = regPg.getConfermationMsg();
		if (cnfMessage.equals("Your Account Has Been Created!"))
		{
			logger.info("**** Test case Passed****");
		    Assert.assertTrue(true);
		}
		else
		{
			logger.info("**** Test case failed****");
			Assert.fail();
		}
	}
       catch (Exception e)
		{
		  logger.info("******* Test case failed ****");
		  logger.debug("****Test failed*****");
		  Assert.fail();
		}
		
		
	}
	

}
