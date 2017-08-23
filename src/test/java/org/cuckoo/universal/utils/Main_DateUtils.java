package org.cuckoo.universal.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Interval;
import org.joda.time.Minutes;
import org.joda.time.Period;
import org.joda.time.Seconds;

public class Main_DateUtils {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println("------实例化DateTime的常用方式------");
		DateTime dateTime1 = new DateTime(2014, 12, 30, 16, 28, 55, 0); //自定义日期，参数依次是：year、month、day、hour(midnight is zero)、minute、second、milliseconds
		DateTime dateTime2 = new DateTime(); //当前日期
		DateTime dateTime3 = new DateTime(new Date()); //当前日期
		
		System.out.println("------输出自定义日期时间------");
		DateTime dateTime = new DateTime(2014, 12, 30, 16, 28, 55, 0);
		System.out.println(dateTime.toString("E MM/dd/yyyy HH:mm:ss.SSS"));
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss E"));
		
		System.out.println("------输出当前日期时间------");
		dateTime = new DateTime();
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTime.toString("yyyy-MM-dd"));
		
		System.out.println("------输出当前日期n天后、n月后、n年后的日期------");
		dateTime = new DateTime();
		dateTime = dateTime.plusDays(186); //dateTime.plusMonths(arg0)、dateTime.plusYears(arg0)
		System.out.println(dateTime.toString("yyyy-MM-dd"));
		
		System.out.println("------输出当前日期n天前的日期------");
		dateTime = new DateTime();
		dateTime = dateTime.minusDays(1);
		System.out.println(dateTime.toString("yyyy-MM-dd"));
		
		System.out.println("------输出当前时间戳------");
		long t = DateTimeUtils.currentTimeMillis();
		System.out.println(t);
		
		System.out.println("------Joda 和 JDK 互操作性------");
		Date jdkDate = dateTime.toDate(); //from Joda to JDK
		dateTime = new DateTime(jdkDate); //from JDK to Joda
		Calendar jdkCalendar = dateTime.toCalendar(Locale.CHINESE); //from Joda to JDK
		dateTime = new DateTime(jdkCalendar); //from JDK to Joda
		
		System.out.println("------计算时间间隔------");
		Date jdkDate1 = new DateTime(2015, 8, 20, 0, 0, 0, 0).toDate();
		Date jdkDate2 = new Date();
		DateTime dt1 = new DateTime(jdkDate1);
		DateTime dt2 = new DateTime(jdkDate2);
		System.out.println("相差总天数："+Days.daysBetween(dt1, dt2).getDays());
		System.out.println("相差总小时："+Hours.hoursBetween(dt1, dt2).getHours());
		System.out.println("相差总分钟："+Minutes.minutesBetween(dt1, dt2).getMinutes());
		System.out.println("相差总秒数："+Seconds.secondsBetween(dt1, dt2).getSeconds());
		
		System.out.println("------倒计时------");
		Date jdkFutureDate = new DateTime(2017, 9, 3, 17, 30, 0, 0).toDate();
		Interval interval = new Interval(new Date().getTime(), jdkFutureDate.getTime()); //第二个参数必须大于第一个参数
		Period period = interval.toPeriod();
		System.out.println("距离结束还有："+period.getYears()+"年"+period.getDays()+"天"+period.getHours()+"小时"+period.getMinutes()+"分钟"+period.getSeconds()+"秒");
		
		System.out.println("------与周有关------");
		dateTime = new DateTime(2016, 1, 3, 0, 0, 0, 0);
		//dateTime = new DateTime();
		System.out.println(dateTime.getYear()); //哪一年
		System.out.println(dateTime.getDayOfWeek()); //本周第几天
		System.out.println(dateTime.getDayOfYear()); //本年第几天
		System.out.println(dateTime.getMonthOfYear()); //本年第几月
		System.out.println(dateTime.getWeekOfWeekyear()); //本年第几周
		System.out.println(dateTime.dayOfWeek().get()); //当周的第几天
		System.out.println(dateTime.dayOfWeek().withMinimumValue().toString("yyyy-MM-dd")); //当周的第一天日期
		System.out.println(dateTime.dayOfWeek().withMaximumValue().toString("yyyy-MM-dd")); //当周的最后一天日期
		
		System.out.println("------与月有关------");
		//dateTime = new DateTime();
		dateTime = new DateTime(2015, 10, 13, 0, 0, 0, 0);
		System.out.println(dateTime.getMonthOfYear()); //本年第几月
		System.out.println(dateTime.dayOfMonth().withMinimumValue().toString("yyyy-MM-dd")); //当月的第一天日期
		System.out.println(dateTime.dayOfMonth().withMaximumValue().toString("yyyy-MM-dd")); //当月的最后一天日期
		
		System.out.println("------特殊用途（比如生成目录名称）------");
		dateTime = new DateTime();
		String yymmdd = dateTime.toString("yyyyMMdd");
		String hhmmss = dateTime.toString("HHmmss");
		String hh = dateTime.toString("HH");
		String mm = dateTime.toString("mm");
		System.out.println("yymmdd: "+yymmdd);
		System.out.println("hhmmss: "+hhmmss);
		System.out.println("hh: "+hh);
		System.out.println("mm: "+mm);
	}
}
