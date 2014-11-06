package org.myapp.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ContactPage navigateToContactPage() {
		click("id=contact_link");
		return new ContactPage(driver);
	}
	
	public void closeApp(){
		close();
	}

}
