package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends Page{

	@FindBy(xpath="//input[@name='tripType' and @value='oneway']")
	private WebElement tripType;
	
	@FindBy(name="passCount")
	private WebElement passengers;
	
	@FindBy(name="fromPort")
	private WebElement fromPort;
	
	//name="fromMonth"   November
	@FindBy(name="fromMonth")
	private WebElement fromMonth;
	
	//name="fromDay" 2
	@FindBy(name="fromDay")
	private WebElement fromDay;
	
	//name="toPort"  Seattle
	@FindBy(name="toPort")
	private WebElement toPort;
	
	//name="toMonth"  December
	@FindBy(name="toMonth")
	private WebElement toMonth;
	
	//name="toDay"  19
	@FindBy(name="toDay")
	private WebElement toDay;
	
	//name="servClass"  value="Business"
	@FindBy(xpath="//input[@name='servClass' and @value='Business']")
	private WebElement servClass;
	
	
	//name="airline"  Pangea Airlines
	@FindBy(name="airline")
	private WebElement airlines;
	
	
	public WebDriver selectTripType() {
		tripType.click();
		return driver;
	}
	public WebDriver selectPassengersCount(Integer count) {
		Select pasCount = new Select(passengers);
		pasCount.selectByValue(count.toString()); 
		return driver;
	}
	public WebDriver selectFromPort(String portName) {
		Select port = new Select(fromPort);
		port.selectByValue(portName); 
		return driver;
	}
	public WebDriver selectFromMonth(String monthName) {
		Select month = new Select(fromMonth);
		month.selectByVisibleText(monthName); 
		return driver;
	}
	public WebDriver selectFromDay(Integer dayInt) {
		Select day = new Select(fromDay);
		day.selectByValue(dayInt.toString()); 
		return driver;
	}
	public WebDriver selectToPort(String portName) {
		Select port = new Select(toPort);
		port.selectByValue(portName); 
		return driver;
	}
	public WebDriver selectToMonth(String monthName) {
		Select month = new Select(toMonth);
		month.selectByVisibleText(monthName); 
		return driver;
	}
	public WebDriver selectToDay(Integer dayInt) {
		Select day = new Select(toDay);
		day.selectByValue(dayInt.toString()); 
		return driver;
	}
	public WebDriver selectAirline(String linesName) {
		Select lines = new Select(airlines);
		lines.selectByVisibleText(linesName); 
		return driver;
	}
	
	
	public FlightFinderPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.URL = "http://newtours.demoaut.com/mercuryreservation.php";
		tripType.click();
		this.selectPassengersCount(2);
		this.selectFromPort("Paris");
		this.selectFromMonth("November");
		this.selectFromDay(20);
		this.selectToPort("Seattle");
		this.selectFromMonth("December");
		this.selectFromDay(19);
		this.servClass.click();
		this.selectAirline("Pangea Airlines");
		
	}
	
}
