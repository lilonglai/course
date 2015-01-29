package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.utils.DatabaseHelp;

public class DbStudentOperation {
	public Student get(int key) {
		String sql = "select * from aeas_student where id = " + key;
		Student student = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				student = generateStudent(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}
	
	private Student generateStudent(ResultSet rs) throws SQLException{
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
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				student = generateStudent(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return student;
	}
	

	public ArrayList<Student> getByGrade(int grade) {
		String sql = "select * from aeas_student where grade = " + grade;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				Student student = generateStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<Student> getAll() {
		String sql = "select * from aeas_student";
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				Student student = generateStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<Student> getAlive() {
		String sql = "select * from aeas_student" + " where isalive=true";
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				Student student = generateStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<Student> getNotAlive() {
		String sql = "select * from aeas_student" + " where isalive=false";
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				Student student = generateStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<Student> getByTeacherId(int teacherId) {
		String sql = "select * from aeas_student where teacherid = "
				+ teacherId;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				Student student = generateStudent(rs);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(int key) {
		String sql = "delete from aeas_student where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void retire(int key) {
		String sql = "update aeas_student set isalive = false" + " where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DbStudentOperation studentOperation = new DbStudentOperation();
		System.out.println(studentOperation.getAll());
		
	}

}
