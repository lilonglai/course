package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.ITeacherDefaultHolidayOperation;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTeacherDefaultHolidayDao extends JdbcBaseDao<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation{
	
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
		String sql = "select * from " + getTableName() + " where teacherid = ?";
		List<TeacherDefaultHoliday> list = query(sql, this, new Object[]{teacherId});
		return list.isEmpty()? null: list.get(0);
	}

	public void add(final TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "insert into " + getTableName() + "(teacherid,week1,week2,week3,week4,week5,week6,week7) values("
				+ "?, ?,?,?,?,?,?,?)";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherDefaultHoliday.getId());
				ps.setBoolean(2, teacherDefaultHoliday.getWeek1());
				ps.setBoolean(3, teacherDefaultHoliday.getWeek2());
				ps.setBoolean(4, teacherDefaultHoliday.getWeek3());
				ps.setBoolean(5, teacherDefaultHoliday.getWeek4());
				ps.setBoolean(6, teacherDefaultHoliday.getWeek5());
				ps.setBoolean(7, teacherDefaultHoliday.getWeek6());
				ps.setBoolean(8, teacherDefaultHoliday.getWeek7());
			}
		};
		update(sql, setter);
		teacherDefaultHoliday.setId(mysql_insert_id());
	}
	
	public void update(final TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=?, week1=?, week2=?, week3=?, week4=?, " +
                "week5=?, week6=?, week7=? where id = ?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherDefaultHoliday.getId());
				ps.setBoolean(2, teacherDefaultHoliday.getWeek1());
				ps.setBoolean(3, teacherDefaultHoliday.getWeek2());
				ps.setBoolean(4, teacherDefaultHoliday.getWeek3());
				ps.setBoolean(5, teacherDefaultHoliday.getWeek4());
				ps.setBoolean(6, teacherDefaultHoliday.getWeek5());
				ps.setBoolean(7, teacherDefaultHoliday.getWeek6());
				ps.setBoolean(8, teacherDefaultHoliday.getWeek7());
				ps.setInt(9, teacherDefaultHoliday.getId());
			}
		};
		update(sql, setter);
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from " + getTableName() + " where teacherid = ?";
		update(sql, new Object[]{teacherId});
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherdefaultholiday";
	}
	
}
