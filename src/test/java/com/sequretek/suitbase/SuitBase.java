package com.sequretek.suitbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class SuitBase {
	
	public static WebDriver driver =null;
	public static Actions action=null;
	public static WebDriverWait wait= null;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void suiteConfig(String browser) {
		
		
		switch(browser) {
		
		case "ff":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,20);
			action = new Actions(driver);
			driver.get("https://www.redbus.in/");
			break;
			
		case "chrome":
			System.setProperty("WebDriver.chrome.driver", "path");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.redbus.in/");
			break;
			
		  }
		 Reporter.log("Browser Launched");
	}
	
	@AfterSuite(alwaysRun=true,description="Close opened browser")
	 public void tearDown() {		 
		 driver.quit();
		 driver.manage().deleteAllCookies();
		 Reporter.log("Browser closed");
	 }
	
	public static void waitForPageLoaded() {
	    ExpectedCondition<Boolean> expectation = new
	            ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver driver) {
	                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                }
	            };
	    try {
	        Thread.sleep(1000);
	        wait.until(expectation);
	    } catch (Throwable error) {
	        Assert.fail("Timeout waiting for Page Load Request to complete.");
	    }
	}
}
