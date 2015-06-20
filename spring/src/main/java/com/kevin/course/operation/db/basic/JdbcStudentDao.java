package com.kevin.course.operation.db.basic;

import com.kevin.course.object.Student;
import com.kevin.course.operation.db.IStudentOperation;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcStudentDao extends JdbcBaseDao<Student> implements IStudentOperation {
	protected Student generateObject(ResultSet rs) throws SQLException{
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setShortName(rs.getString("shortname"));
		student.setGrade(rs.getInt("grade"));
		student.setTestScore(rs.getString("testscore"));
		student.setTargetScore(rs.getString("targetscore"));

		student.setExamineDate(rs.getDate("examinedate"));
		student.setExaminePlace(rs.getString("examineplace"));
		student.setTeacherId(rs.getInt("teacherid"));
		student.setDescription(rs.getString("description"));
	    return student;	
	}
	
	public Student getByName(String name) {
		String sql = "select * from " + getTableName() + " where name = ?";
		List<Student> list = query(sql, this, new Object[]{name});
		return list.isEmpty()? null : list.get(0);
	}
	

	public List<Student> getByGrade(int grade) {
		String sql = "select * from " + getTableName() + " where grade = ?";
		return query(sql, this, new Object[]{grade});
	}
	
	public List<Student> getAlive() {
		String sql = "select * from " + getTableName() + "" + " where isalive=?";
		return query(sql, this, new Object[]{true});
	}
	
	public List<Student> getNotAlive() {
		String sql = "select * from " + getTableName() + " where isalive=?";
		return query(sql, this, new Object[]{false});
	}

	public List<Student> getByTeacherId(int teacherId) {
		String sql = "select * from " + getTableName() + " where teacherid = ?";
		return query(sql, this, new Object[]{teacherId});
	}

	public void add(final Student student){
		String sql = "insert into " + getTableName() + "(name,shortname,grade,testscore,targetscore,examinedate,examineplace,teacherid,description) values("
                +"?,?,?,?,?,?,?,?,?)";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, student.getName());
				ps.setString(2, student.getShortName());
				ps.setInt(3, student.getGrade());
				ps.setString(4, student.getTestScore());
				ps.setString(5, student.getTestScore());
				ps.setDate(6, student.getExamineDate());
				ps.setString(7, student.getExaminePlace());
				ps.setInt(8, student.getTeacherId());
				ps.setString(9, student.getDescription());
			}
		};
		update(sql, setter);
		student.setId(mysql_insert_id());
	}

	public void update(final Student student) {
		String sql = "update " + getTableName() + " set "
				+ "name=?, shortname=?, grade=?, testscore=?, targetscore=?, examinedate=?, examinePlace=?, "
                + "teacherid=?, description=? "
                + "where id=?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, student.getName());
				ps.setString(2, student.getShortName());
				ps.setInt(3, student.getGrade());
				ps.setString(4, student.getTestScore());
				ps.setString(5, student.getTestScore());
				ps.setDate(6, student.getExamineDate());
				ps.setString(7, student.getExaminePlace());
				ps.setInt(8, student.getTeacherId());
				ps.setString(9, student.getDescription());
				ps.setInt(10, student.getId());
			}
		};
		update(sql, setter);
	}
	
	public void retire(int key) {
		String sql = "update " + getTableName() + " set isalive = false" + " where id = ?";
		update(sql, new Object[]{key});
	}

	@Override
	protected String getTableName() {
		return "aeas_student";
	}

}
