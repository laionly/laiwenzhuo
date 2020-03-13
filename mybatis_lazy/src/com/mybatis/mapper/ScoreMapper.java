package com.mybatis.mapper;

import java.util.List;

import com.mybatis.entity.Score;

public interface ScoreMapper {
	//查询所有学生
	List<Score> findAll();
	
	List<Score> findScoreByStid(Integer stid);
}
