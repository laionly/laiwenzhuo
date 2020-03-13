package com.ds.digitalshop.dao;

import java.util.List;

import com.ds.digitalshop.entity.Collect;

public interface CollectDao {
public void addCollect(Collect collect);

public void deleteCollect(int cid);

public List<Collect> selectCollect();

public Collect selectCollect(int userid,int productid);

}
