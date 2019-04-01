package drivers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeFactory extends Factory{

	@Override
	public WebDriver getDriver() {
		ChromeDriverService service = new ChromeDriverService.Builder()
	            .usingDriverExecutable(new File("res/chromedriver.exe"))
	            //.usingDriverExecutable(new File("res/chromedriver"))
	            .usingAnyFreePort()
	            .build();
        try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		WebDriver driver = new ChromeDriver(service);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
}
