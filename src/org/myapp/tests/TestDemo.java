package org.myapp.tests;

import org.testng.Assert;
import org.myapp.page.ComfirmMessage;
import org.myapp.page.ContactPage;
import org.myapp.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDemo{

	WebDriver driver;
	HomePage homePage;
	ContactPage contactPage;
	ComfirmMessage comfirmMessage;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);
		comfirmMessage = new ComfirmMessage(driver);
	}
	
	@Test
	public void testSomething() throws InterruptedException{
		homePage.navigatetoWebApp();
		homePage.navigateToContactPage();
		
		contactPage.enterName("tesssss");
		contactPage.enterAddress("19 Tan Canh");
		contactPage.enterPostcode("95999955");
		contactPage.enterEmail("vuthelinh@gmail.com");
		contactPage.submits();
		
		Assert.assertEquals(comfirmMessage.getComfirmMessage(), "Many thanks for your message. We will contact you about your query as soon as possible. In the mean time why not have a look at our list of animals we have available for adoption in the adoption page.");
	}
	
	@AfterMethod
	public void end(){
		homePage.closeApp();
	}
	
}
