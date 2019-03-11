package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverFactory;
import drivers.browsers;
import pages.LoginPage;
import pages.MailPage;
import utilities.Message;
import utilities.dp;

public class MailTest {
	private WebDriver driver;
	private MailPage mailPage;
	private LoginPage loginPage;
	

	@Parameters({ "log", "pswd"})
	@BeforeClass
	public void beforeTest(String log, String pswd) {
		driver = DriverFactory.getInstance(browsers.CHROME);
		mailPage = new MailPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login(log, pswd);
	}
	@Test( description = "Mail creation test", groups = "mailTest", dataProvider = "dp" , dataProviderClass = dp.class,
			dependsOnGroups = "draftTest")
	public void testMailCreation(Message m) {
		mailPage.getPage();
		int startCounter = mailPage.getMessagesCounter();
		mailPage.sendMessage(m.getTheme(), m.getTo(), m.getContent());
		try { 
			Thread.sleep(1000);
			driver.navigate().refresh();
			Thread.sleep(1000);
	    } catch (Exception ex) { 
	        ex.printStackTrace();
	    }
		int finishCounter = mailPage.getMessagesCounter();
		assertEquals(startCounter, finishCounter - 1);
	}
	@Test( description = "Mail content test", groups = "mailTest", dataProvider = "dpReverse" , dataProviderClass = dp.class,
			dependsOnGroups = "draftTest", dependsOnMethods = "testMailCreation")
	public void testMailContent(Message m) {
		driver.get(mailPage.SENDED_MESSAGES_URL);
		WebElement firstDraft = mailPage.getDraftsList().get(m.getCounter());
		firstDraft.click();
		List<String> message = mailPage.getMessageContent(firstDraft);
		Assert.assertEquals(message.get(0), m.getTheme());
		Assert.assertEquals(message.get(1), m.getTo());
		Assert.assertEquals(message.get(2), m.getContent());
	}
	
	@AfterClass
	public void afterTest() {
		mailPage.deleteMessagesByAction();
		mailPage.getPage();
		mailPage.logOut();
		DriverFactory.tearDown();
	}
}
