package com.woniuxy.mybatis;

import java.sql.Connection;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

// 通过注解来声明拦截StatementHandler对象的prepare方法
// Connection 倒的是java.sql.Connection 包下的
@Intercepts({@Signature(type = StatementHandler.class,method ="prepare",args = {Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor{
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("Sql语句执行");
		// 获取被拦截的对象
		 StatementHandler target = (StatementHandler) invocation.getTarget();
		 // 生成元对象
		 MetaObject m = MetaObject.forObject(target,new DefaultObjectFactory(),// 
				 new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
		 // 获取元数据RowBounds 用来判断里面是否要分页
		 RowBounds rb = (RowBounds) m.getValue("delegate.rowBounds");
		 // 判断是否有rowbounds 并且不是默认的rowbounds
		if(rb != null && !rb.equals(RowBounds.DEFAULT)) {
			// 获取原有的sql语句
			String sql = (String) m.getValue("delegate.boundSql.sql");
			// 获取分页数据
			int offset = rb.getOffset();
			int limit = rb.getLimit();
			
			//===================================================
			// 获取配置
			Configuration  configuration = (Configuration) m.getValue("delegate.configuration");
			// 获取配置文件中的所有配置文件信息。并且参数为dialect的
			String type = configuration.getVariables().getProperty("dialect");
			// 判断是否为null
			Dialect d = DialectFactory.getInstance(type);
			//===================================================
			
			
			// 拼接分页数据
			String pageSql = d.getLimitString(sql, offset, limit);
			// 把拼接的字符串放到元数据中
			m.setValue("delegate.boundSql.sql", pageSql);
			// 清空mybatis的内存分页数据
			m.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			m.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		}
		// 获取封装的对象数据
		Object obj = invocation.proceed();
		//放行
		return obj;
	}

}
