package org.cuckoo.universal.utils;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 解析JSON
 * readTree("json字符串")直接读取json字符串即可，返回一个json根对象；
 * path("map中的key")可以直接获取json map中的json对象；
 * get("数组索引")可以获取json数组中的元素（即json对象）；
 * asText()、asInt()等可以将json对象转化成对应类型的值；
 */
public class Main_ParseJSON {

	public static void main(String[] args) {
		
		String message = "json字符串";

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(message).path("HeWeather data service 3.0").get(0);
			
			String city = rootNode.path("basic").path("city").asText();
			String cond = rootNode.path("now").path("cond").path("txt").asText();
			Integer tmp = rootNode.path("now").path("tmp").asInt();
			String windSc = rootNode.path("now").path("wind").path("sc").asText();
			String windDir = rootNode.path("now").path("wind").path("dir").asText();
			Integer minTmp = rootNode.path("daily_forecast").get(0).path("tmp").path("min").asInt();
			Integer maxTmp = rootNode.path("daily_forecast").get(0).path("tmp").path("max").asInt();
			
			System.out.println(city+cond+tmp+windSc+windDir+minTmp+maxTmp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
