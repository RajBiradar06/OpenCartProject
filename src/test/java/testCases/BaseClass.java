package testCases;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@Parameters({"os","browser"})
	@BeforeClass(groups = {"Sanity","Regression","Master","DataDriven"})
	public void setup(String os,String browser) throws IOException
	{
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
	
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("exicution_env").equalsIgnoreCase("remote"))
		{
			//String url = "http://192.168.1.22:4444/wd/hub";
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
		 switch(os.toLowerCase())
		 {
		 case "windows" : capabilities.setPlatform(Platform.WIN11); break;
		 case "mac" : capabilities.setPlatform(Platform.MAC); break;
		 case "linux" : capabilities.setPlatform(Platform.LINUX); break;
		 default : System.out.println("Invalid Operating System"); return;
		 }
		 
		 switch(browser.toLowerCase())
		 {
		 case "chrome" : capabilities.setBrowserName("chrome"); break;
		 case "edge" : capabilities.setBrowserName("MicroSoftEdge"); break;
		 case "firefox" : capabilities.setBrowserName("firefox"); break;
		 default : System.out.println("Invalid Browser name"); return;
		 }
		 
		 driver = new RemoteWebDriver(new URL("http://192.168.1.22:4444/wd/hub"),capabilities);		
		}
		
		if(p.getProperty("exicution_env").equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			{
			case "chrome" :  driver = new ChromeDriver(); break;
			case "edge"   :  driver = new EdgeDriver(); break;
			case "firefox"   :  driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid Browser"); return;
		    }
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass(groups = {"Sanity","Regression","Master","DataDriven"})
	public void tearDown()
	{
		driver.close();
	}
	
	
	public String randomString()
	{
		String genratedString = RandomStringUtils.randomAlphabetic(6);
		return genratedString;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
