package com.kevin.aeas.operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class TeacherDefaultHolidayOperation {
	public TeacherDefaultHoliday get(int key){
		String sql = "select * from aeas_teacherdefaultholiday where id = " + key;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacherDefaultHoliday = new TeacherDefaultHoliday();
				teacherDefaultHoliday.setId(rs.getInt("id"));
				teacherDefaultHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherDefaultHoliday.setWeek1(rs.getBoolean("weak1"));
				teacherDefaultHoliday.setWeek2(rs.getBoolean("weak2"));
				teacherDefaultHoliday.setWeek3(rs.getBoolean("weak3"));
				teacherDefaultHoliday.setWeek4(rs.getBoolean("weak4"));
				teacherDefaultHoliday.setWeek5(rs.getBoolean("weak5"));
				teacherDefaultHoliday.setWeek6(rs.getBoolean("weak6"));
				teacherDefaultHoliday.setWeek7(rs.getBoolean("weak7"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return teacherDefaultHoliday;
		
	}
	
	public TeacherDefaultHoliday getByTeacherId(int teacherId){
		String sql = "select * from aeas_teacherdefaultholiday where teacherid = " + teacherId;
		TeacherDefaultHoliday teacherDefaultHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				teacherDefaultHoliday = new TeacherDefaultHoliday();
				teacherDefaultHoliday.setId(rs.getInt("id"));
				teacherDefaultHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherDefaultHoliday.setWeek1(rs.getBoolean("weak1"));
				teacherDefaultHoliday.setWeek2(rs.getBoolean("weak2"));
				teacherDefaultHoliday.setWeek3(rs.getBoolean("weak3"));
				teacherDefaultHoliday.setWeek4(rs.getBoolean("weak4"));
				teacherDefaultHoliday.setWeek5(rs.getBoolean("weak5"));
				teacherDefaultHoliday.setWeek6(rs.getBoolean("weak6"));
				teacherDefaultHoliday.setWeek7(rs.getBoolean("weak7"));
				
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
				list.add(teacherDefaultHoliday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

	public int add(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "insert into aeas_teacherdefaultholiday(teacherid,weak1,weak2,weak3,weak4,weak5,weak6,weak7) values("
				+ "" +teacherDefaultHoliday.getTeacherId() +",";
		sql += teacherDefaultHoliday.isWeek1() +",";
		sql += teacherDefaultHoliday.isWeek2() +",";
		sql += teacherDefaultHoliday.isWeek3() +",";
		sql += teacherDefaultHoliday.isWeek4() +",";
		sql += teacherDefaultHoliday.isWeek5() +",";
		sql += teacherDefaultHoliday.isWeek6() +",";
		sql += teacherDefaultHoliday.isWeek7() +")";
		
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public int update(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "update aeas_teacherdefaultholiday set "
				+ "teacherid=" + teacherDefaultHoliday.getTeacherId() +",";
		
		sql += "weak1=" + teacherDefaultHoliday.isWeek1() +",";
		sql += "weak2=" + teacherDefaultHoliday.isWeek2() +",";
		sql += "weak3=" + teacherDefaultHoliday.isWeek3() +",";
		sql += "weak4=" + teacherDefaultHoliday.isWeek4() +",";
		sql += "weak5=" + teacherDefaultHoliday.isWeek5() +",";
		sql += "weak6=" + teacherDefaultHoliday.isWeek6() +",";
		sql += "weak7=" + teacherDefaultHoliday.isWeek7();
		
		sql += " where id = " + teacherDefaultHoliday.getId();
		
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
		String sql = "delete from aeas_teacherdefaultholiday where id = " + key;
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
		String sql = "delete from aeas_teacherdefaultholiday where teacherid = " + teacherId;
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
		TeacherDefaultHolidayOperation operation = new TeacherDefaultHolidayOperation();
		System.out.println(operation.getAll());
		
		TeacherDefaultHoliday object= new TeacherDefaultHoliday();
		object.setId(3);
		object.setTeacherId(1);
		object.setWeek1(true);
		object.setWeek2(true);
		
		operation.update(object);
		
		
		
		
	}
}