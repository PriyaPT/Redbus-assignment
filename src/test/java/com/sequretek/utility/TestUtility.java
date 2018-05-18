package com.sequretek.utility;

import java.time.LocalDate;
import com.sequretek.suitbase.SuitBase;

public class TestUtility extends SuitBase {

	public static String getCurrentDate()
	{	
		LocalDate currentDate = LocalDate.now();		
        return String.valueOf(currentDate.getDayOfMonth());
	}
}
