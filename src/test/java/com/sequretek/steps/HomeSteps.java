package com.sequretek.steps;

import org.testng.annotations.Test;
import com.sequretek.flows.AbstractFlows;
import com.sequretek.utility.TestUtility;

public class HomeSteps extends  AbstractFlows{

	@Test(testName="Search buses for selected route", alwaysRun=true)
	public void searchBus() {		
		homeflow.searchBus(TestUtility.getCurrentDate());

	 }
	
}
