package com.team3.LMS;

import static org.junit.Assert.*;

import org.junit.Test;

import com.team3.LMS.controller.TicketController;

import junit.framework.Assert;

public class TestExample {

	@Test
	public void testGetLimitTime() {
		TicketController t = new TicketController();
		int expectedValue = 50;
		//int actualValue = t.getLimitTimeByBook("HHHHHH");
		int actualValue = 30;
		//Assert.assertEquals(expectedValue, actualValue);
		
		assertEquals(expectedValue, actualValue);
		
	}

}
