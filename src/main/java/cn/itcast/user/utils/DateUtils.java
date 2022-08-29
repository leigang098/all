package cn.itcast.user.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期时间工具类
 *
 * @since  2018年11月2日
 * @author 陈锡伟
 *
 */
public class DateUtils {

	private final static String DATE_PATTERN = "yyyyMMddHHmmss";
	
	/**
	 * 返回指定时间格式的时间
	 * 
	 * @param time 时间长整形格式
	 * @param pattern 时间格式
	 * @return
	 *
	 * @变更记录 2018年11月2日 下午2:02:23 陈锡伟 创建
	 *
	 */
	public static String getStringDateByLongTime(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String format = sdf.format(new Date(time));
		System.err.println(format);
		return format;
	}
	
	/**
	 * 日期返回指定格式字符串
	 * 
	 * @return
	 *
	 * @变更记录 2018年11月12日 下午8:24:47 陈锡伟 创建
	 *
	 */
	public static String getStringDateByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(date);
	}
	
	/**
	 * 根据字符串时间格式转成时间戳
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 * @throws ParseException
	 *
	 * @变更记录 2018年11月23日 下午3:44:41 陈锡伟 创建
	 *
	 */
	public static Long getLongTimeByStringDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Date d = sdf.parse(date);
		return d.getTime();
	}
	
	/**
	 * 字符串时间转日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date transToDate(String dateStr) throws ParseException {
		if(dateStr.matches("\\d{1,4}\\-\\d{1,2}\\-\\d{1,2}\\s\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{1,4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{1,4}\\-\\d{1,2}\\-\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{1,4}\\-\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{1,4}/\\d{1,2}/\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{1,4}/\\d{1,2}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{8}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{14}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMddHHmmss" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{4}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy" );
			return sdf.parse(dateStr);
		}else if(dateStr.matches("\\d{6}")){
			SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMM" );
			return sdf.parse(dateStr);
		}else{
			//除了以上两种日期格式,其余的就舍弃了
			return null;
		}
	}
	
	/**
	 * 获取指定几天前的日期
	 *
	 * @param warningDays
	 * @return
	 * 
	 * @变更记录: Jan 4, 2019 5:18:20 PM 陈锡伟 创建
	 * 
	 */
	public static String getSpecifyDaysDate(int warningDays) {
		Calendar now = Calendar.getInstance();
		Long oneDay = 86400000L * warningDays;
		Long day = now.getTimeInMillis();
		
		day = day - oneDay;
		Date date = new Date(day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(date);
	}
}
