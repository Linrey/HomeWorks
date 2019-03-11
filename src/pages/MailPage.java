package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MailPage extends Page{
	public final String DRAFTS_URL = "https://mail.yahoo.com/d/folders/3";
	public final String SENDED_MESSAGES_URL = "https://mail.yahoo.com/d/folders/2";
	public MailPage(WebDriver driver) {
		this.driver = driver;
		this.URL = "https://mail.yahoo.com";
	}
	public WebDriver inputTheme(String theme) {
		driver.findElement(By.xpath("//input[@data-test-id=\"compose-subject\"]")).sendKeys(theme);
		return driver;
	}
	public String getTheme() {
		return driver.findElement(By.xpath("//input[@data-test-id=\"compose-subject\"]")).getAttribute("value");
	}
	public String getMessageTheme() {
		return driver.findElement(By.xpath("//*[@data-test-id=\"message-group-subject-text\"]")).getText();
	}
	public WebDriver inputTo(String to) {
		driver.findElement(By.cssSelector("#message-to-field")).sendKeys(to);
		return driver;
	}
	public String getTo() {
		return driver.findElement(By.xpath("//*[@data-test-id=\"email-pill\"]")).getText();
	}
	public String getMessageTo() {
		return driver.findElement(By.xpath("//*[@data-test-id=\"message-to\"]")).getText();
	}
	public WebDriver inputMessage(String message) {
		driver.findElement(By.xpath("//*[@data-test-id=\"rte\"]")).sendKeys(message);
		return driver;
	}
	public String getDraftContent() {
		return driver.findElement(By.xpath("//*[@data-test-id=\"rte\"]")).getText();
	}
	public String getMessageContent() {
		return driver.findElement(By.xpath("//*[@data-test-id=\"message-view-body-content\"]")).getText();
	}
	public int getDraftsCounter() {
		try {
			WebElement count = driver.findElement(By.xpath("//*[@data-test-id=\"displayed-count\"]"));
			int counter = Integer.parseInt(count.getText());
			return counter;
		} catch (NoSuchElementException e)  {
			return 0;
		}
	}
	public WebDriver clickOpenSpace() {
		//data-test-id="compose-header-field-to"
		return driver;
	}
	public WebDriver createMessage(String theme,String to,String message) {
		driver.findElement(By.xpath("//*[@data-test-id=\"compose-button\"]")).click();
		this.inputTo(to);
		this.inputTheme(theme);
		this.inputMessage(message);
		return driver;
	}
 	public WebDriver sendDraft(String theme,String to,String message) {
		createMessage(theme, to, message);
 		driver.findElement(By.xpath("//*[@data-test-folder-name=\"Inbox\"]")).click();
		return driver;
 	}
 	public WebDriver sendMessage(String theme,String to,String message) {
		createMessage(theme, to, message);
		driver.findElement(By.xpath("//*[@data-test-id=\"compose-send-button\"]")).click();
		return driver;
 	}
	public List<WebElement> getDraftsList() {
		List<WebElement> drafts = driver.findElements(By.xpath("//*[@data-test-id=\"message-list-item\"]"));
		return drafts;
	}
	public List<WebElement> getMessagesList() {
		List<WebElement> drafts = driver.findElements(By.xpath("//*[@data-test-id=\"message-list-item\"]"));
		return drafts;
	}
	public List<String> getDraftContent(WebElement el) {
		List<String> message = new ArrayList<String>();
		message.add(this.getTheme());
		message.add(this.getTo());
		message.add(this.getDraftContent());
		return message;
	}
	public List<String> getMessageContent(WebElement el) {
		List<String> message = new ArrayList<String>();
		message.add(this.getMessageTheme());
		message.add(this.getMessageTo());
		message.add(this.getMessageContent());
		return message;
	}
	public int getMessagesCounter() {
		try {
			WebElement count = driver.findElement(By.xpath("//a[@href=\"/d/folders/2\"]"));
			int counter = Integer.parseInt(count.getAttribute("data-test-total-count"));
			return counter;
		} catch (NoSuchElementException e)  {
			return 0;
		}
	}
	public WebDriver deleteDraftsByAction() {
		driver.get(this.DRAFTS_URL);
		Actions act = new Actions(driver);
		List<WebElement> checks = driver.findElements(By.xpath("//*[@data-test-id=\"icon-btn-checkbox-container\"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		
		for(WebElement check : checks) {
			act.moveToElement(check).click().build().perform();
		}
		WebElement deleteButton = driver.findElement(By.xpath("//*[@data-test-id=\"perm-delete\"]"));
		act.moveToElement(deleteButton).click().build().perform();
		WebElement deleteTest = driver.findElement(By.xpath("//*[@data-test-id=\"modal-content\"]//*[@data-test-id=\"primary-btn\"]"));
		act.moveToElement(deleteTest).click().build().perform();
		return driver;
	}
	public WebDriver deleteMessagesByAction() {
		driver.get(this.SENDED_MESSAGES_URL);
		Actions act = new Actions(driver);
		List<WebElement> checks = driver.findElements(By.xpath("//*[@data-test-id=\"icon-btn-checkbox-container\"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		this.sleep(150);
		js.executeScript("var elements = document.querySelectorAll('#mail-app-component li');\n" + 
				"elements[elements.length - 2].scrollIntoView(false);");
		
		for(WebElement check : checks) {
			act.moveToElement(check).click().build().perform();
		}
		WebElement deleteButton = driver.findElement(By.xpath("//*[@data-test-id=\"delete\"]"));
		act.moveToElement(deleteButton).click().build().perform();
		return driver;
	}
	
	
	public WebDriver logOut() {
		driver.findElement(By.xpath("//div[@role=\"toolbar\"]//img")).click();
		WebElement exitButton = driver.findElement(By.xpath("//a[contains(@href,'logout')]"));
		try {
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		exitButton.click();
		return driver;
	}
	public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Boolean isElementPresent(String expression) {
		return driver.findElements(By.xpath(expression)).size() > 0;
	}
}