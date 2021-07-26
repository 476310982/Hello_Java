package com.atguigu.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtil {
	private String url;
	private String driver;
	private String username;
	private String password;
	private Properties properties;
	private String filename;

	public PropertiesUtil() {
		try {
			this.filename = "jdbc.properties";
			InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(this.filename);
			this.properties = new Properties();
			this.properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("配置文件不存在!");
		}
	}

	public PropertiesUtil(String FileName) {
		try {
			this.filename = FileName;
			InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(this.filename);
			this.properties = new Properties();
			this.properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("配置文件不存在!");
		}
	}

//	public static void main(String[] args) throws IOException {
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
//	}

	public String getUrl() {
		return this.properties.getProperty("jdbc.url");
	}

	public String getDriver() {
		return this.properties.getProperty("jdbc.driver");
	}

	public String getUsername() {
		return this.properties.getProperty("jdbc.username");
	}

	public String getPassword() {
		return this.properties.getProperty("jdbc.password");
	}

	public void storeProperties(String FileName, HashMap<String, String> kv) {
		OutputStream output = null;
		try {
			output = new FileOutputStream("src/main/resources/" + FileName);
			for (String key : kv.keySet()) {
				this.properties.setProperty(key, kv.get(key));
			}

			// 保存键值对到文件中
			properties.store(output, "Maxwell");
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("保存配置文件");
		}
	}

	/* 测试键值对参数读取 */
//	public static void main(String[] args) {
//		PropertiesUtil propertiesUtil = new PropertiesUtil("test.properties");
//		HashMap hashMap = new HashMap<String, String>();
//		hashMap.put("username", "Maxwell");
//		hashMap.put("password", "rootroot");
//		// System.out.println(hashMap);
//		propertiesUtil.storeProperties("test.properties", hashMap);
//		System.out.println(propertiesUtil.getDriver());
//		System.out.println(propertiesUtil.getUsername());
//	}

}