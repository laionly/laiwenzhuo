package com.mybatis.mapper;

import java.util.List;

import com.mybatis.entity.Score;
import com.mybatis.entity.StudentScore;

public interface ScoreMapper {
	//查询所有学生
	List<Score> findAll();
	//查询所有学生，并且带有的成绩信息
	List<StudentScore> findAllScore();
}
