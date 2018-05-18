package com.sequretek.redbus.redbusweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testredbus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='onward_cal']")).click();
		driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr/following::td[text()='20']")).click();
		
		
	}

}
