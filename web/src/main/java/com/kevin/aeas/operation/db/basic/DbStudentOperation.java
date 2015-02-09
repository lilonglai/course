package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.Student;

public class DbStudentOperation extends DbBaseOperation{
	public Student get(int key) {
		String sql = "select * from aeas_student where id = " + key;
		Student student = null;
		List<Student> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				student = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	protected Student generateObject(ResultSet rs) throws SQLException{
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setShortName(rs.getString("shortname"));
		student.setGrade(rs.getInt("grade"));
		student.setTestScore(rs.getString("testscore"));
		student.setTargetScore(rs.getString("targetScore"));

		student.setExamineDate(rs.getDate("examinedate"));
		student.setExaminePlace(rs.getString("examineplace"));
		student.setTeacherId(rs.getInt("teacherid"));
		student.setDescription(rs.getString("description"));
	    return student;	
	}
	
	public Student getByName(String name) {
		String sql = "select * from aeas_student where name = '" + name + "'";
		Student student = null;
		List<Student> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				student = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	

	public List<Student> getByGrade(int grade) {
		String sql = "select * from aeas_student where grade = " + grade;
		List<Student> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Student> getAll() {
		String sql = "select * from aeas_student";
		List<Student> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Student> getAlive() {
		String sql = "select * from aeas_student" + " where isalive=true";
		List<Student> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Student> getNotAlive() {
		String sql = "select * from aeas_student" + " where isalive=false";
		List<Student> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Student> getByTeacherId(int teacherId) {
		String sql = "select * from aeas_student where teacherid = "
				+ teacherId;
		List<Student> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void add(Student student){
		String sql = "insert into aeas_student(name,shortname,grade,testscore,targetScore,examinedate,examineplace,teacherid,description) values("
				+ "'" + student.getName() +"',"
				+ "'" +student.getShortName() +"',"
				+"" +student.getGrade() +","
		        +"'" +student.getTestScore() +"'," 
				+"'" +student.getTargetScore() +"',";;
		if(student.getExamineDate() == null){
			sql += "" + "NULL" + ",";
		}
		else{
			sql += "'" +  student.getExamineDate() +"',";
		}
		
		if(student.getExaminePlace() == null){
			sql += "'" + "" + "',";
		}
		else{
			sql += "'" +  student.getExaminePlace() +"',";
		}
		
		sql += "" +student.getTeacherId() +",";
		
		if(student.getDescription() == null){
			sql += "'" + "" + "')";
		}
		else{
			sql += "'" +  student.getDescription() +"')";
		}
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void update(Student student) {
		String sql = "update aeas_student set "
				+ "name=" + "'" + student.getName() + "'," 
				+ "shortname=" + "'" + student.getShortName() + "',"
	            + "grade=" + student.getGrade() + ","
		        + "testscore='" + student.getTestScore() + "',"
	            +"targetScore='" + student.getTargetScore() + "',";
		
		if(student.getExamineDate() == null){
			sql += "examinedate =" + "" + "NULL" + ",";
		}
		else{
			sql += "examinedate =" + "'" +  student.getExamineDate() +"',";
		}
		
		if(student.getExaminePlace() == null){
			sql += "examineplace=" + "'" + "" + "',";
		}
		else{
			sql += "examineplace=" + "'" +  student.getExaminePlace() +"',";
		}
		
		sql += "teacherid=" +student.getTeacherId() +",";
		
		if(student.getDescription() == null){
			sql += "description="+ "'" + "" + "'";
		}
		else{
			sql += "description="+ "'" +  student.getDescription() +"'";
		}
		
		sql += " where id = " + student.getId();

		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int key) {
		String sql = "delete from aeas_student where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void retire(int key) {
		String sql = "update aeas_student set isalive = false" + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbStudentOperation studentOperation = new DbStudentOperation();
		System.out.println(studentOperation.getAll());
		
	}

}
