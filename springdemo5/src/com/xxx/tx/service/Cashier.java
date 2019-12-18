package com.xxx.tx.service;

import java.util.List;

/**
 * 
 * <p>Title: Cashier</p>  
 * <p>Description:[kæˈʃɪə(r)]
   </p>  
 * @author  wpf  
 * @date  2019年12月3日
 */
public interface Cashier {
	//检查验证购买多本书
	public void checkout(String name,List<String> isbns);
	

}
