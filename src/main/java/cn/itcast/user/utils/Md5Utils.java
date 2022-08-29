package cn.itcast.user.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.axis2.databinding.types.NCName;
import org.apache.axis2.util.XMLChar;

/**
 * MD5转换工具类
 *
 * @since  2018年11月6日
 * @author 陈锡伟
 *
 */
public class Md5Utils {
	
	/**
	 * 使用axis2将字符串转成md5码
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 *
	 * @变更记录 2018年11月6日 下午4:07:26 陈锡伟 创建
	 *
	 */
	public static String md5SumAxis2(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	return md5Sum(toXmlId(input).getBytes("utf-8"));
	}
	
    private static String md5Sum(final byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] digest = md.digest(input);
        return byteArrayToHexString(digest);
    }
    
    private static String toXmlId(final String name) {
        if (NCName.isValid(name)) {
            return name;
        }
        boolean bValid = true;
        final StringBuilder buf = new StringBuilder(name.length());
        for (int scan = 0; scan < name.length(); ++scan) {
            if (scan == 0) {
                bValid = XMLChar.isNCNameStart((int)name.charAt(scan));
            }
            else {
                bValid = XMLChar.isNCName((int)name.charAt(scan));
            }
            buf.append(bValid ? name.charAt(scan) : '_');
        }
        return buf.toString();
    }
	
    private static String byteArrayToHexString(final byte[] bytes) {
        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            final int highBits = (bytes[i] & 0xF0) >> 4;
            final int lowBits = bytes[i] & 0xF;
            if (highBits > 9) {
                switch (highBits) {
                    case 10: {
                        out.append("a");
                        break;
                    }
                    case 11: {
                        out.append("b");
                        break;
                    }
                    case 12: {
                        out.append("c");
                        break;
                    }
                    case 13: {
                        out.append("d");
                        break;
                    }
                    case 14: {
                        out.append("e");
                        break;
                    }
                    case 15: {
                        out.append("f");
                        break;
                    }
                }
            }
            else {
                out.append(highBits);
            }
            if (lowBits > 9) {
                switch (lowBits) {
                    case 10: {
                        out.append("a");
                        break;
                    }
                    case 11: {
                        out.append("b");
                        break;
                    }
                    case 12: {
                        out.append("c");
                        break;
                    }
                    case 13: {
                        out.append("d");
                        break;
                    }
                    case 14: {
                        out.append("e");
                        break;
                    }
                    case 15: {
                        out.append("f");
                        break;
                    }
                }
            }
            else {
                out.append(lowBits);
            }
        }
        return out.toString();
    }
}
