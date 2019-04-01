package pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	protected String URL;
	protected WebDriver driver;
	public String getURL() {
		return URL;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver getPage() {
		if(driver.getCurrentUrl().equals(this.getURL())) {
			return driver;
		} else {
			driver.get(this.URL);
			return driver;
		}
	}
}
