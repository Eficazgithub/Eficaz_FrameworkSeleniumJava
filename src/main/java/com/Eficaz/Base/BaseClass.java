package com.Eficaz.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public WebDriver driver; 
	public Properties prop;
	public static Logger logger;
	
    
	
	@BeforeClass
    public WebDriver initializeBrowser() throws IOException, InterruptedException  {
		 
	
//Adding Log4J
			logger = LogManager.getLogger("eficaz");
	
	    
//Read configuration file
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Administrator\\Documents\\EfficazWork\\Configuration\\Config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
//Handle connection is not private
		ChromeOptions options=new ChromeOptions();
    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
    	//browser selection
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver104.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	
	}
//=====================================================================================================================================		
// Login Test Added for all functionality
	
	//@BeforeClass
	//@Test
	//public void VerifyLogin() throws InterruptedException, IOException {
		 // Enter URL
//			    	driver.get(prop.getProperty("url"));
//			    	logger.info("URL is opened");
//					
//	    // Create Login page Object to call mtds   
//			    	LogInPage lp=new LogInPage(driver);
//	
//			    	logger.info("***************TestCase Verify Login starts*****************"); 
//		 // Enter username	 
//			        lp.enterUserNameField(prop.getProperty("username"));
//			        logger.info("Entered username");
//			    	
//		 // Enter password		    	
//			    	lp.enterPasswordField(prop.getProperty("password"));
//			        logger.info("Entered password");
//			        Thread.sleep(1000);
//			        
//		 // Click Login Button	        
//			    	lp.clickloginButton();
//			    	logger.info("Login Button Clicked");   
//			    	
//		 // Navigate Back to Login Page
//			    	driver.navigate().back();
//			    	lp.clickloginButton();
//			    	logger.info("clicked login button Second time");  
//			    	
//		 // verify the login successful or not
//			    	HomePage hp=new HomePage(driver);
//			    	String ChangePassText=hp.getChangePasswordText();
//			    	if(ChangePassText.equals("Change password"))
//				    {
//				    	Assert.assertTrue(true);
//				    	logger.info("Verify Login - Passed");
//				    	logger.info("***************TestCase Verify Login ends*****************"); 
//				    }
//				    else
//				    {
//				    	logger.info("Verify Login - Failed");
//				    	captureScreenShot(driver,"VerifyLogin");
//				    	Assert.assertTrue(false);
//				    }
//			    	
//					
//		       }
	
//=====================================================================================================================	    	

				@AfterClass
				    public void closure()
				    {
					    driver.close();
				    	driver.quit();
				    	
				    
				    }
//=======================================================================================================================

	//user method to capture screen shot
				
				public void captureScreenShot(WebDriver driver,String testName) throws IOException
				{
					//step1: convert Webdriver object to TakesScreenshot interface
					TakesScreenshot screenshot = ((TakesScreenshot)driver);
					
					//step2: call getScreenshotAs method to create image file
					
					File src = screenshot.getScreenshotAs(OutputType.FILE);
					
					File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
				
					//step3: copy image file to destination
					FileUtils.copyFile(src, dest);
				}
//=====================================================================================================================================
}
