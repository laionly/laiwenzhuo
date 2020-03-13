package com.naive.entity;

public class SysTool {
	private String systime;//获取时间
	private String getip;//获取ip
	private String getsystemname;//获取系统环境
	private String getsystemversion;//获取系统版本
	private String getsystemarchitecture;//获取系统架构
	
	public SysTool() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SysTool(String systime, String getip, String getsystemname, String getsystemversion,
			String getsystemarchitecture) {
		super();
		this.systime = systime;
		this.getip = getip;
		this.getsystemname = getsystemname;
		this.getsystemversion = getsystemversion;
		this.getsystemarchitecture = getsystemarchitecture;
	}

	public String getSystime() {
		return systime;
	}
	public void setSystime(String systime) {
		this.systime = systime;
	}
	public String getGetip() {
		return getip;
	}
	public void setGetip(String getip) {
		this.getip = getip;
	}
	public String getGetsystemname() {
		return getsystemname;
	}
	public void setGetsystemname(String getsystemname) {
		this.getsystemname = getsystemname;
	}
	public String getGetsystemversion() {
		return getsystemversion;
	}
	public void setGetsystemversion(String getsystemversion) {
		this.getsystemversion = getsystemversion;
	}
	public String getGetsystemarchitecture() {
		return getsystemarchitecture;
	}
	public void setGetsystemarchitecture(String getsystemarchitecture) {
		this.getsystemarchitecture = getsystemarchitecture;
	}
	
}	
