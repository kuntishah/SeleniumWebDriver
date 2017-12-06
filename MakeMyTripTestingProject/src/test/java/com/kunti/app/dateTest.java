package com.kunti.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateTest {
	public int[] iDate = new int[3];

	public dateTest(String sdate) {
		DateFormat df = new SimpleDateFormat("MMMM dd,yyyy");
		Date startDate;
		try {
			startDate = df.parse(sdate);
			// String newDateString = df.format(startDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			int month = cal.get(Calendar.MONTH); // month is from 0 to 11
			int year = cal.get(Calendar.YEAR);
			int dat = cal.get(Calendar.DATE);
			iDate[0] = dat;
			iDate[1] = month+1;
			iDate[2] = year;

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
