package com.atguigu.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import sun.tools.tree.ThisExpression;

public class PropertiesUtil {
	public static void main(String[] args) throws IOException {
//		Properties properties = new Properties();
//		OutputStream output = null;
//		try {
//			output = new FileOutputStream("src/main/resources/jdbc.properties");
//			properties.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
//			properties.setProperty("jdbc.url", "jdbc:mysql://192.168.102.101:3306/dsc_cfg?characterEncoding=utf8");
//			properties.setProperty("jdbc.username", "root");
//			properties.setProperty("jdbc.password", "rootroot");
//
//			// 保存键值对到文件中
////			properties.store(output, "Thinkingcao modify");
//			properties.store(output, "Maxwell");
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			System.out.println("保存配置文件");
//		}
		// 开始读取数据
		PropertiesUtil propertiesUtil = new PropertiesUtil();
//		propertiesUtil.test1();
	
	}

	public void test1() throws IOException {		
		InputStream inputStream = this.getClass().getResourceAsStream("src/main/resources/jdbc.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		properties.list(System.out);
		System.out.println("==============================================");
		String property = properties.getProperty("jdbc.url");
		System.out.println("property = " + property);
	}

}
