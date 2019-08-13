package org.cuckoo.universal.utils;

import java.io.IOException;

import org.cuckoo.universal.utils.FileUtils;
import org.cuckoo.universal.utils.FileUtils.ReadCallback;

public class Main_FileUtils {
	
	public static void main(String[] args) {
		
		String filePath = "/home/cuckoo/Documents/Retention.py";
		
		// 写内容到文件
		try {
			FileUtils.write(filePath, "GBK", true, "\r\n我是内容1\r\n中国人民");
			FileUtils.write(filePath, "GBK", true, "\r\n我是内容2\r\n中国人民");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 读取文件内容方法1
		try {
			FileUtils.read(filePath, "GBK", new ReadCallback() {
				public void readLine(String lineStr) {
					System.out.println(lineStr);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 读取文件内容方法2
		String fileContent = null;
		try {
			fileContent = FileUtils.read(filePath, "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(fileContent);
	}
}
