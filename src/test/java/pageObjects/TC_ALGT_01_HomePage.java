package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commonActions.CommonActions;

public class TC_ALGT_01_HomePage extends CommonActions {
	@FindBy(xpath = "//*[@data-hook='overlay-merchandise_ice-pop_content']//button//img[@alt='closeIcon']")
	private WebElement popUpcloseIcon;

	@FindBy(xpath = "//*[@type='button' and @aria-hidden='false']")
	private WebElement availableDates;

	@FindBy(xpath = "//*[@class='Box-s8oj9r-0 eQqpHg']//div//img[@alt]")
	private WebElement popUp;

	@FindBy(xpath = "(//*[@class='Radio__IconContainer-owm0zi-0 fIAozG'])[2]")
	private WebElement oneWayTripType;

	@FindBy(xpath = "//*[@class=' css-2b097c-container']//div[@data-hook='flight-search-origin']")
	private WebElement flightOriginSearch;

	@FindBy(xpath = "(//*[@class=' css-7udyxf'])[2]//div/following-sibling::div")
	private List<WebElement> availableOriginPlaces;

	@FindBy(xpath = "//*[@class=' css-2b097c-container']//div[@data-hook='flight-search-destination']")
	private WebElement destinationOriginSearch;

	@FindBy(xpath = "(//*[@class=' css-7udyxf'])[2]//div/following-sibling::div")
	private List<WebElement> availableDestinationPlaces;

	@FindBy(xpath = "//*[@class='Input__IconContainer-dn8eno-0 bVAduy']//button[@class='DatePicker__DateFieldControl-iz35q0-0 gecfVU']")
	private WebElement departureDateField;
	
	@FindBy(xpath = "//*[@aria-label='Go to next month']")
	private WebElement nextMonthButton;

	@FindBy(xpath = "(//*[@class='Box-s8oj9r-0 dLFASS'])[2]//div[@class='Box-s8oj9r-0 iSygsH']//div[@class='Calendar__Grid-epvxa4-0 Calendar__DateGrid-epvxa4-3 gNEFIj']//button[@aria-label]")
	private List<WebElement> availableDatesForBothMonths;
	
	@FindBy(xpath = "(//*[@class='Box-s8oj9r-0 dLFASS'])[2]//div[@class='Box-s8oj9r-0 iSygsH']//div[@class='Calendar-epvxa4-5 eWjqjo']//div[@class='Box-s8oj9r-0 SKvhu']//h2[@class='Calendar__MonthAndYearHeading-epvxa4-4 chbQGp']//span[@class='Text-sc-1o5ubbx-0 yLrzK']")
	private List<WebElement> monthDisplayed;
	
	@FindBy(xpath = "//*[@class='Expando__Label-sc-1am1gqe-0 diqXdw']//button[@data-hook='flight-search-travelers-expando-button']")
	private WebElement travellersField;
	
	@FindBy(xpath = "(//*[@aria-controls='adults'])[2]")
	private WebElement adultIncrementButton;
	
	@FindBy(xpath = "//*[@class='FlightSearchForm__GAClickEventTracker-lmu5bc-1 cmHRyO']//button[@data-hook='flight-search-submit']")
	private WebElement searchButton;
	
	
	public TC_ALGT_01_HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	public void closePopUpIcon() {
		explicitWait(popUp);
		doClick(popUpcloseIcon, "Pop up close icon", popUpcloseIcon);
	}

	public void clickOneWayTrip() {
		doClick(oneWayTripType, "One Way Trip Type", oneWayTripType);
	}

	public void originClick_Selection() throws Exception {
		doClick(flightOriginSearch, "flightOriginSearch", flightOriginSearch);
		Thread.sleep(2000);
		toSelectRequiredCity(availableOriginPlaces, "(LAS)");
	}

	public void destinationClick_Selection() throws Exception {
		doClick(destinationOriginSearch, "destinationOriginSearch", destinationOriginSearch);
		Thread.sleep(2000);
		toSelectRequiredCity(availableDestinationPlaces, "(BLI)");
	}

	public void clickDepartureDateField() throws Exception {
		Thread.sleep(2000);
		explicitWait(departureDateField);
		doClick(departureDateField, "departureDateField", departureDateField);
	}

	public void selectingDate() {
		List<WebElement> reqDates = new ArrayList<WebElement>();
		for (WebElement availDates : availableDatesForBothMonths) {
			String d = availDates.getText();
			String b = availDates.getAttribute("disabled");
			String c = availDates.getAttribute("aria-hidden");
			if (b == null) {
				if (d.isEmpty() == false) {
					reqDates.add(availDates);
				}
			}
		}
		System.out.println(reqDates.size());
		reqDates.get(0).click();
	}
	
	public void clickTravellersField() {
		explicitWait(travellersField);
		doClick(travellersField, "Travellers Field", travellersField);
	}
	
	public void clickAdultIncrement() {
		explicitWait(adultIncrementButton);
		doClick(adultIncrementButton, "Adult Increment Button", adultIncrementButton);
	}
	
	public void clickSearchButton() {
		explicitWait(searchButton);
		doClick(searchButton, "Search Button", searchButton);
	}
}
