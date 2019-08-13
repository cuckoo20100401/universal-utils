package org.cuckoo.universal.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
	
	/**
	 * 生成唯一的数字字符串
	 * @return
	 */
	public static String uniqueNumString(){
		StringBuilder sb = new StringBuilder();
		sb.append(System.currentTimeMillis());
		int r = 0;
		for(int i = 0; i < 6; i++){
			r = (int) (Math.random() * (10));
			sb.append(r);
		}
		return sb.toString();
	}

	/**
	 * 校验空值或空字符串
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str){
		return str == null || str.trim().length() == 0 ? true : false;
	}
	
	/**
	 * 计算md5值
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		StringBuilder sb = new StringBuilder(40);
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] bs = messageDigest.digest(str.getBytes());
			for(byte x:bs) {
			    if((x & 0xff)>>4 == 0) {
			        sb.append("0").append(Integer.toHexString(x & 0xff));
			    } else {
			        sb.append(Integer.toHexString(x & 0xff));
			    }
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        return sb.toString();
	}
	
	/**
	 * 编码为UTF8
	 * @param str
	 * @return
	 */
	public static String encodeByUTF8(String str){
		String result = null;
		if(str == null) return result;
		try {
			result = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 用UTF8解码
	 * @param str
	 * @return
	 */
	public static String decodeByUTF8(String str){
		String result = null;
		if(str == null) return result;
		try {
			result = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
