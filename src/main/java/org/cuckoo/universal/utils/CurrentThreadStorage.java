package org.cuckoo.universal.utils;

/**
 * 当前线程存储演示类
 * 针对当前请求（线程）存储数据，适用于多个地方需要共享当前线程数据的场景
 */
public class CurrentThreadStorage {

	private final static ThreadLocal<Object> storage = new ThreadLocal<Object>();
	
	public static void setData(Object value){
		storage.set(value);
	}
	
	public static void getData(){
		storage.get();
	}
	
	public static void remove(){
		storage.remove();
	}
}
