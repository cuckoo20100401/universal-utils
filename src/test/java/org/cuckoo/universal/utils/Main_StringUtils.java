package org.cuckoo.universal.utils;

public class Main_StringUtils {

	public static void main(String[] args) {

		test01();
		test02();
	}
	
	public static void test02() {
		
		System.out.println("-------------------->StringUtils.encryptByAES() and decryptByAES()");
		
		String content = "1234不有abd香港,,，，*趙國產為";
		String secret = "iamsecret";
		
		String ciphertext = StringUtils.encryptByAES(content, secret);
		System.out.println("加密结果1："+ciphertext);
		System.out.println("解密结果1："+StringUtils.decryptByAES(ciphertext, secret));
		
		ciphertext = StringUtils.encryptByAES(content);
		System.out.println("加密结果2："+ciphertext);
		System.out.println("解密结果2："+StringUtils.decryptByAES(ciphertext));
	}
	
	public static void test01() {
		System.out.println("-------------------->StringUtils.uniqueNumString()");
		System.out.println(StringUtils.uniqueNumString());
	}

}
