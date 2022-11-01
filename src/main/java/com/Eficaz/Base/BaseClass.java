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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.Eficaz.PageObject.HomePage;
import com.Eficaz.PageObject.LogInPage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public WebDriver driver; 
	public Properties prop;
	public static Logger logger;
	
    
	
	@BeforeSuite
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
//-------------------------------------------------------------------------------------------------------------------------
		
// Login Test Added for all functionality
	
	@BeforeClass
	public void URLCall() throws InterruptedException {
		 // Enter URL
			    	driver.get(prop.getProperty("url"));
			    	logger.info("URL is opened");
					
	    // Create Login page Object to call mtds   
			    	LogInPage lp=new LogInPage(driver);
			    	
		 // Enter username	 
			        lp.UserNameField().sendKeys(prop.getProperty("username"));
			        logger.info("Entered username");
			    	System.out.println("username Entered");
			    	
		 // Enter password		    	
			    	lp.PasswordField().sendKeys(prop.getProperty("password"));
			        logger.info("Entered password");
			    	System.out.println("password Entered");
			        Thread.sleep(1000);
			        
		 // Click Login Button	        
			    	lp.loginButton().click();
			    	logger.info("Login Button Click");
			    	System.out.println("clicked login button");    
			    	
		 // Navigate Back to Login Page
			    	driver.navigate().back();
			    	lp.loginButton().click();
			    	System.out.println("clicked login button double");  
			    	
		 // verify the login successful or not
			    	HomePage hp=new HomePage(driver);
			    	Assert.assertTrue(hp.logoDisplayed().isDisplayed());
			    	logger.debug("Login Test passed");
			    	System.out.println("Logo got displayed");
					
		       }
			    	
//-------------------------------------------------------------------------------------------------------			    	

				@AfterClass
				    public void closure()
				    {
				    	driver.close();
				    }
//-------------------------------------------------------------------------------------------------------------

	//user method to capture screen shot
				
				public void captureScreenShot(WebDriver driver,String testName) throws IOException
				{
					//step1: convert Webdriver object to TakesScreenshot interface
					TakesScreenshot screenshot = ((TakesScreenshot)driver);
					
					//step2: call getScreenshotAs method to create image file
					
					File src = screenshot.getScreenshotAs(OutputType.FILE);
					
					File dest = new File(System.getProperty("user.dir") + "//Screenshot//" + testName + ".png");
				
					//step3: copy image file to destination
					FileUtils.copyFile(src, dest);
				}
//--------------------------------------------------------------------------------------------------------------------------------
}
