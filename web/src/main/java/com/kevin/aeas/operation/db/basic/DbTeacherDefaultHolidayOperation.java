package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class DbTeacherDefaultHolidayOperation {
	public TeacherDefaultHoliday get(int key){
		String sql = "select * from aeas_teacherdefaultholiday where id = " + key;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacherDefaultHoliday = generateTeacherDefaultHoliday(rs);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherDefaultHoliday;		
	}
	
	private TeacherDefaultHoliday generateTeacherDefaultHoliday(ResultSet rs) throws SQLException{
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
		String sql = "select * from aeas_teacherdefaultholiday where teacherid = " + teacherId;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacherDefaultHoliday = generateTeacherDefaultHoliday(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherDefaultHoliday;		
	}
	
	public List<TeacherDefaultHoliday> getAll(){
		String sql = "select * from aeas_teacherdefaultholiday";
		ArrayList<TeacherDefaultHoliday> list = new ArrayList<TeacherDefaultHoliday>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while(rs.next()){
				TeacherDefaultHoliday teacherDefaultHoliday = generateTeacherDefaultHoliday(rs);
				list.add(teacherDefaultHoliday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;		
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "insert into aeas_teacherdefaultholiday(teacherid,week1,week2,week3,week4,week5,week6,week7) values("
				+ "" +teacherDefaultHoliday.getTeacherId() +",";
		sql += teacherDefaultHoliday.getWeek1() +",";
		sql += teacherDefaultHoliday.getWeek2() +",";
		sql += teacherDefaultHoliday.getWeek3() +",";
		sql += teacherDefaultHoliday.getWeek4() +",";
		sql += teacherDefaultHoliday.getWeek5() +",";
		sql += teacherDefaultHoliday.getWeek6() +",";
		sql += teacherDefaultHoliday.getWeek7() +")";
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "update aeas_teacherdefaultholiday set "
				+ "teacherid=" + teacherDefaultHoliday.getTeacherId() +",";
		
		sql += "week1=" + teacherDefaultHoliday.getWeek1() +",";
		sql += "week2=" + teacherDefaultHoliday.getWeek2() +",";
		sql += "week3=" + teacherDefaultHoliday.getWeek3() +",";
		sql += "week4=" + teacherDefaultHoliday.getWeek4() +",";
		sql += "week5=" + teacherDefaultHoliday.getWeek5() +",";
		sql += "week6=" + teacherDefaultHoliday.getWeek6() +",";
		sql += "week7=" + teacherDefaultHoliday.getWeek7();
		
		sql += " where id = " + teacherDefaultHoliday.getId();
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(int key){
		String sql = "delete from aeas_teacherdefaultholiday where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from aeas_teacherdefaultholiday where teacherid = " + teacherId;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
