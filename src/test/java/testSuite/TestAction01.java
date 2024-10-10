package testSuite;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonActions.CommonActions;
import pageObjects.TC_01_ElementActions;

public class TestAction01 extends BaseClass{
	
	
	@Test(groups = {"TestAction01"})
	public void tc_01_textBoxAction() throws Exception {
		logger.info("****Starting tc_01_textBoxAction******");
		new TC_01_ElementActions().toValidatePracticeForm();
		new TC_01_ElementActions().toClickElementText();
		new TC_01_ElementActions().toClickTextBox();
		new TC_01_ElementActions().toValidateTextBox();
		new TC_01_ElementActions().toEnterFullName();
		new TC_01_ElementActions().toclickSubmitButton();
		logger.info("**Finishing tc_01_textBoxAction");
		Thread.sleep(2000);
	}
	
	
	
	//@Test
	public void tc_03_radioButton() throws InterruptedException {
		new TC_01_ElementActions().toClickRadioButtonMenu();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Radio Button']")).click();
		
		driver.findElement(By.xpath("//*[@id='yesRadio']")).click();
		Thread.sleep(2000);
	}
}
