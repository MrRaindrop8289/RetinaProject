package com.gamer.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Transform;
/**
 * 日期转化为中文格式
 * @author Raindrop
 *
 */
public class DateFormat {
	public static String Transform(Date date) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (date == null) {
			date = new Date();
		}
		String[] strs = sdf.format(date).split("-");
		if (strs[1].charAt(0) == '0') {
			strs[1] = strs[1].substring(1, 2);
		}
		result += MouDayNumToChinese(strs[1]) + "月 ";
		if (strs[2].charAt(0) == '0') {
			strs[2] = strs[2].substring(1, 2);
		}
		result += MouDayNumToChinese(strs[2]) + "日  ";
		
		result += YearNumToChinese(strs[0]) + "年";
		return result;
		
	}
	
	public static String YearNumToChinese(String date) {
		String result = "";
		char[] chars = date.toCharArray();
		for (char c:chars) {
			switch(c) {
			case '0':
				result += "零";
				break;
			case '1':
				result += "一";
				break;
			case '2':
				result += "二";
				break;
			case '3':
				result += "三";
				break;
			case '4':
				result += "四";
				break;
			case '5':
				result += "五";
				break;
			case '6':
				result += "六";
				break;
			case '7':
				result += "七";
				break;
			case '8':
				result += "八";
				break;
			case '9':
				result += "九";
				break;
			}
		}
		return result;
	}
	public static String MouDayNumToChinese(String date) {
		String result = "";
		int length = date.length();
		if(date.charAt(0) == '1') {
			if(length == 2) {
				result += "十";
				switch(date.charAt(1)) {
				case '1':
					result += "一";
					break;
				case '2':
					result += "二";
					break;
				case '3':
					result += "三";
					break;
				case '4':
					result += "四";
					break;
				case '5':
					result += "五";
					break;
				case '6':
					result += "六";
					break;
				case '7':
					result += "七";
					break;
				case '8':
					result += "八";
					break;
				case '9':
					result += "九";
					break;
				}
				return result;
			}
			
		}
		for (int i = 0;i<length;i++) {
			switch(date.charAt(i)) {
			case '0':
				result += "零";
				break;
			case '1':
				result += "一";
				break;
			case '2':
				result += "二";
				break;
			case '3':
				result += "三";
				break;
			case '4':
				result += "四";
				break;
			case '5':
				result += "五";
				break;
			case '6':
				result += "六";
				break;
			case '7':
				result += "七";
				break;
			case '8':
				result += "八";
				break;
			case '9':
				result += "九";
				break;
			}
		}
		if(length == 2) {
			if (date.charAt(1) == '0') {
				result.replace("零", "十");
			}else {
				result = result.substring(0, 1) + "十" + result.substring(1, 2);
			}
		}
		return result;
	}
}
