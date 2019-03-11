package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import drivers.DriverFactory;
import drivers.browsers;
import pages.LoginPage;
import pages.MailPage;
import pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
	private WebDriver driver;
	@BeforeClass
	public void beforeTest() {
		driver = DriverFactory.getInstance(browsers.CHROME);
	}
	@Parameters({ "log", "pswd"})
	@Test(description = "Login test", groups = "loginTest")
	public void loginTest(String log,String pswd) {
	  LoginPage lp = new LoginPage(driver);
	  //driver = lp.login("test1234mail5678","zaq1xsw2cde3vfr4");
	  driver = lp.login(log,pswd);
	  MainPage mp = new MainPage(driver);
	  Assert.assertTrue(mp.isLogin(log));
	}
	@Parameters({ "log"})
	@Test(description = "Logout test", groups = "loginTest",dependsOnMethods = "loginTest")
	public void logoutTest(String log) {
	  MailPage mail = new MailPage(driver);
	  mail.getPage();
	  mail.logOut();
	  MainPage mp = new MainPage(driver);
	  Assert.assertFalse(mp.isLogin(log));
	}
	@AfterClass
	public void afterTest() {
		DriverFactory.tearDown();
	}
	
}
