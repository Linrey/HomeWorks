package tests;

import org.testng.annotations.Test;

import drivers.DriverFactory;
import drivers.browsers;
import pages.LoginPage;
import pages.MailPage;
import utilities.Message;
import utilities.dp;

import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DraftTest {
	private WebDriver driver;
	private MailPage mailPage;
	private LoginPage loginPage;
	

	@Parameters({ "log", "pswd"})
	@BeforeClass
	public void beforeTest(String log,String pswd) {
		driver = DriverFactory.getInstance(browsers.CHROME);
		mailPage = new MailPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.login(log,pswd);
	}
	@Test(description = "Draft creation test", groups = "draftTest", dataProvider = "dp" , dataProviderClass = dp.class,
			dependsOnGroups = "loginTest")
	public void testDraftCreation(Message m) {
		System.out.println(m.getTheme() + " " + m.getContent() + " " + m.getTo() + " " + m.getCounter());
		mailPage.getPage(); 
		int startCounter = mailPage.getDraftsCounter();
		mailPage.sendDraft(m.getTheme(), m.getTo(), m.getContent());
		//mailPage.sendDraft("Test Theme", "Berestnev4@mail.ru", "TestMessage");
		// Code for waiting update in drafts counter
//		while(true) {
//			driver.navigate().refresh();
//			try { 
//				Alert alert = driver.switchTo().alert();
//				alert.dismiss();
//				Thread.sleep(2000);
//		    } catch (NoAlertPresentException alertEx) { 
//		        break;
//		    } catch (InterruptedException threadEx) {
//		    	threadEx.printStackTrace();
//			}
//		}
		try { 
			Thread.sleep(2000);
	    } catch (Exception ex) { 
	        ex.printStackTrace();
	    }
		int finishCounter = mailPage.getDraftsCounter();
		assertEquals(startCounter, finishCounter - 1);
	}
	@Test(description = "Draft content test", groups = "draftTest", dataProvider = "dpReverse" , dataProviderClass = dp.class,
			dependsOnGroups = "loginTest", dependsOnMethods = "testDraftCreation")
	public void testDraftContent(Message m) {
		driver.get(mailPage.DRAFTS_URL);
		WebElement firstDraft = mailPage.getDraftsList().get(m.getCounter());
		firstDraft.click();
		List<String> message = mailPage.getDraftContent(firstDraft);
		Assert.assertEquals(message.get(0), m.getTheme());
		Assert.assertEquals(message.get(1), m.getTo());
		Assert.assertEquals(message.get(2), m.getContent());
	}
	@AfterClass
	public void afterTest() {
		mailPage.deleteDraftsByAction();
		mailPage.getPage();
		mailPage.logOut();
		DriverFactory.tearDown();
	}
}
