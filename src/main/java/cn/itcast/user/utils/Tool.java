package cn.itcast.user.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
	
	public final static String YYYYMMDD = "yyyy-MM-dd";
	public final static String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	
	/**时间转String*/
	public static String DateToString(Date date ,String format) {
		
		if (date == null) {
			date = new Date();
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String d = sdf.format(new Date());
		
		return d;
	}

}
