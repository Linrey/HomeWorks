package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectFlightPage extends Page{

	@FindBy(xpath="//input[@name='outFlight' and contains(@value,'Unified Airlines')]")
	private WebElement tripType;
	
	
	
	@FindBy(name="passCount")
	private WebElement passengers;
	
	
	public WebDriver selectPassengersCount(Integer count) {
		Select pasCount = new Select(passengers);
		pasCount.selectByValue(count.toString()); 
		return driver;
	}
	public WebDriver selectFromPort(String port) {
		Select pasCount = new Select(passengers);
		pasCount.selectByValue(port); 
		return driver;
	}
	
	
	public SelectFlightPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.URL = "http://newtours.demoaut.com/mercuryreservation2.php";
		tripType.click();
		this.selectPassengersCount(2);
		this.selectFromPort("Paris");
		
	}
	
}
