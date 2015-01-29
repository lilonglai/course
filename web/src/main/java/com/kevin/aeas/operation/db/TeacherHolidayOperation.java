package com.kevin.aeas.operation.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class TeacherHolidayOperation {
	public TeacherHoliday get(int key) {
		String sql = "select * from aeas_teacherholiday where id = " + key;
		TeacherHoliday teacherHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				teacherHoliday = new TeacherHoliday();
				teacherHoliday.setId(rs.getInt("id"));
				teacherHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
				teacherHoliday.setHoliday(rs.getBoolean("isholiday"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacherHoliday;

	}

	public ArrayList<TeacherHoliday> getByTeacherId(int teacherId) {
		String sql = "select * from aeas_teacherholiday where teacherid = "
				+ teacherId;
		ArrayList<TeacherHoliday> list = new ArrayList<TeacherHoliday>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherHoliday teacherHoliday = new TeacherHoliday();
				teacherHoliday.setId(rs.getInt("id"));
				teacherHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
				teacherHoliday.setHoliday(rs.getBoolean("isholiday"));

				list.add(teacherHoliday);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String date) {
		String sql = "select * from aeas_teacherholiday where teacherid = " + teacherId 
				      + " and adjustdate='" +date + "'";
		TeacherHoliday teacherHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				teacherHoliday = new TeacherHoliday();
				teacherHoliday.setId(rs.getInt("id"));
				teacherHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
				teacherHoliday.setHoliday(rs.getBoolean("isholiday"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacherHoliday;

	}

	public ArrayList<TeacherHoliday> getAll() {
		String sql = "select * from aeas_teacherholiday";
		ArrayList<TeacherHoliday> list = new ArrayList<TeacherHoliday>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherHoliday teacherHoliday = new TeacherHoliday();
				teacherHoliday.setId(rs.getInt("id"));
				teacherHoliday.setTeacherId(rs.getInt("teacherid"));
				teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
				teacherHoliday.setHoliday(rs.getBoolean("isholiday"));

				list.add(teacherHoliday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public int add(TeacherHoliday teacherHoliday) {
		String sql = "insert into aeas_teacherholiday(teacherid,adjustdate,isholiday) values("
				+ "" + teacherHoliday.getTeacherId() + ",";
		sql += "'" + teacherHoliday.getAdjustDate() + "',";
		sql += teacherHoliday.isHoliday() + ")";

		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;

	}

	public int update(TeacherHoliday teacherHoliday) {
		String sql = "update aeas_teacherholiday set " + "teacherid="
				+ teacherHoliday.getTeacherId() + ",";

		sql += "adjustdate='" + teacherHoliday.getAdjustDate() + "',";
		sql += "isholiday=" + teacherHoliday.isHoliday();

		sql += " where id = " + teacherHoliday.getId();

		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public int delete(int key) {
		String sql = "delete from aeas_teacherholiday where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public static void main(String[] args) {
		TeacherHolidayOperation operation = new TeacherHolidayOperation();
		// System.out.println(operation.getAll());
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setTeacherId(1);
		teacherHoliday.setAdjustDate(new Date(new java.util.Date().getTime()));
		teacherHoliday.setHoliday(true);
		// operation.add(teacherHoliday);

		Calendar cal = Calendar.getInstance();
		cal.setTime(teacherHoliday.getAdjustDate());
		for (int i = 1; i <= 30; i++) {
			int weekno = cal.get(Calendar.DAY_OF_WEEK);
			System.out.println(cal.getTime() +":" + weekno);
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}

	}

}
