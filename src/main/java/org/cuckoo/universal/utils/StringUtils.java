package org.cuckoo.universal.utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class StringUtils {
	
	private static final String aes_secret = "cuckoo20100401";
	
	public static String encryptByAES(String str) {
		return encryptByAES(str, aes_secret);
	}
	
	public static String decryptByAES(String ciphertext) {
		return decryptByAES(ciphertext, aes_secret);
	}
	
	public static String encryptByAES(String str, String secret) {
		try {
			// create key
			byte[] secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);
			byte[] secretKeyByteExts = new byte[32];
			for (int i = 0; i < secretKeyByteExts.length; i++) {
				if (i < secretKeyBytes.length) {
					secretKeyByteExts[i] = secretKeyBytes[i];
				} else {
					secretKeyByteExts[i] = ' ';
				}
			}
			Key key = new SecretKeySpec(secretKeyByteExts, "AES");
			// encrypt
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] ciphertextBytes = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
			return Base64.getEncoder().encodeToString(ciphertextBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String decryptByAES(String ciphertext, String secret) {
		try {
			// create key
			byte[] secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);
			byte[] secretKeyByteExts = new byte[32];
			for (int i = 0; i < secretKeyByteExts.length; i++) {
				if (i < secretKeyBytes.length) {
					secretKeyByteExts[i] = secretKeyBytes[i];
				} else {
					secretKeyByteExts[i] = ' ';
				}
			}
			Key key = new SecretKeySpec(secretKeyByteExts, "AES");
			// decode
			byte[] ciphertextBytes = Base64.getDecoder().decode(ciphertext.getBytes(StandardCharsets.UTF_8));
			// decrypt
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plaintextBytes = cipher.doFinal(ciphertextBytes);
			return new String(plaintextBytes, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
			System.err.println("异常信息：指定的密钥不正确，解密失败");
		}
		return null;
	}
	
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
	
}
