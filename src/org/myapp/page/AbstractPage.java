package org.myapp.page;

import org.openqa.selenium.WebDriver;
import org.webdriver.action.WebDriverAction;

public class AbstractPage extends WebDriverAction {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		super(driver);
	}

	public HomePage navigatetoWebApp() {
		open("http://www.thetestroom.com/webapp/index.html");
		return new HomePage(driver);
	}

}
