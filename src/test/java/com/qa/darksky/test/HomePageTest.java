package com.qa.darksky.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.page.HomePage;
import com.qa.darksky.util.ElementUtil;



public class HomePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	ElementUtil elementUtil;
			
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName= prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage=new HomePage(driver);
		
}
	@Test(priority = 1)
	public void verifyPageTitleTest() throws InterruptedException{
	Thread.sleep(5000);
	String title = homePage.getPageTitle();
	System.out.println("home page title is "+ title);
	Assert.assertEquals(title, "Dark Sky - Broadway, New York, NY");

	}
	
	@Test(priority=2)
	public void verifyFindMyCityTest() {
	homePage.clickonFindMyCity();
}
@Test(priority =3)

public void verifyTemprTest() {	
	homePage.findtemp();
}


@Test(priority =4)
public void verifydisplayed() {
	homePage.tempDisplayed();
}

	@AfterTest
	public void tearDown(){
		driver.quit();
	}	
		
		
}