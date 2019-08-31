package com.woniuxy.mybatis;

public class DialectFactory {
	public static Dialect getInstance(String type) {
		Dialect d = null;
		if("mysql".equalsIgnoreCase(type)) {
			d = new MySqlDialect();
		}
		return d;
	}
}
