package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DemoQABookStoreLogin extends BasePage {
	public DemoQABookStoreLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "(//*[@class='card mt-4 top-card'])[6]//div[@class='card-body']//h5[contains(text(),'Book')]")
	private WebElement bookStoreApplicationMenu;
	
	@FindBy(xpath = "//*[@class='text-right col-md-4 col-sm-12']//button[@id='login']")
	private WebElement bookStoreLoginBtn;
	
	@FindBy(xpath = "//*[@class='col-md-9 col-sm-12']//input[@placeholder='UserName']")
	private WebElement usernametxtBox;
	
	@FindBy(xpath = "//*[@class='col-md-9 col-sm-12']//input[@placeholder='Password']")
	private WebElement pwdtxtBox;
	
	@FindBy(xpath = "//*[@class='text-right button']//button[@id='login']")
	private WebElement loginBtn;
	
	//@FindBy(xpath = "//*[@class='text-right col-md-4 col-sm-12']//button[@id='submit']")
	@FindBy(xpath = "//*[contains(text(),'Log out')]")
	private WebElement logoutBtn;
	
	public void clickBookStoreApplication() throws Exception {
		scrollToView(bookStoreApplicationMenu);
		doClick(bookStoreApplicationMenu, "bookStoreApplicationMenu", bookStoreApplicationMenu);
	}
	
	public void clickBookStoreLoginBtn() {
		doClick(bookStoreLoginBtn, "bookStoreLoginBtn", bookStoreApplicationMenu);
	}
	
	public void enterUserName(String input) {
		doSendKeys(usernametxtBox,input );
	}
	
	public void enterPassword(String input) {
		doSendKeys(pwdtxtBox, input);
	}
	
	public void clickLoginbtn() {
		doClick(loginBtn, "login button", loginBtn);
	}
	
	public void clickLogoutBtn() {
		doClick(logoutBtn, "Logout Button", logoutBtn);
	}
}
