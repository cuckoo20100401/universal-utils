package org.cuckoo.universal.utils;

public class Main_IPUtils {

	public static void main(String[] args) {

		System.out.println("IP到Long: "+IPUtils.toLongIP("127.0.0.1"));
		System.out.println("Long到IP: "+IPUtils.toStringIP(2130706433L));
	}

}
