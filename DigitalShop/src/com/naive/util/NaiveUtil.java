package com.naive.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import com.naive.entity.SysTool;
/**
 * 工具类
 * @author Naive
 * @date: 2019年12月23日 上午9:57:56
 */
public class NaiveUtil {

	public SysTool sysTool(HttpServletRequest request) {
		Date  date =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = sdf.format(date);
		SysTool sysTool = new SysTool();
		sysTool.setSystime(date1);
		sysTool.setGetip(request.getRemoteAddr());
		sysTool.setGetsystemname(System.getProperty("os.name"));
		sysTool.setGetsystemversion(System.getProperty("os.version"));
		sysTool.setGetsystemarchitecture(System.getProperty("os.arch"));
		return sysTool;
	}
}
