package com.cinema.authHandler.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	/**
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date(System.currentTimeMillis());
	}
	
	/**
	 * 
	 * @return
	 */
	public static Timestamp dbDateNow() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * 
	 * @param minutes
	 * @return
	 */
	public static Date addMinutesToCurrentDateTime(int minutes) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, minutes);
		return c.getTime();
	}
	
	
	
}
