package com.ds.digitalshop.service;

import java.util.List;

import com.ds.digitalshop.entity.Collect;

public interface CollectService {
 public void addCollect(Collect collect);
 
 public void deleteCollect(int cid);
 
 public List<Collect> selectcollect();
 
 public Collect selectCollect(int userid,int productid);
}
