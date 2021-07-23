package com.atguigu.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;

public class LastTrdDay extends UDF {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.102.101:3306/dsc_cfg";
	static final String USER = "root";
	static final String PASS = "rootroot";

	public Date tmpDate = null;
	public Calendar calendar = null;

	public String evaluate(String str, int interval) {
		if (str == null) {
			return null;
		}

		DateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
		calendar = Calendar.getInstance();
		Connection conn = null;
		Statement stmt = null;

		try {
			calendar.setTime(dFormat.parse(str));
			calendar.add(Calendar.DAY_OF_MONTH, interval);
			str = dFormat.format(calendar.getTime());

			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
//			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
//			System.out.println("实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "select jyr from t_xtjyr where ZRR = " + str;
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				str = rs.getString("JYR");
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				String url = rs.getString("url");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return str;
	}

//	public static void main(String[] args) {
//		LastTrdDay lastTrdDay = new LastTrdDay();
//		String string = lastTrdDay.evaluate("20210721", -30);
//		System.out.println(string);
//	}
}
