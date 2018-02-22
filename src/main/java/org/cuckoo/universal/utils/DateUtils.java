package org.cuckoo.universal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {
	
	/**
	 * 获取当前的 UNIX TIMESTAMP
	 * @return
	 */
	public static long curUnixTimestamp(){
		return System.currentTimeMillis()/1000;
	}
	
	/**
	 * 当前的日期字符串
	 * @return
	 */
	public static String curDateStr(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 当前的日期时间字符串
	 * @return
	 */
	public static String curDatetimeStr(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 日期字符串 转 Date对象
	 * @param source 日期字符串
	 * @param pattern 模板，示例："yyyy-MM-dd HH:mm:ss"；注意：为什么有的格式大写，有的格式小写，那是怕避免混淆，例如MM是月份，mm是分；HH是24小时制，而hh是12小时制。
	 * @return
	 */
	public static Date strToDate(String source, String pattern){
		Date date = null;
		try {
			date = new SimpleDateFormat(pattern).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Date对象 转 日期字符串
	 * @param date Date对象
	 * @param pattern 模板，示例："yyyy-MM-dd HH:mm:ss"；注意：为什么有的格式大写，有的格式小写，那是怕避免混淆，例如MM是月份，mm是分；HH是24小时制，而hh是12小时制。
	 * @return
	 */
	public static String dateToStr(Date date, String pattern){
		String dateStr = null;
		try {
			dateStr = new SimpleDateFormat(pattern).format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}
}
