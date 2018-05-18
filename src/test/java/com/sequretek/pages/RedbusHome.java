package com.sequretek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.log4testng.Logger;
import com.sequretek.suitbase.SuitBase;

public class RedbusHome extends SuitBase{
	
	Logger log = Logger.getLogger(RedbusHome.class);
	
	public static By sourceLocation = new By.ByCssSelector("#src");
	public static By destinationLocation = new By.ById("dest");
	public static By onwardtable = new By.ByXPath(".//*[@id='search']/div/div[3]/div/label");
	public static By returntable = new By.ByXPath(".//*[@id='return_cal']");
	public static By onward_date = new By.ById(" ");
	public static By return_date = new By.ById(" ");
	public static By searchBus = new By.ByCssSelector("#search_btn");
	public static By busSelect= new By.ByXPath(".//*[@id='buses_viewonward']/div/div/ul/li[1]/div[1]/div/div[1]/div[3]/div[1]");
	public static By viewSeats = new By.ByXPath(".//*[@id='buses_viewonward']/div/ul/li[1]/div[1]/div/div[1]/div[7]/div[2]/button");
	public static By dropsrc = new By.ByXPath("//li[@select-id='results[0]']");
	public static By searchModifyBtn = new By.ByCssSelector(".modify");
	
	public void selectFromDay(String date) {			
		driver.findElement(By.id("onward_cal")).click();
		AbstractPage.selectFromDate(date);
	}
	
	public void selectToDay(String date) {	
		driver.findElement(RedbusHome.returntable).click();
		AbstractPage.selectToDate(String.valueOf(Integer.parseInt(date)+3));
	}
	
	public void selectSourceLocation() {
		driver.findElement(RedbusHome.sourceLocation).sendKeys("Mumbai");
		AbstractPage.waitForElementAnClick(dropsrc );
	}
   
	public void selectDestinationLocation() {
		driver.findElement(RedbusHome.destinationLocation).sendKeys("Goa");
		AbstractPage.waitForElementAnClick(dropsrc );
	}
	public void selectTravelLocation() {
		selectSourceLocation();
		selectDestinationLocation();
	}
	
	public void selectTravelDates(String date) {
		selectFromDay(date);
		//selectToDay(date);
	}
	
	public void clickOnSearchBus() {
		AbstractPage.waitForElementAnClick(searchBus);	
	}
	
	public void selectSearchedBus(String busName) {
		waitForPageLoaded();
		wait.until(ExpectedConditions.elementToBeClickable(searchModifyBtn));
		String selectBus = String.format("//*[contains(text(), '%s')]/../following-sibling::div/..//button", busName);		
		if(!driver.findElement(By.xpath(selectBus)).getText().contains("SOLD")){
			driver.findElement(By.xpath(selectBus)).click();
			waitForPageLoaded();
		}else {
			Assert.fail("Tickets for "+busName+" is sold out");
		}
	}
	public void searchAndSelectBus(String date) {
		selectTravelLocation();
		selectTravelDates(date);
		clickOnSearchBus();
		selectSearchedBus("Kadamba Trans Corp.Ltd");
	}
		
	
}
