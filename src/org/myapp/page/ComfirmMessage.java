package org.myapp.page;

import org.openqa.selenium.WebDriver;

public class ComfirmMessage extends AbstractPage {
	
	public ComfirmMessage(WebDriver driver) {
		super(driver);
	}
	
	public String getComfirmMessage(){
		return getText("css=p");
		
	}
	
}
