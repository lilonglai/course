package com.kevin.course.operation.db.basic;

import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTeacherHolidayDao extends JdbcBaseDao<TeacherHoliday> implements ITeacherHolidayOperation {
	protected TeacherHoliday generateObject(ResultSet rs) throws SQLException{
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setId(rs.getInt("id"));
		teacherHoliday.setTeacherId(rs.getInt("teacherid"));
		teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
		teacherHoliday.setIsHoliday(rs.getBoolean("isholiday"));
		return teacherHoliday;
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		String sql = "select * from " + getTableName() + " where teacherid = ?";
		return query(sql, this, new Object[]{teacherId});
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String adjustDate) {
		String sql = "select * from " + getTableName() + " where teacherid = ? and adjustdate=?";
		List<TeacherHoliday> list = query(sql, this, new Object[]{teacherId, adjustDate});
		return list.isEmpty()? null: list.get(0);
	}

	public void add(final TeacherHoliday teacherHoliday) {
		String sql = "insert into " + getTableName() + "(teacherid,adjustdate,isholiday) values(" +
                "?, ?, ?)";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherHoliday.getId());
				ps.setDate(2, teacherHoliday.getAdjustDate());
				ps.setBoolean(3, teacherHoliday.getIsHoliday());
			}
		};
		update(sql, setter);
        teacherHoliday.setId(mysql_insert_id());
	}

	public void update(final TeacherHoliday teacherHoliday) {
		String sql = "update " + getTableName() + " set teacherid=?, adjustdate=?, isholiday=? " +
                "where id = ?";
		PreparedStatementSetter setter = new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, teacherHoliday.getId());
				ps.setDate(2, teacherHoliday.getAdjustDate());
				ps.setBoolean(3, teacherHoliday.getIsHoliday());
				ps.setInt(4, teacherHoliday.getId());
			}
		};
		update(sql, setter);
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherholiday";
	}

}
