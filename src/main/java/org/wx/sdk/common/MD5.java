package org.wx.sdk.common;

import java.security.MessageDigest;

/**
 * MD5工具类
 * @author Rocye
 * @version 2017-03-01
 */
public class MD5 {
	/**
	 * 得到指定字串的MD5编码
	 * @param sourceString 要编码的字串
	 * @return 编码后的MD5字串
	 */
	public static String encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return resultString.toUpperCase();
	}

	/**
	 * 二进制转十六进制字符串
	 * @param bytes 二进制数据
	 * @return 十六进制串
	 */
	public static final String byte2hexString(byte bytes[]) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 16)
				buf.append("0");
			buf.append(Long.toString(bytes[i] & 0xff, 16));
		}

		return buf.toString();
	}

}
