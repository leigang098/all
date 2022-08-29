package cn.itcast.user.utils;

public class Check {
	
	/**是否是excel*/
	public static boolean isExcel(String fileName) {
		if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
			return true;
		}
		return false;
	}

}
