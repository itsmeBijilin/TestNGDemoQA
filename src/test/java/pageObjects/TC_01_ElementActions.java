package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonActions.CommonActions;

public class TC_01_ElementActions extends CommonActions{
	
	@FindBy(xpath = "//*[contains(@class,'text-center')]")
	private WebElement practiceFormValidation;
	
	@FindBy(xpath = "//*[text()='Elements']")
	private WebElement elementText;
	
	/****** Text Box **********/
	
	@FindBy(xpath = "//*[text()='Text Box']")
	private WebElement textBoxText;
	
	@FindBy(xpath = "//*[@class='col-12 mt-4 col-md-6']//h1[text()='Text Box']")
	private WebElement textBoxTextValidation;
	
	@FindBy(xpath = "//*[@id='userName']")
	private WebElement fullNameField;
	
	@FindBy(xpath = "//*[@id='submit']")
	private WebElement submitButton;
	
	/********** CheckBox ***********/
	@FindBy(xpath = "//*[text()='Check Box']")
	private WebElement checkBoxMenu;
	
	@FindBy(xpath = "//span[@class='rct-checkbox']//*[@class='rct-icon rct-icon-uncheck']")
	private WebElement checkBoxField;
	
	/************** Radio Button ************/
	@FindBy(xpath = "//*[text()='Radio Button']")
	private WebElement radioButtonMenu;
	
	@FindBy(xpath = "//*[@class='col-12 mt-4 col-md-6']//div[@class='custom-control custom-radio custom-control-inline']//input[@type='radio']")
	private List<WebElement> availableOptions;
	
	@FindBy(xpath = "(//*[@class='col-12 mt-4 col-md-6']//div[@class='custom-control custom-radio custom-control-inline']//input[@type='radio'])[1]")
	private WebElement first;
	
	@FindBy(xpath = "//*[@id='yesRadio']")
	private WebElement yesButton;
	
	
	public TC_01_ElementActions() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
	}
	
	public void toValidatePracticeForm() {
		doExplicitlyWait(practiceFormValidation, "Practice Form Validation");
	}
	
	public void toClickElementText() {
		doClick(elementText, "elementText",elementText);
	}
	
	/************* Text Box **************/
	
	public void toClickTextBox() {
		doClick(textBoxText, "textBoxText",textBoxText);
	}
	
	public void toValidateTextBox() {
		doExplicitlyWait(textBoxTextValidation, "textBoxTextValidation");
	}
	
	public void toEnterFullName() {
		doSendKeys(fullNameField, "Test Name");
	}
	
	public void toclickSubmitButton() {
		doExplicitlyWait(submitButton, "Submit Button");
		toScrollToElement(submitButton);
		doClick(submitButton, "Submit Button",submitButton);
	}
	
	/*********** Check Box **************/
	public void toClickCheckBoxMenu() {
		doClick(checkBoxMenu, "checkBoxMenu",checkBoxMenu);
	}
	
	public void toclickCheckBox() {
		doClick(checkBoxField, "Check Box Field",checkBoxField);
	}
	
	/********* Radio Button 
	 * @throws InterruptedException *************/
	public void toClickRadioButtonMenu() throws InterruptedException {
		doClick(radioButtonMenu, "Radio Button Menu",radioButtonMenu);
		//toSelectRandomValuesFromList(availableOptions);
		Thread.sleep(1000);
		doClick(yesButton, "Yes Button",yesButton);
	}
	
	
	
}
