package drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static WebDriver driver;
	public static WebDriver getInstance(browsers br) {
		if (driver != null) {
			return driver;
		} else if (br == browsers.CHROME) {
			driver = new ChromeFactory().getDriver();
		}
		return driver;
	}
	public static void tearDown() {
		driver.quit();
		driver = null;
	}
}
