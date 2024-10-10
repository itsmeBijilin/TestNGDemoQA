package tutorials;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//tag id --> tag#id
//tag classname --> tag.classname
//tag attribute --> tag[attribute="value"]
//tag classname attribute --> tag.classname[attribute="value"]


public class _1_CssSelectors {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	// tagname#id	
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
	// tagname.classname
		driver.findElement(By.cssSelector("input.submit-button")).click();
	// tagname[attribute='value']
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	// tagname.classname[attribute='value']
	    driver.findElement(By.cssSelector("input.submit-button[data-test='login-button']")).click();
	}
}
