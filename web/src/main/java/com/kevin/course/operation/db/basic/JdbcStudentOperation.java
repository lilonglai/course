package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.Student;
import com.kevin.course.operation.db.IStudentOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcStudentOperation extends JdbcBaseOperation<Student> implements IStudentOperation {
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
		String sql = "select * from " + getTableName() + " where name = :name";
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
		try {
            List<Student> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	

	public List<Student> getByGrade(int grade) {
		String sql = "select * from " + getTableName() + " where grade = :grade";
        HashMap<String, Object> map = new HashMap<>();
        map.put("grade", grade);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Student> getAlive() {
		String sql = "select * from " + getTableName() + "" + " where isalive=true";
		try {
			return executeSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public List<Student> getNotAlive() {
		String sql = "select * from " + getTableName() + " where isalive=false";
		try {
			return executeSql(sql);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public List<Student> getByTeacherId(int teacherId) {
		String sql = "select * from " + getTableName() + " where teacherid = :teacherId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public void add(Student student){
		String sql = "insert into " + getTableName() + "(name,shortname,grade,testscore,targetscore,examinedate,examineplace,teacherid,description) values("
                +":name,:shortName,:grade,:testScore,:targetScore,:examineDate,:examinePlace,teacherId,description)";
        Map<String, Object> map = createMap(student);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}	
	}

	public void update(Student student) {
		String sql = "update " + getTableName() + " set "
				+ "name=:name, shortname=:shortName, grade=:grade, testscore=:testScore, targetscore=:targetScore, examinedate=:examineDate, examinePlace=:examinePlace, "
                + "teacherid =:teacherId, description=:description "
                + "where id = :id";

        Map<String, Object> map = createMap(student);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void retire(int key) {
		String sql = "update " + getTableName() + " set isalive = false" + " where id = :id";
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", key);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "aeas_student";
	}

}
