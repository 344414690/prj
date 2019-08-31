package com.woniuxy.mybatis;

public class MySqlDialect implements Dialect {
	@Override
	public String getLimitString(String sql, int offset, int limit) {
		String pageSql = sql + " limit " + offset +"," +limit;
		return pageSql;
	}

}
