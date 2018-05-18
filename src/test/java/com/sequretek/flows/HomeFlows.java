package com.sequretek.flows;

import com.sequretek.pages.RedbusHome;
import com.sequretek.suitbase.SuitBase;

public class HomeFlows extends SuitBase{

	private RedbusHome redbus = new RedbusHome();
	
	public void searchBus(String date) {
		redbus.searchAndSelectBus(date);
	}
}
