package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		teacherDefaultHoliday.setWeek1(rs.getBoolean("weak1"));
		teacherDefaultHoliday.setWeek2(rs.getBoolean("weak2"));
		teacherDefaultHoliday.setWeek3(rs.getBoolean("weak3"));
		teacherDefaultHoliday.setWeek4(rs.getBoolean("weak4"));
		teacherDefaultHoliday.setWeek5(rs.getBoolean("weak5"));
		teacherDefaultHoliday.setWeek6(rs.getBoolean("weak6"));
		teacherDefaultHoliday.setWeek7(rs.getBoolean("weak7"));
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
	
	public ArrayList<TeacherDefaultHoliday> getAll(){
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
		String sql = "insert into aeas_teacherdefaultholiday(teacherid,weak1,weak2,weak3,weak4,weak5,weak6,weak7) values("
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
		
		sql += "weak1=" + teacherDefaultHoliday.getWeek1() +",";
		sql += "weak2=" + teacherDefaultHoliday.getWeek2() +",";
		sql += "weak3=" + teacherDefaultHoliday.getWeek3() +",";
		sql += "weak4=" + teacherDefaultHoliday.getWeek4() +",";
		sql += "weak5=" + teacherDefaultHoliday.getWeek5() +",";
		sql += "weak6=" + teacherDefaultHoliday.getWeek6() +",";
		sql += "weak7=" + teacherDefaultHoliday.getWeek7();
		
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
	
	public static void main(String[] args) {
		DbTeacherDefaultHolidayOperation operation = new DbTeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());
		
		TeacherDefaultHoliday object= new TeacherDefaultHoliday();
		object.setId(3);
		object.setTeacherId(1);
		object.setWeek1(true);
		object.setWeek2(true);
		
		operation.update(object);
				
	}
}
