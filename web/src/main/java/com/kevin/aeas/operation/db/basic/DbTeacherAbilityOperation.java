package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.TeacherAbility;

public class DbTeacherAbilityOperation extends DbBaseOperation<TeacherAbility>{
	public TeacherAbility get(int key) {
		String sql = "select * from " + getTableName() + " where id = " + key;
		TeacherAbility teacherAbility = null;
		List<TeacherAbility> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacherAbility = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherAbility;
	}

	protected TeacherAbility generateObject(ResultSet rs) throws SQLException{
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setId(rs.getInt("id"));
		teacherAbility.setTeacherId(rs.getInt("teacherid"));
		teacherAbility.setCourseId(rs.getInt("courseid"));
		return teacherAbility;
	}
	
	public List<TeacherAbility> getAll() {
		String sql = "select aeas_teacherability.* from"
				+ " aeas_teacherability,aeas_firstcourse"
				+ " where aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		List<TeacherAbility> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where teacherid = " + teacherId + " and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		List<TeacherAbility> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		String sql = "select aeas_teacherability.*"
				+ " from aeas_teacherability,aeas_firstcourse"
				+ " where courseid = " + courseId + " and aeas_firstcourse.id=aeas_teacherability.courseid"
				+ " order by aeas_firstcourse.grade";
		List<TeacherAbility> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void add(TeacherAbility teacherAbility){
		String sql = "insert into " + getTableName() + "(teacherid,courseid) values("
				+"" +teacherAbility.getTeacherId() +","
				+"" +teacherAbility.getCourseId() +")";
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void update(TeacherAbility teacherAbility){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=" + "" + teacherAbility.getTeacherId() +","
				+ "courseid=" +"" + teacherAbility.getCourseId() +"";
		
		sql += " where id = " + teacherAbility.getId();
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(int key){
		String sql = "delete from " + getTableName() + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from " + getTableName() + " where teacherid = " + teacherId;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		String sql = "delete t from aeas_teacherability t where t.teacherid = " + teacherId
				+ " and t.courseid in(select c.id from aeas_firstcourse c where c.grade = " + grade + ")";
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherability";
	}
	
}


