package com.kevin.course.operation.db.basic;

import com.kevin.course.object.BasicException;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.operation.db.ITeacherDefaultHolidayOperation;
import com.kevin.course.utils.TableName;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTeacherDefaultHolidayOperation extends JdbcBaseOperation<TeacherDefaultHoliday> implements ITeacherDefaultHolidayOperation {
	
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
		String sql = "select * from " + getTableName() + " where teacherid = :teacherId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
            List<TeacherDefaultHoliday> list = executeSql(sql, map);
            return list.size() > 0? list.get(0): null;
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	public void add(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "insert into " + getTableName() + "(teacherid,week1,week2,week3,week4,week5,week6,week7) values("
				+ ":teacherId, :week1,:week2,:week3,:week4,:week5,:week6,:week7)";
        Map<String, Object> map = createMap(teacherDefaultHoliday);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}		
	}
	
	public void update(TeacherDefaultHoliday teacherDefaultHoliday){
		String sql = "update " + getTableName() + " set "
				+ "teacherid=:teacherId, week1=:week1, week2=:week2, week3=:week3, week4=:week4, " +
                "week5=:week5, week6=:week6, week7=:week7 where id = :id";
        Map<String, Object> map = createMap(teacherDefaultHoliday);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}
	
	public void deleteByTeacherId(int teacherId){
		String sql = "delete from " + getTableName() + " where teacherid = :teacherId";
        HashMap<String, Object> map = new HashMap<>();
        map.put("teacherId", teacherId);
		try {
			executeUpdateSql(sql, map);
		} catch (SQLException e) {
            throw new BasicException(e);
		}
	}

	@Override
	protected String getTableName() {
		return TableName.TEACHERDEFAULTHOLIDAY;
	}
	
}
