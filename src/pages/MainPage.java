package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page{
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.URL = "https://www.yahoo.com/";
	}
	public boolean isLogin(String loginString) {
		driver = this.getPage();
		//test1234mail5678
		try {
			WebElement loginEl = driver.findElement(By.xpath("//*[text()[contains(.,'" + loginString + "')]]"));
			if (loginEl != null) 
			{
				return true;
			}
		} catch (NoSuchElementException e)  {
			return false;
		}
		return false;
	}
}