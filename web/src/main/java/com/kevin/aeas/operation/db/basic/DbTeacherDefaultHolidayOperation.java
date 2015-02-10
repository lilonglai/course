package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.kevin.aeas.object.TeacherDefaultHoliday;

public class DbTeacherDefaultHolidayOperation extends DbBaseOperation<TeacherDefaultHoliday>{
	public TeacherDefaultHoliday get(int key){
		String sql = "select * from " + getTableName() + " where id = " + key;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		List<TeacherDefaultHoliday> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacherDefaultHoliday = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherDefaultHoliday;		
	}
	
	protected TeacherDefaultHoliday generateObject(ResultSet rs) throws SQLException{
		TeacherDefaultHoliday teacherDefaultHoliday = new TeacherDefaultHoliday();
		teacherDefaultHoliday.setId(rs.getInt("id"));
		teacherDefaultHoliday.setTeacherId(rs.getInt("teacherid"));
		teacherDefaultHoliday.setWeek1(rs.getBoolean("week1"));
		teacherDefaultHoliday.setWeek2(rs.getBoolean("week2"));
		teacherDefaultHoliday.setWeek3(rs.getBoolean("week3"));
		teacherDefaultHoliday.setWeek4(rs.getBoolean("week4"));
		teacherDefaultHoliday.setWeek5(rs.getBoolean("week5"));
		teacherDefaultHoliday.setWeek6(rs.getBoolean("week6"));
		teacherDefaultHoliday.setWeek7(rs.getBoolean("week7"));
		return teacherDefaultHoliday;
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		String sql = "select * from " + getTableName() + " where teacherid = " + teacherId;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		List<TeacherDefaultHoliday> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacherDefaultHoliday = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacherDefaultHoliday;		
	}
	
	public List<TeacherDefaultHoliday> getAll(){
		String sql = "select * from " + getTableName();
		List<TeacherDefaultHoliday> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "insert into " + getTableName() + "(teacherid,week1,week2,week3,week4,week5,week6,week7) values("
				+ "" +teacherDefaultHoliday.getTeacherId() +",";
		sql += teacherDefaultHoliday.getWeek1() +",";
		sql += teacherDefaultHoliday.getWeek2() +",";
		sql += teacherDefaultHoliday.getWeek3() +",";
		sql += teacherDefaultHoliday.getWeek4() +",";
		sql += teacherDefaultHoliday.getWeek5() +",";
		sql += teacherDefaultHoliday.getWeek6() +",";
		sql += teacherDefaultHoliday.getWeek7() +")";
		
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=" + teacherDefaultHoliday.getTeacherId() +",";
		
		sql += "week1=" + teacherDefaultHoliday.getWeek1() +",";
		sql += "week2=" + teacherDefaultHoliday.getWeek2() +",";
		sql += "week3=" + teacherDefaultHoliday.getWeek3() +",";
		sql += "week4=" + teacherDefaultHoliday.getWeek4() +",";
		sql += "week5=" + teacherDefaultHoliday.getWeek5() +",";
		sql += "week6=" + teacherDefaultHoliday.getWeek6() +",";
		sql += "week7=" + teacherDefaultHoliday.getWeek7();
		
		sql += " where id = " + teacherDefaultHoliday.getId();
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

	@Override
	protected String getTableName() {
		return "aeas_teacherdefaultholiday";
	}
	
}
