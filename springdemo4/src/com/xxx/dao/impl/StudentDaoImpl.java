package com.xxx.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.xxx.dao.StudentDao;
import com.xxx.entity.Student;

/**
 * 
 * <p>
 * Title: StudentDaoImpl
 * </p>
 * <p>
 * Description:使用JdbcTemplate实现对学生对象的增删改查操作， 使用@Repository实例化该对象
 * </p>
 * 
 * @author wpf
 * @date 2019年11月28日
 */

@Repository
public class StudentDaoImpl implements StudentDao {
	/*
	 * @Autowired是根据类型进行自动装配的。
	 * 如果当Spring上下文中存在不止一个相关类型的bean时，就会抛出BeanCreationException异常;
	 * 如果Spring上下文中不存在相关类型的bean，也会抛出BeanCreationException异常。
	 * 我们可以使用@Qualifier配合@Autowired来解决这类问题。
	 * 
	 * @Resource是根据名称进行自动装配的。
	 * 
	 * @Resource有两个属性是比较重要的，分是name和type，
	 * Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。
	 * 所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。
	 * 如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
	 */
//	@Autowired
	@Resource
	private JdbcTemplate jdbcTemplate;
	// 适用于具名参数
//	@Autowired
	@Resource
	private NamedParameterJdbcTemplate npjt;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {
		 String sql="insert into student(stuNo,name,sex) values(?,?,?)";
		 Object[] obj=new
		 Object[]{student.getStuNo(),student.getName(),student.getSex()};
		 int result=this.jdbcTemplate.update(sql, obj);
		// 具名参数
//		String sql = "insert into student(stuNo,name,sex) values(:stuNo,:name,:sex)";
//		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(student);
//		int result = this.npjt.update(sql, paramSource);

		return result;
	}

	// 批量操作时执行batchUpdate操作
	@Override
	public int batchAddStudents(List<Student> stu) {
		// 具名参数
//		String sql = "insert into student(stuNo,name,sex) values(:stuNo,:name,:sex)";
//		SqlParameterSource[] batchValues = SqlParameterSourceUtils.createBatch(stu);
//		int[] result = this.npjt.batchUpdate(sql, batchValues);
//	

	 String sql="insert into student(stuNo,name,sex) values(?,?,?)";
	/*
	 * BatchPreparedStatementSetter接口 批量执行相同的sql语句 public int
	 * getBatchSize(）；用来返回执行的次数 public void setValues(PreparedStatement ps,int
	 * i)； 用来为PreparedStatement设值。 参数说明： ps：我们将要设值的PreparedStatement
	 * i：正在执行操作的索引，从0算起。
	 */
	 int[] result=this.jdbcTemplate.batchUpdate(sql, new
	 BatchPreparedStatementSetter() {
//	 使用类名内部类实现BatchPreparedStatementSetter接口
	@Override
	public void setValues(PreparedStatement ps, int arg1) throws SQLException {
		Student student = stu.get(arg1);
		ps.setString(1, student.getStuNo());
		ps.setString(2, student.getName());
		ps.setString(3, student.getSex());

	}

	@Override
	public int getBatchSize() {
		// 返回添加的数量/条数
		return stu.size();
	}

	});
	// 数组看长度，集合看大小.
	return result.length;
	}

	@Override
	public int batchAddStudentsByNamed(List<Student> stu) {
		// 使用具名参数实现批量添加,SqlParameterSourceUtils类
		String sql = "insert into student(stuNo,name,sex) values(:stuNo,:name,:sex)";
		/*
		 * 批量添加时使用batchUpdate(sql, batchArgs); 第二个参数返回的是SqlParameterSource[]
		 */
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(stu);
		int[] result = this.npjt.batchUpdate(sql, batchArgs);
		return result.length;

	}

	@Override
	public int updateStudent(Student student) {
		//具名参数
		String sql = "update student set stuNo=:stuNo,name=:name,sex=:sex where id=:id";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(student);
		int result=this.npjt.update(sql, paramSource);
		
//		String sql = "update student set stuNo=?,name=?,sex=? where id=?";
//		Object[] obj = new Object[] { student.getStuNo(), student.getName(), student.getSex(), student.getId() };
//		int result = this.jdbcTemplate.update(sql, obj);

		return result;
	}

	@Override
	public int batchUpdateStudents(List<Student> stu) {
		//具名参数
		String sql = "update student set stuNo=:stuNo,name=:name,sex=:sex where id=:id";
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(stu);
		int[] result=this.npjt.batchUpdate(sql, batchArgs);
		
//		String sql = "update student set stuNo=?,name=?,sex=? where id=?";
//		int[] result = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				Student student = stu.get(i);
//				ps.setString(1, student.getStuNo());
//				ps.setString(2, student.getName());
//				ps.setString(3, student.getSex());
//				ps.setInt(4, student.getId());
//			}
//
//			@Override
//			public int getBatchSize() {
//
//				return stu.size();
//			}
//		});
		return result.length;
	}

	@Override
	public int deleteStudent(Integer id) {
		//具名参数
		String sql = "delete from student  where id=:id";
		Student std = new Student();
		std.setId(id);
		System.out.println(std);
		SqlParameterSource paramSource=new BeanPropertySqlParameterSource(std);
		int result=this.npjt.update(sql, paramSource);
		return result;
		
//		String sql = "delete from student  where id=?";
//		int result = this.jdbcTemplate.update(sql, id);
//		return result;
	}

	@Override
	public int batchDeleteStudents(List<Integer> ids) {
		//具名参数
		String sql = "delete from student where id=:id";
		List<Student> students=new ArrayList<Student>();
		System.out.println(ids);
		for(int i=0;i<ids.size();i++){
			Student std=new Student();
			std.setId(ids.get(i));
			students.add(std);
			System.out.println(students);
		}
		System.out.println(students);
		SqlParameterSource[] parameterSources = SqlParameterSourceUtils.createBatch(students);
		int[] result=this.npjt.batchUpdate(sql, parameterSources);
		
//		String sql = "delete from student  where id=?";
//		int[] result = this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//
//				ps.setInt(1, ids.get(i));
//			}
//
//			@Override
//			public int getBatchSize() {
//
//				return ids.size();
//			}
//		});
		return result.length;
	}

	/*
	 * 查询方法： 查询得到一个JavaBean 查询得到集合 RowMapper接口：可以将数据库表中的每一行数据封装成用户定义的类对象。
	 * mapRow(ResultSet rs, int rowNum) rs:返回的结果记录集 rowNUm:当前行的编号
	 * 
	 */
	@Override
	public Student findStudentById(int id) {
		String sql = "select * from student  where id=?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		Student student = this.jdbcTemplate.queryForObject(sql, rowMapper, id);// 查询一个学生对象
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		String sql = "select * from student";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		List<Student> list = this.jdbcTemplate.query(sql, rowMapper);
		return list;
	}


}
