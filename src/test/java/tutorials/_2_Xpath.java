package tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*2 types
 1. Absolute Xpath(full xpath)
 2. Relative Xpath(partial xpath) 
 
 Reason why relative path?
 Absolute - Its a hierarchy so it might change, if dev change the position then Xpath wont be proper
 
 Abs Xpath--> starts with /
 Rel Xpath --> starts with //
 
 Abs Xpath --> do not use attributes
 Rel xpath --> works with attribute
 
 Abs Xpath --> traverse through each node
 Rel Xpath --> Directly get into the exact node
 
 Tools --> Selectors hub, dev tools or manually 
 
 Relative xpath Syntax
 //tagname[@attribute='value']
 
 Xpath with single attribute
 //input[@type='submit']
  
 Xpath with multiple attribute
  * //input[@type='submit'][@data-test='login-button']
 
 */

/*
 *      Xpath with and or operator
 *  and --> same element la irukra attributes
 *  //input[@id='user-name'  and @type='text']
 *  
 *  or --> same element la irukra attributes
 *  //input[@id='user-name'  or @type='text']
 * 
 */


/*           Text
 * 
 * if only inner text is there
 *      //*[text()='Username']
 * 
 */

/*         Contains
 * 
 *      //*[contains(@placeholder,'User')]
 * 
 */

/*         Starts-with
 * 
 *      //*[starts-with(@class,'input')]
 * 
 *   contains and starts-with should be used for dynamic functions
 */

/*     Chained Xpath (no inner text or attributes)
 * 
 *    combination of absolute and relative xpath
 * 
 * 
 */

/*
 *   Difference between CSS selector and relative xpath
 *   
 *   CSS --> Top to down approach(one directional)
 *   Xpath --> We can get from top to down or from botton to top
 * 
 */



public class _2_Xpath {
	
	public static void main(String[] args) {
		/* And or */
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='user-name'  and @type='text']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@id='password'  and @type='password']")).sendKeys("pass");
		
	}
}
