import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import pages.LoginPage;
import pages.MailPage;
import pages.MainPage;
import pages.Page;

public class Test {
	public static ChromeDriverService service;
	public static WebDriver driver;

	public static void main(String[] args) {
		/*
		 * it will be in factory
		 */
		service = new ChromeDriverService.Builder()
	            .usingDriverExecutable(new File("res/chromedriver"))
	            .usingAnyFreePort()
	            .build();
        try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
        /*
         * It will be in driver or no?   "res/chromedriver.exe"
         */
		driver = new ChromeDriver(service);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.get("https://login.yahoo.com");
		LoginPage login = new LoginPage(driver);
		driver = login.getPage();
		

		//"test1234mail5678"
		//"zaq1xsw2cde3vfr4"
		driver = login.login("test1234mail5678","zaq1xsw2cde3vfr4");
//		
//		MainPage mp = new MainPage(driver);
//		System.out.println(mp.isLogin("test1234mail5678"));
		
		MailPage mail = new MailPage(driver);
		driver = mail.getPage();
		//driver.get(mail.DRAFTS_URL);
		//System.out.println(mail.getDraftsCounter());
		
		//mail.deleteDraftsByAction();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
//				"elements[elements.length - 2].scrollIntoView(false);");
		//var elem = elem.querySelectorAll('#mail-app-component li')[60];
		//elem.scrollIntoView();
		
		//
//		List<WebElement> drafts = mail.getDraftsList();
//		for(WebElement draft : drafts) {
//			System.out.println(draft.getText() );
//		}
		//mail.deleteDraftsByAction(mail.DRAFTS_URL);
//		for(int i = 0;i<=100;i++) {
//			mail.createMessage("Test Theme", "Berestnev4@mail.ru", "TestMessage"+i);
//			mail.sendDraft();
//		}
		
		driver.get(mail.SENDED_MESSAGES_URL);
		WebElement firstDraft = mail.getDraftsList().get(0);
		firstDraft.click();
		List<String> message = mail.getMessageContent(firstDraft);
		System.out.println(message);
		//WebElement test = mail.getDraftsList().get(0);
		//mail.deleteDraftByAction(test);
//		mail.logOut();
		//mail.testMethod();
//		mail.createMessage();
//		mail.inputTo("To");
//		mail.inputTheme("Theme");
//		mail.inputMessage("Message");
	}

}
