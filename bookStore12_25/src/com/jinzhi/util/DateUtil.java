package com.jinzhi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 由日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String returnStr = sdf.format(date);
		return returnStr;
	}
	
	/**
	 * 由字符串转换为日期
	 * @param date
	 * @return
	 */
	public static Date convertToDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	
	/**
	 * 由日期转换为字符串
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String returnStr = sdf.format(date);
		return returnStr;
	}
	
	/**
	 * 由字符串转换为日期
	 * @param date
	 * @return
	 */
	public static Date convertToDate(String dateStr,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
