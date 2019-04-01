package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class MainTest {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("os.name"));

		ChromeDriverService service = new ChromeDriverService.Builder()
	            .usingDriverExecutable(new File("src/main/resources/chromedriver"))
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
		
		//driver.get("https://login.yahoo.com");
		MainPage login = new MainPage(driver);
	}

}
