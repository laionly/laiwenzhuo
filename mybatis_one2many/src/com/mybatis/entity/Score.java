package com.mybatis.entity;

public class Score {
	private Integer sid;//主键id
	private Integer stid;//外键
	private String course;
	private String score;
	private Student student;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", stid=" + stid + ", course=" + course + ", score=" + score + ", student="
				+ student + "]";
	}

	
	
	
	
	
}
