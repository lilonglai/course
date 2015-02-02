package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kevin.aeas.object.TeacherHoliday;
import com.kevin.aeas.utils.DatabaseHelp;

public class DbTeacherHolidayOperation {
	public TeacherHoliday get(int key) {
		String sql = "select * from aeas_teacherholiday where id = " + key;
		TeacherHoliday teacherHoliday = null;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if (rs.next()) {
				teacherHoliday = generateTeacherHoliday(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return teacherHoliday;

	}

	private TeacherHoliday generateTeacherHoliday(ResultSet rs) throws SQLException{
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setId(rs.getInt("id"));
		teacherHoliday.setTeacherId(rs.getInt("teacherid"));
		teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
		teacherHoliday.setIsHoliday(rs.getBoolean("isholiday"));
		return teacherHoliday;
	}
	
	public ArrayList<TeacherHoliday> getByTeacherId(int teacherId) {
		String sql = "select * from aeas_teacherholiday where teacherid = "
				+ teacherId;
		ArrayList<TeacherHoliday> list = new ArrayList<TeacherHoliday>();
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			while (rs.next()) {
				TeacherHoliday teacherHoliday = generateTeacherHoliday(rs);
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
				teacherHoliday = generateTeacherHoliday(rs);

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
				TeacherHoliday teacherHoliday = generateTeacherHoliday(rs);

				list.add(teacherHoliday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void add(TeacherHoliday teacherHoliday) {
		String sql = "insert into aeas_teacherholiday(teacherid,adjustdate,isholiday) values("
				+ "" + teacherHoliday.getTeacherId() + ",";
		sql += "'" + teacherHoliday.getAdjustDate() + "',";
		sql += teacherHoliday.getIsHoliday() + ")";

		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	public void update(TeacherHoliday teacherHoliday) {
		String sql = "update aeas_teacherholiday set " + "teacherid="
				+ teacherHoliday.getTeacherId() + ",";

		sql += "adjustdate='" + teacherHoliday.getAdjustDate() + "',";
		sql += "isholiday=" + teacherHoliday.getIsHoliday();

		sql += " where id = " + teacherHoliday.getId();

		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int key) {
		String sql = "delete from aeas_teacherholiday where id = " + key;
		int count = 0;
		try {
			count = DatabaseHelp.getInstance().executeUpdateSql(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
