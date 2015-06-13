package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.operation.db.ITeacherHolidayOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTeacherHolidayOperation extends JdbcBaseOperation<TeacherHoliday> implements ITeacherHolidayOperation {
	protected TeacherHoliday generateObject(ResultSet rs) throws SQLException{
		TeacherHoliday teacherHoliday = new TeacherHoliday();
		teacherHoliday.setId(rs.getInt("id"));
		teacherHoliday.setTeacherId(rs.getInt("teacherid"));
		teacherHoliday.setAdjustDate(rs.getDate("adjustdate"));
		teacherHoliday.setIsHoliday(rs.getBoolean("isholiday"));
		return teacherHoliday;
	}
	
	public List<TeacherHoliday> getByTeacherId(int teacherId) {
		String sql = "select * from " + getTableName() + " where teacherid = :teacherId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
			return executeSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public TeacherHoliday getByTeacherAndDate(int teacherId,String adjustDate) {
		String sql = "select * from " + getTableName() + " where teacherid = :teacherId and adjustdate=:adjustDate";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
        map.put("adjustDate", adjustDate);
		try {
            List<TeacherHoliday> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public void add(TeacherHoliday teacherHoliday) {
		String sql = "insert into " + getTableName() + "(teacherid,adjustdate,isholiday) values(" +
                ":teacherid, :adjustDate, :isHoliday)";
        Map<String, Object> map = createMap(teacherHoliday);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public void update(TeacherHoliday teacherHoliday) {
		String sql = "update " + getTableName() + " set teacherid=:teacherId, adjustdate=:adjustDate, isholiday=:isHoliday " +
                "where id = :id";
        Map<String, Object> map = createMap(teacherHoliday);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	@Override
	protected String getTableName() {
		return "aeas_teacherholiday";
	}

}
