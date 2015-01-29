package com.kevin.aeas.operation.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.utils.DatabaseHelp;

public class DbTeacherAbilityOperation {
	public TeacherAbility get(int key) {
		String sql = "select * from aeas_teacherability where id = " + key;
		TeacherAbility teacherAbility = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				teacherAbility = generateTeacherAbility(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacherAbility;

	}

	private TeacherAbility generateTeacherAbility(ResultSet rs) throws SQLException{
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setId(rs.getInt("id"));
		teacherAbility.setTeacherId(rs.getInt("teacherid"));
		teacherAbility.setCourseId(rs.getInt("courseid"));
		return teacherAbility;
	}
	
	public ArrayList<TeacherAbility> getAll() {
		String sql = "select aeas_teacherability.* from"
				+ " aeas_teacherability,aeas_firstcourse"
				+ " where aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		ArrayList<TeacherAbility> list = new ArrayList<TeacherAbility>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherAbility teacherAbility = generateTeacherAbility(rs);
				list.add(teacherAbility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<TeacherAbility> getByTeacherId(int teacherId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where teacherid = " + teacherId + " and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		ArrayList<TeacherAbility> list = new ArrayList<TeacherAbility>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherAbility teacherAbility = generateTeacherAbility(rs);
				list.add(teacherAbility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public ArrayList<TeacherAbility> getByCourseId(int courseId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where courseid = " + courseId + " and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		ArrayList<TeacherAbility> list = new ArrayList<TeacherAbility>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherAbility teacherAbility = generateTeacherAbility(rs);
				list.add(teacherAbility);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public int add(TeacherAbility teacherAbility){
		String sql = "insert into aeas_teacherability(teacherid,courseid) values("
				+"" +teacherAbility.getTeacherId() +","
				+"" +teacherAbility.getCourseId() +")";
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int update(TeacherAbility teacherAbility){
		String sql = "update aeas_teacherability set "
				+ "teacherid=" + "" + teacherAbility.getTeacherId() +","
				+ "courseid=" +"" + teacherAbility.getCourseId() +"";
		
		sql += " where id = " + teacherAbility.getId();
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public int delete(int key){
		String sql = "delete from aeas_teacherability where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public int deleteByTeacherId(int teacherId){
		String sql = "delete from aeas_teacherability where teacherid = " + teacherId;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public int deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete t from aeas_teacherability t where t.teacherid = " + teacherId
				+ " and t.courseid in(select c.id from aeas_firstcourse c where c.grade = " + grade + ")";
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		DbTeacherAbilityOperation teacherAbilityOperation = new DbTeacherAbilityOperation();
				
	}
}


