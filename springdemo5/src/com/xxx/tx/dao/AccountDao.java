package com.xxx.tx.dao;
/**
 * 
 * <p>Title: AccountDao</p>  
 * <p>Description: 转账接口</p>  
 * @author  wpf  
 * @date  2019年11月28日
 */
public interface AccountDao {
	//转出
	public boolean transferOut(String outName,double money);
	//转入
	public boolean transferIn(String inName,double money);
}
