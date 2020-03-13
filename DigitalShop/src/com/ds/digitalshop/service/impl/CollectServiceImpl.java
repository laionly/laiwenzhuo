package com.ds.digitalshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.CollectDao;
import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.service.CollectService;
@Service("CollectServiceImpl")
@Transactional
public class CollectServiceImpl implements CollectService{
    @Autowired
    private CollectDao collectDao;
	@Override
	public void addCollect(Collect collect) {
		
		collectDao.addCollect(collect);
		}
	

	@Override
	public void deleteCollect(int cid) {
		collectDao.deleteCollect(cid);	
	}


	@Override
	public List<Collect> selectcollect() {
		List<Collect> collect=collectDao.selectCollect();
		return collect;
	}


	@Override
	public Collect selectCollect(int userid,int productid) {
		Collect collect=collectDao.selectCollect(userid,productid);
		return collect;
	}
}
