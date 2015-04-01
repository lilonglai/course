package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.operation.db.ITeacherHolidayOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTeacherHolidayOperation extends JdbcBaseOperation<TeacherHoliday> implements ITeacherHolidayOperation{
	public TeacherHoliday get(int key) {
		String sql = "select * from " + getTableName() + " where id = " + key;
		TeacherHoliday teacherHoliday = null;
		List<TeacherHoliday> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacherHoliday = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teacherHoliday;
	}

	protected TeacherHoliday generateObject(ResultSet rs) throws SQLException{
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setId(rs.getInt("id"));
		teacherHoliday.setTeacherId(rs.getInt("teacherid"));
		teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
		teacherHoliday.setIsHoliday(rs.getBoolean("isholiday"));
		return teacherHoliday;
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		String sql = "select * from " + getTableName() + " where teacherid = "
				+ teacherId;
		List<TeacherHoliday> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
		String sql = "select * from " + getTableName() + " where teacherid = " + teacherId 
				      + " and adjustdate='" +date + "'";
		TeacherHoliday teacherHoliday = null;
		List<TeacherHoliday> list = null;
		try {
			list = executeSql(sql);
			if(list.size() > 0){
				teacherHoliday = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return teacherHoliday;
	}

	public List<TeacherHoliday> getAll() {
		String sql = "select * from " + getTableName();
		List<TeacherHoliday> list = null;
		try {
			list = executeSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void add(TeacherHoliday teacherHoliday) {
		String sql = "insert into " + getTableName() + "(teacherid,adjustdate,isholiday) values("
				+ "" + teacherHoliday.getTeacherId() + ",";
		sql += "'" + teacherHoliday.getAdjustDate() + "',";
		sql += teacherHoliday.getIsHoliday() + ")";
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(TeacherHoliday teacherHoliday) {
		String sql = "update " + getTableName() + " set " + "teacherid="
				+ teacherHoliday.getTeacherId() + ",";

		sql += "adjustdate='" + teacherHoliday.getAdjustDate() + "',";
		sql += "isholiday=" + teacherHoliday.getIsHoliday();

		sql += " where id = " + teacherHoliday.getId();
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int key) {
		String sql = "delete from " + getTableName() + " where id = " + key;
		try {
			executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherholiday";
	}

}