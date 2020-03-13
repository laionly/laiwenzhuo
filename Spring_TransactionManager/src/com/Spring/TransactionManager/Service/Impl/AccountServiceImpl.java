package com.Spring.TransactionManager.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.TransactionManager.Dao.IAccountDao;
import com.Spring.TransactionManager.Dao.Impl.AccountDaoImpl;
import com.Spring.TransactionManager.Service.AccountService;
import com.Spring.TransactionManager.entity.Account;
@Service("AccountService")
//@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AccountServiceImpl implements AccountService{
	@Autowired
	IAccountDao iAccountDao;
	


	public void setiAccountDao(IAccountDao iAccountDao) {
		this.iAccountDao = iAccountDao;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void transfer(int outAcountId, int intAcoutId, double money) {
		Account outaccount=iAccountDao.finAccountById(outAcountId);
		Account intAccount=iAccountDao.finAccountById(intAcoutId);
		double outtf=outaccount.getMoney()-money;
		double inttf=intAccount.getMoney()+money;
		outaccount.setMoney(outtf);
		intAccount.setMoney(inttf);		
		
		iAccountDao.updateAccount(outaccount);
		int a=1/0;
		iAccountDao.updateAccount(intAccount);
		
	}

}
