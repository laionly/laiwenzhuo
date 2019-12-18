package com.xxx.tx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xxx.tx.service.AccountService;
import com.xxx.tx.service.Cashier;
/**
 * 
 * <p>Title: CashierImpl</p>  
 * <p>Description:购买多本书的实现类 </p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
@Service("cashier")
public class CashierImpl implements Cashier{
	@Autowired
	private AccountService as;
	/*
	 * 使用propagation属性配置事务传播行为，即当前事务方法被另一个事务方法调用时
	 * 如何使用事务？
	 * 默认是REQUIRED,即使用调用方法的事务
	 * REQUIRES_NEW,开启一个新的事务，使用自己的事务，调用方法的事务被挂起
	 * 注意：查看这两个值对应数据库表中的变化
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void checkout(String name, List<String> isbns) {
		for (String isbn : isbns) {
			//价格只能购买一本书，数据库表数据是否发生变化
			as.purchase(name, isbn);
			
		}
		
	}

}
