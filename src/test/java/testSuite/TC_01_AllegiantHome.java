package testSuite;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonActions.CommonActions;
import pageObjects.TC_ALGT_01_HomePage;

public class TC_01_AllegiantHome extends CommonActions {
	//@BeforeClass
	public void beforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(getUserProperties("Allegiant"));
		new TC_ALGT_01_HomePage().closePopUpIcon();
	}
	
	//@Test
	public void homePage() throws Exception {
		System.out.println("Initiating home page");
		new TC_ALGT_01_HomePage().clickOneWayTrip();
		new TC_ALGT_01_HomePage().originClick_Selection();
		new TC_ALGT_01_HomePage().destinationClick_Selection();
		new TC_ALGT_01_HomePage().clickDepartureDateField();
		new TC_ALGT_01_HomePage().selectingDate();
		new TC_ALGT_01_HomePage().clickTravellersField();
		new TC_ALGT_01_HomePage().clickAdultIncrement();
		new TC_ALGT_01_HomePage().clickSearchButton();
		Thread.sleep(3000);
	}
}
