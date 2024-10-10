package testSuite;

import java.io.FileInputStream;
import java.net.SocketException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import javax.swing.GroupLayout.Group;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commonActions.CommonActions;
import pageObjects.DemoQABookStoreLogin;
import pageObjects.TC_01_ElementActions;

public class BaseClass{
	public static Logger logger; //log4j
	public static WebDriver driver;
	
	/* Load config files */
	public String getUserProperties(String input) throws Exception {
		Properties prop = new Properties();
		FileInputStream FIS = new FileInputStream("D:\\Bijilin\\demoQA\\demoQA\\user.properties");
		String url = null;
		prop.load(FIS);
		if (input.equalsIgnoreCase("Allegiant")) {
			url = prop.getProperty("allegiantUrl");
		} else if (input.equalsIgnoreCase("DemoQA")) {
			url = prop.getProperty("url");
		}
		else if(input.equalsIgnoreCase("DemoQABaseUrl")) {
			url = prop.getProperty("DemoQABaseUrl");
		}
		else
			url=prop.getProperty(input);
		return url;

	}
	
	@BeforeClass(groups = {"TestAction01","TestAction2","Master","DataDriven"})
	@Parameters({"OS","Browser","reqUrl"})
	public void beforeClass(String OS,String Browser,String reqUrl) throws Exception {
		logger=LogManager.getLogger(this.getClass());
		/* Why "this.getClass()- to get the value dynamically from the run time"*/
		
		/*  path of result file "\\src\\test\\java"  */
		
		new CommonActions().toDeleteFiles("\\logs");
		
		if(getUserProperties("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
//			capabilities.setPlatform(Platform.WIN11);
//			capabilities.setBrowserName(Browser);
			
			//OS
			if(OS.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(OS.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching os");
				return; // automatically exit from the block
			}
			
			//browser selection
			if(Browser.equalsIgnoreCase("Chrome")) {
				capabilities.setBrowserName("chrome");
			}
			else if(Browser.equalsIgnoreCase("Edge")) {
				capabilities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("No matching browser");
				return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				
		}
			
		if(getUserProperties("execution_env").equalsIgnoreCase("local")) {
			if(Browser.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(Browser.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
			}
			else 
				System.out.println("Invalid Browser");
		}
		
		
		
		
//		switch("") {
//		case "chrome":driver=new ChromeDriver();break;
//		case "firefox":driver=new FirefoxDriver();break;
//		case "edge":driver=new EdgeDriver();break;
//		default: System.out.println("Invalid browser name");return; /*return : totally exist from the execution as we doesn't have browser */
//		/** If we doesn't put return, then it will run the next line */
//		}
//		
//		driver = new ChromeDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		System.out.println("OS "+OS +" browser "+Browser +" reqUrl "+reqUrl);
		System.out.println(reqUrl);
		driver.get(getUserProperties(reqUrl));
//		new DemoQABookStoreLogin(driver).clickBookStoreApplication();
//		new DemoQABookStoreLogin(driver).clickBookStoreLoginBtn();
	}
	
	@AfterClass(groups = {"TestAction01","TestAction2","DataDriven"})
	public void afterClass() throws SocketException {
		driver.quit();
		System.out.println("Windows are closed");
		//logger.info("Windows are closed");
	}
}
