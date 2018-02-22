package org.cuckoo.universal.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数学工具
 */
public class MathUtils {

	/**
	 * 转化为价格
	 * @param value
	 * @return
	 */
	public static BigDecimal toPrice(Object value){
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String valueStr = decimalFormat.format(value);
		return new BigDecimal(valueStr);
	}
}
