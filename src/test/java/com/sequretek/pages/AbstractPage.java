package com.sequretek.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.log4testng.Logger;
import com.sequretek.suitbase.SuitBase;


public class AbstractPage  extends SuitBase{
	
	public static void selectFromDate(String date) {
		String dateT = String.format("//div[@id='rb-calendar_onward_cal']/table/tbody/tr/following::td[text()='%s']", date);
		List<WebElement> dates = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']//td"));
		for(WebElement ele : dates) {
			if(ele.getText().contains(date)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateT))).click();
			}
		}
	}
		public static void selectToDate(String date) {
			String dateT = String.format("//div[@id='rb-calendar_return_cal']/table/tbody/tr/following::td[text()='%s']", date);
			List<WebElement> dates = driver.findElements(By.xpath(".//*[@id='rb-calendar_onward_cal']//td"));
			System.out.println(dateT);
			for(WebElement ele : dates) {
				if(ele.getText().contains(date)) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dateT))).click();
			}
		}	
	}
}
