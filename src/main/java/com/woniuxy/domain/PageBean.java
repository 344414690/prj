package com.woniuxy.domain;

public class PageBean {
	private Integer offset;//从哪里开始
	private Integer limit = 10;// 取几条数据
	private Integer pageNow = 1;// 当前页
	private Integer count;// 总多少数据
	private Integer pageCount;// 总页数
	// 为了像easyUI兼容 
	private Integer page = 1;
	private Integer rows = 10;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
		this.pageNow = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
		this.limit = rows;
	}
	public Integer getOffset() {
		return (pageNow - 1)*limit;// 计算出每页从第几行开始
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getPageCount() {
		return (count + limit - 1)/limit;// 计算出总页数
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPageNow() {
		return pageNow;
	}
	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
