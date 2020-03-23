package com.ep.ep.dao.focustable;

import java.util.List;

import com.ep.ep.entity.Focustable;
import org.apache.ibatis.annotations.Param;

public interface IFocustableDao {
	//级联查看收藏夹，商品信息
	public List<Focustable> findFocustable(Integer uid);
	//通过pid（商品id）删除收藏项
	public void deleteFocustableByFid(@Param("fid") Integer fid);
	//清空收藏夹
	public void removeAllFocustableByUid(Integer uid);

}
