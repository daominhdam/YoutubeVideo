package org.myapp.page;

import org.openqa.selenium.WebDriver;

public class ContactPage extends AbstractPage{
	
		
	public ContactPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterName(String value){
		sendKeys("name=name_field", value);
	}
	
	public void checkInformation(boolean value ){
		// code
	}
	
	public void enterAddress(String value){
		sendKeys("name=address_field", value);
	}
	
	public void enterPostcode(String value){
		sendKeys("name=postcode_field", value);
	}
	
	public void enterEmail(String value){
		sendKeys("name=email_field", value);
	}
	
	public ComfirmMessage submits(){
		click("id=submit_message");
		return new ComfirmMessage(driver);
	}
	
	public HomePage navigateToHomePage(){
		navigatetoWebApp();
		return new HomePage(driver);
	}
	
}
