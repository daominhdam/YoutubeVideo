package org.webdriver.action;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverAction {

	public Logger APP_LOGS = Logger.getLogger("devpinoyLogger");

	WebDriver driver = null;

	public WebDriverAction(WebDriver driver) {
		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.Jdk14Logger");
		this.driver = driver;
	}

	private By getBy(String locator) {

		By by = null;

		if (locator.startsWith("id=")) {

			locator = locator.substring(3);
			by = By.id(locator);

		} else if (locator.startsWith("name=")) {

			locator = locator.substring(5);
			by = By.name(locator);

		} else if (locator.startsWith("css=")) {

			locator = locator.substring(4);
			by = By.cssSelector(locator);

		} else if (locator.startsWith("link=")) {

			locator = locator.substring(5);
			by = By.linkText(locator);

		} else if (locator.startsWith("xpath=")) {
			locator = locator.substring(6);
			by = By.xpath(locator);
		} else {
			APP_LOGS.debug("[info] Executing: | [>> ERROR <<] Format locators are supported by:\n * id\n * name\n * css\n * link\n * xpath\n |");
		}

		return by;
	}

	public WebElement getWebElement(String locator) {
		return driver.findElement(getBy(locator));
	}

	public void click(String locator) {
		try{
			APP_LOGS.debug("[info] Executing: |click | " + locator + " |");
			WebElement element = getWebElement(locator);
			element.click();
		}catch(NoSuchElementException e){ 
			APP_LOGS.debug("[info] Executing: | [>> ERROR <<] " + locator	+ " not found to click| " + e.getMessage());
		}
	}

	public void sendKeys(String locator, String value) {
		try{
			APP_LOGS.debug("[info] Executing: |sendKeys | " + locator + " | " + value + " |");
			WebElement element = getWebElement(locator);
			element.sendKeys(value);
		}catch(NoSuchElementException e){ 
			APP_LOGS.debug("[info] Executing: | [>> ERROR <<] " + locator	+ " not found to sendKeys| " + e.getMessage());
		}
	}

	public String getText(String locator) {
		String result="";
		try{
			APP_LOGS.debug("[info] Executing: |getText | " + locator + " |");
			WebElement element = getWebElement(locator);
			result = element.getText();
		}catch(NoSuchElementException e){ 
			APP_LOGS.debug("[info] Executing: | [>> ERROR <<] " + locator	+ " not found to getText| " + e.getMessage());
		}	
		return result;
	}

	public void close() {
		APP_LOGS.debug("[info] Executing: |close |");
		driver.quit();
	}

	public void open(String url) {
		APP_LOGS.debug("[info] Executing: |open |" + url + " application|");
		driver.get(url);
	}

}
