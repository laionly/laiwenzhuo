package com.mybatis.ui;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.entity.Score;
import com.mybatis.entity.StudentScore;
import com.mybatis.mapper.ScoreMapper;
import com.mybatis.util.MybatisUtil;

public class TestScoreMapper {
	@Test
	public void findAll() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			ScoreMapper mapper = session.getMapper(ScoreMapper.class);
			List<Score> scores = mapper.findAll();
			for (Score score : scores) {
				System.out.println("---------每个学生的信息---------");
				System.out.println(score);
				System.out.println(score.getStudent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	//查询学生成绩，同时包含成绩和姓名、学号
	@Test
	public void findAllScore() {
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			// 执行,调用session.getMapper()方法得到一个代理对象，代理对象进行增删改查操作；MapperProxyFactory类
			ScoreMapper mapper = session.getMapper(ScoreMapper.class);
			List<StudentScore> ss = mapper.findAllScore();
			for (StudentScore studentScore : ss) {
				System.out.println(studentScore);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
