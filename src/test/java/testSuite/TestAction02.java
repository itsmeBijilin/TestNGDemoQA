package testSuite;

import org.testng.annotations.Test;

import pageObjects.TC_01_ElementActions;

public class TestAction02 extends BaseClass {
	@Test(groups = {"TestAction2"})
	public void tc_02_checkBoxAction() throws Exception{
		logger.info("****Starting tc_02_textAction02******");
		new TC_01_ElementActions().toValidatePracticeForm();
		new TC_01_ElementActions().toClickElementText();
		new TC_01_ElementActions().toClickCheckBoxMenu();
		new TC_01_ElementActions().toclickCheckBox();
	}
}
