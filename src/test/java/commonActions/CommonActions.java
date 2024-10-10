package commonActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import testSuite.BaseClass;

public class CommonActions extends BaseClass{
	//public static WebDriver driver;
	//public Logger logger;

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
		return url;

	}

//	public void logger() {
//		new LogManager();
//		final Logger logger = LogManager.getLogger(CommonActions.class);
//		BasicConfigurator.configure();
//		logger.info("Logger Message");
//		logger.debug("Logger Debug");
//	}
	
//	public void launchBrowser(String url,String OS,String Browser) throws Exception {
//		driver = new ChromeDriver();
//		System.out.println(Browser);
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
//		driver.get(url);
//	}

	public void doExplicitlyWait(WebElement element, String input) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println(input + " is visible");
		} catch (Exception e) {
			System.out.println(input + " is not visible");
		}
	}

	public void doClick(WebElement element, String input, WebElement elementToWait) {
		try {
			element.click();
			System.out.println(input + " is clicked");
			BaseClass.logger.info(input + " is clicked");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(input + " is not clicked");
			BaseClass.logger.error(input + " is not clicked");
		}
	}

	public void doSendKeys(WebElement element, String input) {
		try {
			element.sendKeys(input);
			System.out.println(input + "is passed into the field");
			BaseClass.logger.info(input + "is passed into the field");
		} catch (Exception e) {
			System.out.println(input + "is not passed into the field");
			 BaseClass.logger.info(input + "is not passed into the field");
		}
	}

	public void toScrollToElement(WebElement element) {
		try {
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Exception on scrolling the window");
		}
	}

	public Integer getRandomNumbers(int lowNum, int highNum) {
		Random rand = new Random();
		int num = rand.nextInt(highNum - lowNum) + lowNum;
		return num;
	}

	public void toSelectRandomValuesFromList(List<WebElement> elements) throws InterruptedException {
		int length = elements.size();
		System.out.println(length);
		int index = getRandomNumbers(1, length);
		System.out.println(index);
		for (int i = 0; i <= length; i++) {
			System.out.println("INside for");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
			break;
		}
	}

	/*
	 * Finding the difference of times
	 * 
	 * public static void main(String[] args) throws Exception { String time1 =
	 * "16:00:00"; String time2 = "19:00:00";
	 * 
	 * SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss"); Date date1 =
	 * format.parse(time1); // parse - will convert date format into milliseconds
	 * Date date2 = format.parse(time2); long difference = date2.getTime() -
	 * date1.getTime(); System.out.println(difference);
	 * 
	 * System.out.println(Math.abs(date1.getTime())); // Math.abs, negative value
	 * will be changed to positive value
	 * 
	 * String hms = String.format("%02d:%02d:%02d",
	 * TimeUnit.MILLISECONDS.toHours(difference),
	 * TimeUnit.MILLISECONDS.toMinutes(difference) -
	 * TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(difference)),
	 * TimeUnit.MILLISECONDS.toSeconds(difference) -
	 * TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference)));
	 * System.out.println(hms); }
	 * 
	 */

	public void fileUpload(String path) throws Exception {
		// *********** File Upload ****************

		Robot rb = new Robot();
		rb.delay(2000);

		// Put path to file in a clipboard
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.delay(2000);

		// copy the path
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// paste the path
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.delay(2000);

		// Click on the Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void scrollToView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		// js.executeScript("window.scrollBy(0,250)", "");
		/*
		 * 
		 * js.executeScript(
		 * "document.getElementById('user_email_login').value='rbc@xyz.com';");
		 * js.executeScript("document.getElementById('user_password').value='password';"
		 * ); js.executeScript("document.getElementById('user_submit').click();");
		 * js.executeScript("alert('enter correct login credentials to continue');");
		 * 
		 * 
		 */

		// Random r = new Random();
		// char c = (char)(r.nextInt(26) + 'a');
	}

	public void dateFormat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate));
	}

	public void closePopupDialog() {
		String JS_DISABLE_UNLOAD_DIALOG = "Object.defineProperty(BeforeUnloadEvent.prototype, 'returnValue', { get:function(){}, set:function(){} });";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(JS_DISABLE_UNLOAD_DIALOG);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		//wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element.isDisplayed()) {
			  System.out.println(element.getText()+"is visible");
		} else {
			System.out.println(element.getText()+"is visible");
		}
	}
	
	public void toSelectRequiredCity(List<WebElement> elements,String input) {
		for (WebElement element : elements) {
			String getText=element.getText();
//			System.out.println("**"+getText);
//			System.out.println("**"+input);
			if(getText.endsWith(input)) {
				element.click();
				System.out.println(getText+"is clicked");
				break;
			}
		}
	}
	
	 /*To get list of files*/
	public void toDeleteFiles(String path) {
		String directoryPath=System.getProperty("user.dir")+path;
		System.out.println(directoryPath);
		File directory = new File(directoryPath); 
		File[] files=directory.listFiles();
		int numOfFiles=files.length;
		if(numOfFiles!=0) {
			for (File file : files) {
				file.delete();
				System.out.println(file.getName()+" is deleted");
		}	
		}
	}
	
	
	/* Random string creation*/
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	/* Random Number */
	public String randomNumber() {
		return  RandomStringUtils.randomNumeric(10);
	}
	
	public String captureScreen(String tname){

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);   //True or false
			
		return targetFilePath;

	}
	
	/*** Convertion from int to String */
	/*
	 * 
	 * int i=10;
	 * Integer.toString(i);
	 * 
	 */
	
	/** Convertion from String to Integer */
	/* String a="abcd";
	 * Integer.parseInt(a);
	 * 
	 * String.valueof(a);
	 * 
	 */
	
}
