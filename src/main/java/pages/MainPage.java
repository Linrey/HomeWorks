package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page{
	
	@FindBy(name="userName")
	private WebElement loginInput;
	@FindBy(name="password")
	private WebElement pswdInput;
	@FindBy(name="login")
	private WebElement loginBtn;
	
	public MainPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		this.URL = "http://newtours.demoaut.com/";
		//Проверочные тесты
		this.getPage();
		this.login("tutorial", "tutorial");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		FlightFinderPage find = new FlightFinderPage(driver);
		
//		driver.quit();
		
	}
	
	public WebDriver login(String login,String password) {
		loginInput.clear();
		loginInput.sendKeys(login);
		pswdInput.clear();
		pswdInput.sendKeys(password);
		loginBtn.click();
		return driver;
	}
}
