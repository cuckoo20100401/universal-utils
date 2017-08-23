package org.cuckoo.universal.utils;

import java.util.regex.Pattern;

/**
 * 校验工具类
 */
public class ValidateUtils {
	
	/**
     * 校验手机号
     * @param value
     * @return true：合法；false：不合法
     */
    public static boolean isMobile(String value) {
        return Pattern.matches("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$", value);
    }
}