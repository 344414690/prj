package com.woniuxy.mybatis;

// 
public interface Dialect {
	public String getLimitString(String sql,int offset,int limit);
	
}
