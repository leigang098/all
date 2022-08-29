package cn.itcast.user.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Object数值转换   @authorxjh*/
public class ObjectConvert {
	
	
	/**objectToFloat    @author xjh**/
	public static Float objectToFloat(Object v) throws LabelException {
		Float f = 0.0f;
		try {
			f=Float.parseFloat(v.toString());
			
		} catch (Exception e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, v + "不是合法的Float类型");
		}
		
		return f;
		
	}
	
	
	/**objectToDouble   @author xjh*/
	public static Double objectToDouble(Object v) throws LabelException {
		Double d = 0.0;
		try {
			d = Double.valueOf(v.toString());
			
		} catch (Exception e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, v + "不是合法的Double类型");
		}
		
		return d;
	}
	
	public static String objectToString(Object val) {
		return val.toString();
	}
	
	
	/**objectToInt   @author xjh*/
	public static Integer objectToInt(Object val) throws LabelException {
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(String.valueOf(val));
			
		} catch (Exception e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, val + "不是合法的数字");
		}
		
		return parseInt;
	}
	
	/**objectToLong  @author xjh*/
	public static Long objectToLong(Object val) throws LabelException {
		long parseLong = 0;
		try {
			parseLong = Long.valueOf(String.valueOf(val)).longValue();
		} catch (Exception e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, val + "不是合法的Long类型数据");
		}
		return parseLong;
	}
	
	/**objectToDate  @author xjh*/
	public static Date objectToDate(Object val) throws LabelException {
		DateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		
		Object time = val.toString();
		Date parse = null;
		
		try {
			if (time.toString().length()==10) {
				parse = formatDate.parse(time.toString());
			}else {
				parse = formatTime.parse(time.toString());
			}
		} catch (ParseException e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, val + "时间类型有误");
		}
		
		return parse;
	}
	
	/**objectDateToLong  @author xjh*/
	public static Long objectDateToLong(Object val) throws LabelException {
		DateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		
		Object time = val.toString();
		Date parse = null;
		
		try {
			if (time.toString().length()==10) {
				parse = formatDate.parse(time.toString());
			}else {
				parse = formatTime.parse(time.toString());
			}
		} catch (ParseException e) {
			throw new LabelException(ConstUtil.RESPONSE._LOGICERROR.ID, val + "时间类型有误");
		}
		
		return parse.getTime();
	}

}
