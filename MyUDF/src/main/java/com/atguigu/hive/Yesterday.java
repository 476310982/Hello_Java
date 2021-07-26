package com.atguigu.hive;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.hive.ql.exec.UDF;

public class Yesterday extends UDF {
	public String evaluate(String str) {
		Date tmpDate = null;
		Calendar calendar = null;
		if (str == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			tmpDate = df.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			calendar = Calendar.getInstance();
			calendar.setTime(tmpDate);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			tmpDate = calendar.getTime();
			str = df.format(tmpDate);
		}
		return str;
	}

	public static void main(String[] args) {
		Yesterday yes = new Yesterday();
		String res = yes.evaluate("20200101");
		System.out.println(res);
	}
}
