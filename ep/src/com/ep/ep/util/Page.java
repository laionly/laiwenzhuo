package com.ep.ep.util;

import java.util.List;

public class Page<T> {
	private List<T> list;
	private int pagenum;// 当前页
	private int pagesize;// 每页显示多少条
	private int prepagenum;// 上一页
	private int nextpagenum;// 下一页
	private int totalpagenum;// 总页数
	private int totalCount;// 数据总数

	public Page(int pagenum, int pagesize) {
		this.pagenum = pagenum;
		this.pagesize=pagesize;
	}

	public Page() {

	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPrepagenum() {
		return prepagenum;
	}

	public void setPrepagenum(int prepagenum) {
		this.prepagenum = prepagenum;
	}

	public int getNextpagenum() {
		return nextpagenum;
	}

	public void setNextpagenum(int nextpagenum) {
		this.nextpagenum = nextpagenum;
	}

	public int getTotalpagenum() {
		return totalpagenum;
	}

	public void setTotalpagenum(int totalpagenum) {
		this.totalpagenum = totalpagenum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if ((int) totalCount % pagesize == 0) {
			totalpagenum = (int) (totalCount / pagesize);
		} else {
			totalpagenum = (int) (totalCount / pagesize + 1);
		}
		if (pagenum > 1) {
			prepagenum = (int) (pagenum - 1);
		} else {
			prepagenum = 1;
		}
		if (pagenum < totalpagenum) {
			nextpagenum = (int) (pagenum + 1);
		} else {
			nextpagenum = totalpagenum;
		}
	}

}
