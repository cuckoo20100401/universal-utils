package org.cuckoo.universal.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.cuckoo.universal.utils.StringUtils;

/**
 * WebService安全工具类
 */
public class SecurityUtils {
	
	private static final Log log = LogFactory.getLog(SecurityUtils.class);
	
	private static final String WEB_SERVICE_SECRET = "1234";
	
	/**
	 * 校验合法性（必须是在60秒以内的请求并且secret是正确的）
	 * @param time
	 * @param secret
	 * @return true：通过；false：未通过
	 */
	public static boolean verify(Long time, String secret){
		try {
			//parameters
			if(time == null){
				log.info("Time be null");
				return false;
			}
			if(secret == null || secret.trim().equals("")){
				log.info("Secret be null or zero length");
				return false;
			}
			//time
			long timeInterval = DateUtils.curUnixTimestamp() - time;
			if(timeInterval < 0 || timeInterval > 60){
				log.info("Time is of the timeout");
				return false;
			}
			//secret
			String serverSecret = createSecret(time);
			if(!secret.equals(serverSecret)){
				log.info("Secret is not correct");
				return false;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 生成secret
	 * md5(time+web_service_secret)
	 * @param time
	 */
	public static String createSecret(long time){
		return StringUtils.md5(time + WEB_SERVICE_SECRET);
	}
}
