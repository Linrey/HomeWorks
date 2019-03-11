package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.URL = "https://login.yahoo.com";
	}
	@Override
	public String getURL() {
		return this.URL;
	}
	public WebDriver login(String log, String pswd) {
		driver = this.getPage();
		// input login
		driver.findElement(By.id("login-username"))
				.sendKeys(log);
		//"test1234mail5678"
		// click sign in btn
		driver.findElement(By.id("login-signin"))
				.sendKeys(Keys.ENTER);
		// input password
		driver.findElement(By.id("login-passwd"))
				.sendKeys(pswd);
		//"zaq1xsw2cde3vfr4"
		// click sign in btn
		driver.findElement(By.id("login-signin"))
				.sendKeys(Keys.ENTER);
//		driver.findElement(By.id("login-signin"))
//				.click();
		return driver;
	}
}
