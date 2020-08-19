package com.qa.darksky.page;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darksky.util.ElementUtil;



public class HomePage {

	WebDriver driver;
	ElementUtil elementUtil;
	
	By SerchBut = By.className("searchButton");
	
    By today = By.xpath("//span[contains(text(),'Today')]");
    
    public HomePage(WebDriver driver){
    	this.driver =driver;
    	elementUtil =new ElementUtil(driver); 
    	
}
    public String getPageTitle(){
    	return elementUtil.doGetPageTitle();   
}
    
   public  void  clickonFindMyCity() {
	 
	// elementUtil.doSendKeys(SerchBut, "Hackensack");
	 elementUtil.doSendKeys(SerchBut,"Dark Sky - Hackensack Street, East Rutherford, NJ" );
	 elementUtil.doClick(today);
   }
   public void findtemp() {
	   String actualTemp = driver.findElement(By.cssSelector(".summary.swap")).getText();
		 System.out.println("Actual Temp:" + actualTemp);
List<WebElement> tempsInTimeLine = driver.findElements(By.cssSelector(".temps span:last-child"));
	int temp = Integer.parseInt(actualTemp.substring(0, 2));
	int highestInTimeLine = temp;
	int lowestInTimeLine = temp;
	for (WebElement tempInTime: tempsInTimeLine) {
	  String sLIneTemp = tempInTime.getText();
	  int lineTemp = Integer.parseInt(sLIneTemp.substring(0, 2));
	  if (lineTemp > highestInTimeLine){
	    highestInTimeLine = lineTemp;
	  }
	  if (lineTemp < lowestInTimeLine ){
	    lowestInTimeLine = lineTemp;
	  }
	}
	
	System.out.println("Highest Temp:" + Integer.toString(highestInTimeLine));
	System.out.println("Lowest Temp:" + Integer.toString(lowestInTimeLine ));
   }
	public void tempDisplayed() {
		
		 WebElement temp = driver.findElement(By.cssSelector(".summary.swap"));
		if ( temp.isDisplayed()) {
			System.out.println("Temp is displayed correctly....");
		}else {
			System.out.println("Temp is not displayed correctly....");
		}
	
   }
}